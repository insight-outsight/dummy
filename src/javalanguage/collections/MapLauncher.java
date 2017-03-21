package javalanguage.collections;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class MapLauncher {

	   
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
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String[] dates = { "a5","f7","e2","d5","e2","10/31/01", "01/01/01", "03/05/01", "02/04/01", "05/04/23" };
		String[] items = { "yi","er","san","si","wu","Halloween", "New Years", "Birthday", "Anniversary", "造业!!!!!" };
		
		Map<String,String> calendarMap = new TreeMap<String,String> ();

		for (int x = 0; x < dates.length; x++){
			calendarMap.put(dates[x], items[x]);
		}
		
		System.out.println("calendarMap内容x是"+ calendarMap);
		
		Set<Map.Entry<String,String>> mappingEntrys = calendarMap.entrySet();
		System.out.println("object \t\t\tkey\t\tvalue");

		for (Iterator<Map.Entry<String,String>> i = mappingEntrys.iterator(); i.hasNext();) {
			Map.Entry<String,String> me = (Map.Entry<String,String>) i.next();
			Object ok = me.getKey();
			Object ov = me.getValue();
			System.out.print(me + "\t");
			System.out.print(ok + "\t");
			System.out.println(ov);
		}
		System.out.println("-------------------------------------------------------");
		Set<String> sim = calendarMap.keySet();
		for(String sk : sim)
			System.out.println(sk+"[]"+calendarMap.get(sk));
	}
}
