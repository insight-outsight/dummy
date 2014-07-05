package javalanguage.死锁活锁饥饿等;

/**
 * Starvation
 * Starvation describes a situation where a thread is unable to gain regular access to 
 * shared resources and is unable to make progress. This happens when shared resources 
 * are made unavailable for long periods by "greedy" threads. For example, suppose an 
 * object provides a synchronized method that often takes a long time to return. If one 
 * thread invokes this method frequently, other threads that also need frequent 
 * synchronized access to the same object will often be blocked.
 * 
 * @author zcx
 * @Ref http://docs.oracle.com/javase/tutorial/essential/concurrency/starvelive.html
 */
public class Starvation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
