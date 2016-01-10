package javalanguage.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;



public class CollectionLauncher {

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
		for(Iterator<String> ii = ccc.iterator();ii.hasNext();){
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
		
	}
	
}
