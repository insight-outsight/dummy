package javalanguage.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class 泛型方法 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		Me722 mb = new Me722();
		System.out.println( mb.returnCh().getGenericType() );
		List<String> li = mb.listObjects();
		for(String wet :li){
			System.out.println( wet);	
		}*/
		
		Map m = new 泛型方法().sm();
		System.out.println(m);
		
		String s = new 泛型方法().sm();
		System.out.println(s);
		
		List l = new 泛型方法().getExtensions(String.class);
		System.out.println(l.size());
		
		
		Set<String> s1 = new HashSet<String>();
		s1.add("jjj");
		s1.add("bbb2");
		
		Set<Integer> s2 = new HashSet<Integer>();
		s2.add(879879);
		s2.add(454654645);
		
		Set<Long> s3 = new HashSet<Long>();
		s3.add(1111222l);
		s3.add(3333333333334l);
		
		Set<String> s12 = union(s1,s2,s2);
	}
	
	/**以下三个为泛型方法，注意写法.Plus:更经典的泛型方法见java.util.Arrays.copyOf()方法**/
	public <T extends Object> T sm() {
		final int et = 5;
		return null;
	}
	public <R> R sm(R[] atg) {
		final int et = 5;
		R r= atg[0];
		return r;
	}
	
	<D> List<D> getExtensions(Class<D> extensionType){
		List<D> l = new ArrayList<D>(3);
		return l;
	}
	
	/**普通方法**/
	List<String> getLists(){
		return new ArrayList<String>();
	}

	
	public static <E,T,Y> Set<E> union(Set<E> s1,Set<T> s2,Set<Y> s3){
		Set<E> result = new HashSet<E>(s1);
		for(E e:s1){
			System.out.println("E--"+e);
		}
		for(T e:s2){
			System.out.println("T--"+e);
		}
		for(Y e:s3){
			System.out.println("Y--"+e);
		}
		return result;
	}
	
}
