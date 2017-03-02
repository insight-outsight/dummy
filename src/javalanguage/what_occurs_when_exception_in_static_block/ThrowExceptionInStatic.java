package javalanguage.what_occurs_when_exception_in_static_block;

public class ThrowExceptionInStatic {

	static{
		System.out.println("1 static");
	}
	
	static{
		if(System.currentTimeMillis()%10>=0){
			System.out.println("2 static");
			throw new IllegalArgumentException("a");
		}
	}
	
	public final static String wtte = "sssss";
	public static void bee(){
		
	}
	public static String getWtte(){
		return wtte;
	}
}
