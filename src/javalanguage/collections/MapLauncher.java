package javalanguage.collections;

import java.util.HashMap;
import java.util.Map;

public class MapLauncher {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("t1", "武昌到北京");
		map.put("rgg", "t3");
		map.put("g2223", "cc72342");
		
		for(String key :map.keySet()){
			System.out.println(key+"="+map.get(key));
		}
		System.out.println("-------------1---------------");
		map.remove("rgg");
		for(String key :map.keySet()){
			System.out.println(key+"="+map.get(key));
		}
		System.out.println("-------------2---------------");
		//带条件的remove
		map.remove("t1","武昌到北京2222");
		for(String key :map.keySet()){
			System.out.println(key+"="+map.get(key));
		}
	}

}
