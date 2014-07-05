package javalanguage.collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class MapLauncher {

	Map<String,String> calendar = new TreeMap<String,String> ();
	private int y6 = 7;
	
	public MapLauncher(String d[], String i[]) {
		for (int x = 0; x < d.length; x++)
			calendar.put(d[x], i[x]);
	}

	public static void main(String args[]) {

		
		Collection<String> ccc = new HashSet<String>();
		ccc.add("已付吃");
		ccc.add("9.55");
		ccc.add("5w5252");
		ccc.add("饭 了");
		ccc.add("22点11分");
		ccc.add("haha,,,");
		for(String v:ccc){
			System.out.println("------dou-"+v);
		}
		for(Iterator ii = ccc.iterator();ii.hasNext();){
			System.out.println(ii.next());
		}
		
		List<String> list = new ArrayList<String>();
		list.add("这是什么");
		list.add("格式合适wedsfsf");
		list.add("235");
		list.add("肚皮舞标准");
		list.add("010-0000000");
		list.add("百花从中过，片叶不沾身。");
		for(int i=0;i<list.size();i++){
			System.out.println("list----->"+list.get(i));
		}
		for(int i=0;i<5;i++){
			System.out.println("ggg");
		}
		
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("t1", "武昌到北京");
		map.put("rgg", 3);
		map.put("2223", 72342);
		map.put("areyouOk", true);
		
		for(Object key :map.keySet()){
			Object value = map.get(key);
			System.out.println("值："+value + "        类型："+value.getClass().getName());
		}
		
/*		String[] dates = { "10/31/01", "01/01/01", "03/05/01", "02/04/01", "05/04/23" };
		String[] items = { "Halloween", "New Years", "Birthday", "Anniversary", "造业!!!!!" };
		MapLauncher example = new MapLauncher(dates, items);

		System.out.println("map= " + example.calendar);
		
		Set mappings = example.calendar.entrySet();
		System.out.println("object \t\t\tkey\t\tvalue");

		for (Iterator i = mappings.iterator(); i.hasNext();) {
			Map.Entry me = (Map.Entry) i.next();
			Object ok = me.getKey();
			Object ov = me.getValue();
			System.out.print(me + "\t");
			System.out.print(ok + "\t");
			System.out.println(ov);
		}
		System.out.println("==========*****==========");
		Set<String> sim = example.calendar.keySet();
		for(String sk : sim)
			System.out.println(sk+"[]"+example.calendar.get(sk));*/
	}
}
