package javalanguage.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 通配符泛型 {

	public static void main(String[] args) {
		//无法将任何元素（null除外）放进无限制通配符泛型
		Set<?> set = new HashSet<String>();
		//set.add(new String("abc"));编译错误
		set.add(null);
		//从无限制通配符泛型集合取出元素对象类型一定是Object，只能强转成需要的类型
		String s = (String)set.iterator().next();
		System.out.println(s);
		System.out.println("-------------------------------------------");
/*		List<?> list0 = new ArrayList<String>();
		list0.add(null);
		Object elment = list0.get(0);
		System.out.println(elment);*/
		
		//直接点，来看
		List<Object> list = new ArrayList<Object>();
		list.add("can compile");
		list.add(new Object());
		list.add(5);
		list.add(new Integer(3));
		for(Object o :list){
			System.out.println(o.getClass()+",,,"+o);
		}
		
		System.out.println("===========================================");
		
		List<Number> list2 = new ArrayList<Number>();
		list2.add(777l);
		list2.add(888);
//		list2.add("n");//编译错误:The method add(Number) in the type List<Number> is not applicable for the arguments (String)
		for(Number o :list2){
			System.out.println(o.getClass()+"。。。"+o);
		}
		

		

	}
	


	
}
