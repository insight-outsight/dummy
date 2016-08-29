package javalanguage.util.cocurrent.locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by MOMO on 2016/8/29.
 * IDEA
 */
public abstract class RaceBase {
    protected final static Lock lock = new ReentrantLock();
    final static Condition oddCondition  = lock.newCondition();
    final static Condition evenCondition  = lock.newCondition();
    protected static AtomicInteger i = new AtomicInteger(0);
    
    protected abstract void exec() throws InterruptedException;
    
}