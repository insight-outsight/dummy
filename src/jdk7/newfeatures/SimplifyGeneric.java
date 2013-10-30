package jdk7.newfeatures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimplifyGeneric {

	public static void main(String[] args) {
		
		//例如 
		//Map<String, List<String>> myMap = new HashMap<String, List<String>>();
		//可以简化为
		Map<String, List<String>> myMap = new HashMap<>();
		System.out.println(myMap.size());
		System.out.println("bad girl.1990");
	}

}
