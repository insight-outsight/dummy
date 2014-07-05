package javalanguage.ref;

import java.lang.ref.SoftReference;

public class SoftReferenceCachePrototype {
	
	public static void main(String[] args) {
		
	    Object obj = new Object();  
	    SoftReference<Object> softRef = new SoftReference<Object>(obj);  
	    obj = null;   
	    
		Object obj2;  
		obj2 = softRef.get();  
		if (obj2 == null) {
			// GC freed this  
			softRef = new SoftReference<Object>(obj2 = new Object()); 
			/**
			 * Do not write like this
			 * 
			 * sr = new SoftReference<Object>(new Object());  
			 * obj2 = sr.get(); 
			 * 
			 * Because GC may happen between those two statement above,if then
			 * obj2 still null.
			 */
		}			 
	}
	
}
