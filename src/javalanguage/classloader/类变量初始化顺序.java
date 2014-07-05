package javalanguage.classloader;



public class 类变量初始化顺序 {
	
	static 类变量初始化顺序 ml = new 类变量初始化顺序();
	static int a1 = 40;
	static int b1;
	
	类变量初始化顺序(){
		a1=900;
		b1=1002;
	}
	
	
	public static void main(String[] args) {	
		
		/*		
		System.out.println("a1="+类变量初始化顺序.a1); //输出a1=40
		System.out.println("b1="+类变量初始化顺序.b1); //输出b1=1002
		*/
		
		类变量初始化顺序  $ = new 类变量初始化顺序();
		System.out.println("a1="+类变量初始化顺序.a1);//输出a1=900
		System.out.println("b1="+类变量初始化顺序.b1);//输出b1=1002
	}
	
}
