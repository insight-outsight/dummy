package javalanguage.collections;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class LinkedHashMapLauncher {

	   
	public static void main(String args[]) {

		//HashMap不能保证遍历时能按put顺序
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("t1", "武昌到北京");
		map.put("rgg", 3);
		map.put("2223", 72342);
		map.put("areyouOk", true);
		map.put(2223, 723428l);
		
		for(Object key :map.keySet()){
			Object value = map.get(key);
			System.out.print("键："+key + "		类型："+key.getClass().getName()+"        ");
			System.out.println("值："+value + "	类型："+value.getClass().getName());
		}
		
		Map<Object,Object> linkedMap = new LinkedHashMap<Object,Object>(map);
		for(Object key :linkedMap.keySet()){
			Object value = linkedMap.get(key);
			System.out.print("LinkedHashMap键："+key + "		LinkedHashMap类型："+key.getClass().getName()+"        ");
			System.out.println("LinkedHashMap值："+value + "	LinkedHashMap类型："+value.getClass().getName());
		}
		System.out.println("===========================*****==========================");
		linkedMap.put("1b","2b");
		linkedMap.put("sb","4b");
		linkedMap.put("5b","8bw44");
		linkedMap.put("goodevening","at 2015-01-14");
		//LinkedHashMap能保证遍历时能按put顺序,但初始化时传入的Map项保存为原顺序。
		for(Object key :linkedMap.keySet()){
			Object value = linkedMap.get(key);
			System.out.print("LinkedHashMap键："+key + "		LinkedHashMap类型："+key.getClass().getName()+"        ");
			System.out.println("LinkedHashMap值："+value + "	LinkedHashMap类型："+value.getClass().getName());
		}
	}
}
