package javalanguage.util.cocurrent.locks;

/**
 * Created by MOMO on 16/8/29.
 */
public class Racer1  extends RaceBase {

	@Override
	protected void exec() throws InterruptedException {
        lock.lock();
        try {
                while (i.get()%2==0){
                    oddCondition.await();
                }

                System.out.println("odd num-"+i.getAndIncrement());

                evenCondition.signal();
        } finally {
            lock.unlock();
        }		
	}

}
