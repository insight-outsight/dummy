package javalanguage.generic;

import java.util.ArrayList;
import java.util.List;

public class 数组与泛型列表 {

	public static void main(String[] args) {


		List<Object> objList = new ArrayList<Object>();
		objList.add(new Object());
		objList.add("nihao");
		List<String> strList = new ArrayList<String>();
//		strList.add(new Object());//编译错误
	
		needListOfObject(objList);
//		needListOfObject(strList);//编译错误
		needListOfString(strList);
//		needListOfString(objList);//编译错误

		Object[] objArray = new Object[2];
		needArrayOfObject(objArray);
		String[] strArray = new String[3];
		needArrayOfObject(strArray);
		
//		List<String>[] a = new List<String>[2];编译错误
		List<?>[] a0 = new List<?>[2];		
		List[] a = new List[2];
		List<Integer> il = new ArrayList<Integer>();
		il.add(3);
		a[0] = il;
//		needArrayOfString(a);// java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
		
		
		//
		Object[] objectArray1 = new Long[2];
		objectArray1[0]="jjj";//RuntimeException:java.lang.ArrayStoreException: java.lang.String
//		System.out.println(objectArray1[0]);
		
//		List<Object> list = new ArrayList<String>();//编译错误

	}
	
	public static void needListOfObject(List<Object> list){
		
	}
	
	public static void needListOfString(List<String> list){
		
	}
	
	public static void needArrayOfObject(Object[] a){
/*		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}*/
	}
	
	public static void needArrayOfString(List<String>[] a){
		for(List<String> list:a){
			if(list !=null)
			for(String s:list){
				System.out.println(s);
			}
		}
	}
	

}
