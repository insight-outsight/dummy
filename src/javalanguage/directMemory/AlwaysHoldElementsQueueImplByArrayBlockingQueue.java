package javalanguage.directMemory;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import commons.pojo.User;


/**
 * 
 * 
 * 
 * Java简单实现固定长度队列（FIFO）
 * @author u0007
 *
 * @param <T>
 */
public class AlwaysHoldElementsQueueImplByArrayBlockingQueue<T> implements AlwaysHoldElementsQueue<T> {  
	
	
    public static void main(String[] args) {  
    	AlwaysHoldElementsQueue<User> fifo = new AlwaysHoldElementsQueueImplByArrayBlockingQueue<User>(5);  
        for (int i = 0; i < 20; i++) {  
        	User a = new User(i,"A:" + i);  
        	User kicked = fifo.offer(a);
            System.out.println(i + "\tkicked:" + kicked + "\tsize:" + fifo.getSize());  
        }  
  
        System.out.println("---------------");  
  
        System.out.println("弹出数据"); 
        int j=0;
        User b = null;
        for (;(b=fifo.poll())!=null;) {  
            System.out.println(j+++"\tpoped:" + b + ",size()="+fifo.getSize());  
        }  

    }  
    
  
    /**
	 * 
	 */
	private static final long serialVersionUID = -3577310439222212478L;

	private final static int DEFAULT_MAX_SIZE = 16;
    
    private final Queue<T> innerQueue;
    
	private int maxSize;
  
    public AlwaysHoldElementsQueueImplByArrayBlockingQueue() {  
        super();
        innerQueue = new ArrayBlockingQueue<T>(DEFAULT_MAX_SIZE);
        this.maxSize = DEFAULT_MAX_SIZE;
    }  
  
    public AlwaysHoldElementsQueueImplByArrayBlockingQueue(int maxSize) {  
        super();  
        this.maxSize = maxSize;  
        innerQueue = new ArrayBlockingQueue<T>(maxSize);
    }


	@Override
	public T offer(T element) {
		T removedElement = null;
		while(!innerQueue.offer(element)){
			removedElement = innerQueue.poll();
		}
		return removedElement;
	}

	@Override
	public T poll() {
		return innerQueue.poll();
	}

	@Override
	public int getSize() {
		return innerQueue.size();
	}
	
    @Override  
    public int getMaxSize() {  
        return this.maxSize;  
    }
    
} 


interface AlwaysHoldElementsQueue<T> extends Cloneable,Serializable {  
	  
    /** 
     * 向最后添加一个新的元素，如果长度超过允许的最大值，则弹出头部元素，
     * 该方法总是成功
     * @param element 添加成功的元素
     * @return 如果因为队列满，而弹出了头部元素，返回弹出的元素，否则返回null
     */  
    T offer(T element);  
  
    /** 
     * 弹出head，如果size = 0返回null。而不同于pop抛出异常 
     * @return  弹出的元素
     */  
    T poll();  
  
    /** 
     * 获得当前队列长度
     * 
     * @return 
     */  
    int getSize();  
  
    /** 
     * 获得当前队列最大容量
     * 
     * @return 
     */  
    int getMaxSize();  

  
}  