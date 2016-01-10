package javalanguage.collections;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * 本程序用于观察一个使用Collections.synchronizedMap方法包装了其内部Map对象的类对象Drain。
 * 在主线程中先new一个Drain对象，初始化添加四条Map的Entry,然后创建三个子线程用于iterate这个
 * Drain对象。三个线程间隔1秒，开完线程并启动后再在主线程对Drain对象的Map进行添加操作，发现三个子线程中
 * 在发现Drain对象Map的Entry更改过后，抛出了java.util.ConcurrentModificationException，
 * 并停止。
 * 
 * 值得注意的是，运行该程序100次，有50次左右会三个线程都抛ConcurrentModificationException停止；
 * 50次左右会有两个抛ConcurrentModificationException停止而另外一个一直运行，并且该线程能看到
 * 新修改的 Drain对象Map的Entry。
 * 
 * 正如文档所说，ConcurrentModificationException异常只是尽力而为抛出，程序不能依靠它来做逻辑处理。
 * 
 * 即使在main方法和CountThread中对 Drain对象Map对象采用 Drain对象采用synchronized仍无济于事。
 * Collection不允许在迭代过程并发修改它。
 * 
 * @author xu
 *
 */
public class UnThreadSafeUsingSynchronizedMap {

    
    public static void main(String[] args) {
    	DrainObject drain = new DrainObject();
    	Map m1 = drain.returnSynHashMap();

    	final UnThreadSafeUsingSynchronizedMap mlmd = new UnThreadSafeUsingSynchronizedMap();
    	m1.put("North", "玄武");
    	m1.put("South", "朱雀");
    	m1.put("East", "青龙");
    	m1.put("West", "白虎");
    	System.out.println("【"+Thread.currentThread().getName()+"】"+m1.keySet().size());
    	
    	for(int i=0;i<3;i++){
    		new BusinessThread("【线程"+i+"】",drain).start();
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
   

    	System.out.println("并发地向Map添加新条目。");
    	 	
    	m1.put("blah", "deliberate");
    	 	
    	System.out.println("Done.");
	}
   
   static class DrainObject {

    	private Map hm = new HashMap();
    	
    	public Map returnSynHashMap(){
    		return Collections.synchronizedMap(hm);
    	}
    	
    }
    
   static class BusinessThread extends Thread{
	   String name = null;
	   DrainObject drain = null;
	   
	   public BusinessThread(String name,DrainObject drain){
		   this.name = name;
		   this.drain = drain;
	   }
    	@Override
    	public void run(){
			while(true){			
				Map map = drain.returnSynHashMap();	

				for(Object o:map.keySet()){
					System.out.println(name+"-----------iterate--------------"+map.keySet().size());
					System.out.println(name+o+"="+map.get(o));
	    			try {
						Thread.sleep(500);
					} 
	    			catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
    	}
    }
    
}



 

