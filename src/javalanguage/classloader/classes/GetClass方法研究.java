package javalanguage.classloader.classes;

import javalanguage.interfaces.Ambiguous;

public class GetClass方法研究 {

	public static void main(String[] args) {
		
		//Primitive Data Types
		System.out.println("boolean.class="+boolean.class);
		System.out.println("boolean.class.getName()="+boolean.class.getName());
		System.out.println("char.class="+char.class);
		System.out.println("char.class.getName()="+char.class.getName());
		System.out.println("byte.class="+byte.class);
		System.out.println("byte.class.getName()="+byte.class.getName());
		System.out.println("short.class="+boolean.class);
		System.out.println("short.class.getName()="+boolean.class.getName());
		System.out.println("int.class="+int.class);
		System.out.println("int.class.getName()="+int.class.getName());
		System.out.println("long.class="+long.class);
		System.out.println("long.class.getName()="+long.class.getName());
		System.out.println("float.class="+float.class);
		System.out.println("float.class.getName()="+float.class.getName());
		System.out.println("double.class="+double.class);
		System.out.println("double.class.getName()="+double.class.getName());
		
		//Object Type
		System.out.println(Ambiguous.class);
		System.out.println(GetClass方法研究.class);
	}
	
}