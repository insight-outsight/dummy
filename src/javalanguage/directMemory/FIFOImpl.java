package javalanguage.directMemory;


/**
 * 
 * 
 * 
 * Java简单实现固定长度队列（FIFO）

 * 
 * @Reference   http://blog.csdn.net/eclipser1987/article/details/10440573
 * @author u0007
 *
 * @param <T>
 */
class FIFOImpl<T> extends LinkedList<T> implements FIFO<T> {  
  
    private int maxSize = Integer.MAX_VALUE;  
    private final Object synObj = new Object();  
  
    public FIFOImpl() {  
        super();  
    }  
  
    public FIFOImpl(int maxSize) {  
        super();  
        this.maxSize = maxSize;  
    }  
  
    @Override  
    public T addLastSafe(T addLast) {  
        synchronized (synObj) {  
            T head = null;  
            while (size() >= maxSize) {  
                head = poll();  
            }  
            addLast(addLast);  
            return head;  
        }  
    }  
  
    @Override  
    public T pollSafe() {  
        synchronized (synObj) {  
            return poll();  
        }  
    }  
  
    @Override  
    public List<T> setMaxSize(int maxSize) {  
        List<T> list = null;  
        if (maxSize < this.maxSize) {  
            list = new ArrayList<T>();  
            synchronized (synObj) {  
                while (size() > maxSize) {  
                    list.add(poll());  
                }  
            }  
        }  
        this.maxSize = maxSize;  
        return list;  
    }  
  
    @Override  
    public int getMaxSize() {  
        return this.maxSize;  
    }  
}  