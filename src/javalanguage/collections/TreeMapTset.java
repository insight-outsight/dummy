package javalanguage.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class TreeMapTset {

	public static void main(String[] args) {
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String[] dates = { "a5","f7","e2","dg5","e2","dh7","10/31/01", "01/01/01", "03/05/01", "02/04/01", "05/04/23" };
		String[] items = { "yi","er","san","si","wu","daile","Halloween", "New Years", "Birthday", "Anniversary", "造业!!!!!" };
		
		Map<String,String> calendarMap = new TreeMap<String,String> ();

		for (int x = 0; x < dates.length; x++){
			calendarMap.put(dates[x], items[x]);
		}
		
		System.out.println("calendarMap内容x是"+ calendarMap);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

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
		System.out.println("-------------------------------------------------------");
		Map<String,String> map = new HashMap<String,String>();
		map.put("yi", "as");
		map.put("er", "its");
		map.put("san", "logsal");
		map.put("si", "froc");
		map.put("wu", "gh");
		for(String k :map.keySet()){
			System.out.println(k+"===="+map.get(k));
		}
		System.out.println("*******************************************************");
    	Map<String,String> treemap = new TreeMap<String,String>(map);
		for(String k :treemap.keySet()){
			System.out.println(k+"===="+treemap.get(k));
		}

	}

}
