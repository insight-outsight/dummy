package javalanguage.generic;

import java.util.HashMap;
import java.util.Map;

public class 泛型静态工厂 {

	public static <KEY,VALUE> Map<KEY,VALUE> createHashMap(){
		return new HashMap<KEY,VALUE>();
	}
	
	public static void main(String[] args) {
		Map<String,Integer> m = createHashMap();
		m.put("jb", 2013);
		System.out.println(m.get("jb"));
		
		
	}
	
}