package jdk8.newfeatures.time.completable_future;

import java.util.function.Supplier;

public class AccumulateNumberSupplier implements Supplier<Integer> {
    private Integer num = null;
    private long sleepMs = 0;
    public AccumulateNumberSupplier(Integer num,long sleepMs) {
        this.num = num;
        this.sleepMs = sleepMs;
    }
    @Override
    public Integer get() {
        try {
            Thread.sleep(sleepMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.num;
    }
}