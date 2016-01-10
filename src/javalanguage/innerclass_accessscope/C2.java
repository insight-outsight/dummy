package javalanguage.innerclass_accessscope;

import javalanguage.innerclass_accessscope.Zhu.Rou;


public class C2{
	public static void main(String[] args) {
		Candidate c = new Candidate();
		c.beta = "包内可访问22";
		int etw = c.octopus;
		System.out.println(c.beta);
		Zhu wtw = new Zhu();
		System.out.println(new Zhu.Rou().accessParent());
		//new Zhu.Rou();
/*		Object o;
		try {
			o = c.clone();
			System.out.println(o);
		} catch (CloneNotSupportedException e) {
			System.out.println("catch you");
			e.printStackTrace();
		}*/
		
	}
}
