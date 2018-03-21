package design_pattern.chain_of_responsibility.style3;

import java.util.HashMap;
import java.util.Map;

public class Launcher {

	public static void main(String[] args) {
		
		 Map<String,Integer> map = new HashMap<String,Integer>();
		 //给 map对象添加Plugin形式的拦截器，返回被Plugin动态代理后的对象
		 map = (Map<String,Integer>)new ExamplePlugin().plugin(map);
		 map = (Map<String,Integer>)new ExamplePlugin2().plugin(map);
		 System.out.println(map.get(""));

	}

}
