package jdk8.newfeatures.time.completable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableCombineTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> oddNumber = CompletableFuture
                .supplyAsync(new AccumulateNumberSupplier(1 + 3 + 5 + 7 + 9,1000));
        CompletableFuture<Integer> evenNumber = CompletableFuture
                .supplyAsync(new AccumulateNumberSupplier(2 + 4 + 6 + 8 + 10,3000));
        long startTime = System.currentTimeMillis();
        CompletableFuture<Integer> resultFuture = oddNumber.thenCombine(evenNumber, (odd, even) -> {
            return odd + even;
        });
        System.out.println("get result前耗时："+(System.currentTimeMillis() - startTime) + "毫秒");
        //get()时才会真正开始执行，并且执行和合并结果是多线程并发执行的
        System.out.println(resultFuture.get());

        System.out.println("get result共耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");
        
        //再加一个异步任务
        oddNumber = CompletableFuture
                .supplyAsync(new AccumulateNumberSupplier(1 + 3 + 5 + 7 + 9,1000));
        evenNumber = CompletableFuture
                .supplyAsync(new AccumulateNumberSupplier(2 + 4 + 6 + 8 + 10,3000));
        CompletableFuture<Integer> thridNumber = CompletableFuture
                .supplyAsync(new AccumulateNumberSupplier(100000,4000));
        resultFuture = oddNumber.thenCombine(evenNumber, (odd, even) -> {
            return odd + even;
        }).thenCombine(thridNumber, (result1, result2) -> {
            return result1 + result2;
        });
        startTime = System.currentTimeMillis();
        System.out.println(resultFuture.get());
        System.out.println("get 3 result共耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");

        //两个子线程还不够，那么还有allOff()函数，可以承受多个CompletableFuture，会等待所有任
        //务都完成。
//        CompletableFuture.allOf(cfs)
        //是当第一个执行结束的时候，就结束，后面任务不再等了。
//        CompletableFuture.anyOf(cfs)
        
        CompletableFuture.supplyAsync(() -> "Hello")
            .thenApply(s -> s+ " World")
            .thenApply(String::toUpperCase)
            .thenCombine(CompletableFuture.completedFuture(", Java"),(s1,s2) -> s1+s2)
            .thenAccept(System.out::println);
        
        String[] list = {"a", "b", "c"};
        List<CompletableFuture<String>> resultList = new ArrayList<>();
         
        for(String str:list) {
            resultList.add(CompletableFuture.supplyAsync(() -> str)
                    .thenApply(e -> e.toUpperCase()));

            CompletableFuture.allOf(resultList.toArray(
                    new CompletableFuture[resultList.size()]))
                .whenComplete((r,e) -> {
                    if(null == e){
                    }
                    else {
                        throw new RuntimeException(e);
                    }
            });
        }
    }
}