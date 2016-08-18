package javalanguage.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 实现Map按Value排序等 
 * 
 * 参考：http://blog.csdn.net/wangtao6791842/article/details/12904467
 * @author u0007
 *
 */
public class MapUtils {
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(
				map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	
	
	public static <K> TreeMap<K,Double> sortDoubleValue(Map<K,Double> map,boolean asc){
	     DoubleValueComparator<K> comparator =  new DoubleValueComparator(map,asc);  
	     TreeMap<K,Double> sortedMap = new TreeMap<K,Double>(comparator);  
	     sortedMap.putAll(map);  
	     return sortedMap;
	}
	
	public static <K> TreeMap<K,Integer> sortIntegerValue(Map<K,Integer> map,boolean asc){
		IntegerValueComparator<K> comparator =  new IntegerValueComparator(map,asc);  
		TreeMap<K,Integer> sortedMap = new TreeMap<K,Integer>(comparator);  
		sortedMap.putAll(map);  
		return sortedMap;
	}
	
	private static class DoubleValueComparator<T> implements Comparator<T> {  
		  
	    protected Map<T, Double> base;  
	    private boolean asc;
	    
	    protected DoubleValueComparator(Map<T, Double> base,boolean asc) {  
	        this.base = base;  
	        this.asc = asc;
	    }  
	  
	    // Note: this comparator imposes orderings that are inconsistent with equals. 
	    @Override
	    public int compare(T a, T b) {  
	        if (base.get(a)>=base.get(b)) { 
	        	if(!asc){
	        		return -1;
	        	}
	        	else{
	        		return 1;
	        	}
	        } 
	        else {  
	        	if(!asc){
		            return 1;  // Note: returning 0 would merge keys  
	        	}
	        	else{
	        		return -1;
	        	}
	        } 
	    }  
	    
	}
	
	private static class IntegerValueComparator<T> implements Comparator<T> {  
		  
	    protected Map<T, Integer> base;  
	    private boolean asc;
	    
	    protected IntegerValueComparator(Map<T, Integer> base,boolean asc) {  
	        this.base = base;  
	        this.asc = asc;
	    }  
	  
	    // Note: this comparator imposes orderings that are inconsistent with equals. 
	    @Override
	    public int compare(T a, T b) {  
	    	 if (base.get(a)>=base.get(b)) { 
		        	if(!asc){
		        		return -1;
		        	}
		        	else{
		        		return 1;
		        	}
		        } 
		        else {  
		        	if(!asc){
			            return 1;  // Note: returning 0 would merge keys  
		        	}
		        	else{
		        		return -1;
		        	}
		        }
	    }  
	    
	}
	
}
