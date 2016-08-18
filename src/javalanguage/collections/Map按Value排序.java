package javalanguage.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Map按Value排序 {

	public static void main(String[] args) {

	/*	 HashMap<String,Double> map = new HashMap<String,Double>();  

	        map.put("A",99.5);  
	        map.put("B",67.4);  
	        map.put("C",67.4);  
	        map.put("D",67.3);  
	        map.put("R",101.99);  
	        map.put("F",88.60);  */
		 HashMap<String,Integer> map = new HashMap<String,Integer>();  

	        map.put("A",995);  
	        map.put("B",674);  
	        map.put("C",674);  
	        map.put("D",3);  
	        map.put("R",10199);  
	        map.put("F",80);  
	        
	        System.out.println("unsorted map: "+map);  
	  
	  
	        System.out.println("results: "+MapUtils.sortIntegerValue(map,true));
	        System.out.println("results: "+MapUtils.sortIntegerValue(map,false));
	        
	        System.out.println("anohter method results: "+MapUtils.sortByValue(map));


	}
	


}
