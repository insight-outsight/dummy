package jdk8.newfeatures.time.completable_future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final int evenNumber = 2 + 4 + 6 + 8 + 10;
        CompletableFuture<Integer> oddNumber = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1+3+5+7+9;
        });
        try {
            Thread.sleep(1500);
            System.out.println("0.开始了："+ (System.currentTimeMillis()-startTime) +"秒");
            //这里实现了回调，如果不需要回调，只使用oddNumber.get()完全就可以获取异步执行结果了
            oddNumber.thenAccept(oddNumberResult->
                        {
                            System.out.println("3.开始了："+ (System.currentTimeMillis()-startTime) +"秒");
                            System.out.println("此时计算结果为："+(evenNumber+oddNumberResult));
                        });
            System.out.println("1.开始了："+ (System.currentTimeMillis()-startTime) +"秒");

            System.out.println("2.getResult："+ oddNumber.get()+","+(System.currentTimeMillis()-startTime));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}