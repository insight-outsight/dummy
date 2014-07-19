package javalanguage.classloader;



public class 类变量初始化顺序2 {
	
	 // 静态变量        
    public static String staticField = "静态变量";        
    // 变量        
    public String field = "变量";        
 
    
    // 静态变量        
    public static String staticField2 = "静态变量22"; 

    public/* static */Thunder t = new Thunder();
    // 静态初始化块        
    static {        
        System.out.println("inner--"+staticField);    
        System.out.println("inner--"+staticField2);        

        System.out.println("静态初始化块");        
    }    
    
    
 
    // 初始化块        
    {        
        System.out.println(field);        
        System.out.println("初始化块");        
    }        
 
    // 构造器        
    public 类变量初始化顺序2() {        
        System.out.println("构造器");        
    }        
 
    public static void main(String[] args) {        
       //new 类变量初始化顺序2(); 
       //new 类变量初始化顺序2(); 
       System.out.println("outer--"+类变量初始化顺序2.staticField);
    }    
	
}

class Thunder{
	public Thunder(){
		super();
		System.out.println("Thunder at "+System.currentTimeMillis()+" created.");
	}
}
