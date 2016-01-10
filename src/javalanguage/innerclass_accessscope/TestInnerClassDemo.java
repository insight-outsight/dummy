package javalanguage.innerclass_accessscope;

import javalanguage.innerclass_accessscope.Zhu.Rou;


public class TestInnerClassDemo {

    public static void main( String[] args ){
		Zhu jkk = new Zhu();
		System.out.println("b");
		System.out.println(jkk.cer.getExplain());
		jkk.cer.setExplain("final 可变类");
	
		System.out.println("a");
		System.out.println(jkk.cer.getExplain());
		System.out.println("-------------------");
		
		Rou rou = new Zhu.Rou();
		System.out.println(rou.accessParent());
		System.out.println("-------------------");
		rou.setParent("hhh");
		System.out.println(rou.accessParent());
    }
    
}
