package javalanguage.util.cocurrent.locks;

/**
 * Created by MOMO on 16/8/29.
 */
public class Racer2 extends RaceBase {
	
	@Override
	protected void exec() throws InterruptedException {
        lock.lock();
        try {
                while (i.get()%2==1){
                    evenCondition.await();
                }

                System.out.println("enven num-"+i.getAndIncrement());

                oddCondition.signal();
        } finally {
            lock.unlock();
        }		
	}
	
}
