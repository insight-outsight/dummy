package javalanguage.死锁活锁饥饿等;


/**
 * Livelock
 * 
 * A thread often acts in response to the action of another thread. If the other thread's
 *  action is also a response to the action of another thread, then livelock may result. 
 *  As with deadlock, livelocked threads are unable to make further progress. However, 
 *  the threads are not blocked — they are simply too busy responding to each other to 
 *  resume work. This is comparable to two people attempting to pass each other in a 
 *  corridor: Alphonse moves to his left to let Gaston pass, while Gaston moves to his 
 *  right to let Alphonse pass. Seeing that they are still blocking each other, Alphone 
 *  moves to his right, while Gaston moves to his left. They're still blocking each other,
 *   so...
 * @author zcx
 * @AnnotationRef http://docs.oracle.com/javase/tutorial/essential/concurrency/starvelive.html
 * @CodeRefer http://stackoverflow.com/questions/1036364/good-example-of-livelock
 */
public class LiveLockDemo2 {

	public static void main(String[] args) throws InterruptedException {
        Object left = new Object();
        Object right = new Object();
        Pedestrian one = new Pedestrian(left, right, 0); //one's left is one's left
        Pedestrian two = new Pedestrian(right, left, 1); //one's left is two's right, so have to swap order
        one.setOther(two);
        two.setOther(one);
        one.start();
        two.start();
    }
	
}

class Pedestrian extends Thread {
    private Object l;
    private Object r;
    private Pedestrian other;
    private Object current;

    Pedestrian (Object left, Object right, int firstDirection) {
        l = left;
        r = right;
        if (firstDirection==0) {
            current = l;
        }
        else {
            current = r;
        }
    }

    void setOther(Pedestrian otherP) {
        other = otherP;
    }

    Object getDirection() {
        return current;
    }

    Object getOppositeDirection() {
        if (current.equals(l)) {
            return r;
        }
        else {
            return l;
        }
    }

    void switchDirection() throws InterruptedException {
        Thread.sleep(100);
        current = getOppositeDirection();
        System.out.println(Thread.currentThread().getName() + " is stepping aside.");
    }

    public void run() {
        while (getDirection().equals(other.getDirection())) {
            try {
                switchDirection();
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
} 