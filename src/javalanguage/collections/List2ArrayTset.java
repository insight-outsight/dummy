package javalanguage.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class List2ArrayTset {

	public static void main(String[] args) {
		Object[] l2 = new Object[3];
		l2[0]=3;
		l2[1]="jiu";
		l2[2]=new int[]{4,6};
		for(Object li:l2){
			System.out.println(li.getClass());
			System.out.println(li);
		}
		Set s = new HashSet();
		s.add("bbb");
		s.add(777);
		for(Object si :s){
			System.out.println(si.getClass()+","+((String)si));
		}
		List<String> l = new ArrayList<>();
		l.add("eee");
		l.add("yyy");
		Object[] ay1 = l.toArray();
		for(int i=0;i<ay1.length;i++){
			System.out.println("type:"+ay1[i].getClass().getName()+",value:"+ay1[i]);			
		}
		String[] ddd = new String[l.size()];
		String[] ay2 = l.toArray(ddd);
		for(int i=0;i<ddd.length;i++){
			System.out.println("type:"+ddd[i].getClass().getName()+",value:"+ddd[i]);			
		}
		for(int i=0;i<ay2.length;i++){
			System.out.println("type:"+ay2[i].getClass().getName()+",value:"+ay2[i]);			
		}
		System.out.println(ddd == ay2);
	}

}
