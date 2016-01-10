package javalanguage.对象的克隆;

import commons.pojo.Penguin;


public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] das = new Integer[]{188,25};
		//Penguin penguin = new Penguin();
		//penguin.setQualified("oracle 3e-changed");
		
		Miracle m1 = new Miracle();
		m1.setDi(new Integer(9));
		m1.setEman("xiang fo.");
		m1.setDas(das);
		//m1.setPenguin(penguin);
		
		Miracle m2 =  m1.clone();
		System.out.println("m2.getDi()="+m2.getDi());
		System.out.println("m2.getEman()="+m2.getEman());
		System.out.println("m2.getDas()[0]="+m2.getDas()[0]);	
		if(m2.getPenguin()!=null){
			System.out.println("m2.getPenguin().getQualified()="+m2.getPenguin().getQualified());
			
		}
		System.out.println("-------------------------------");
		//将改变m2中的值，如果Miracle没有在调super.clone()之后调用Integer[]的clone()。
		m1.setDi(new Integer(38));
		m1.setEman("emituofo");
		//将改变m2中Penguin对象的值，如果Miracle没有在调super.clone()之后调用m.penguin = penguin.clone()。
		//penguin.setQualified("ms 2000");
/*		Integer[] das2 = new Integer[]{333,288};
		m1.setDas(das2);*/
		das[0] = new Integer(992);
		m1.getPenguin().setQualified("jjj");
		System.out.println("m2.getDi()="+m2.getDi());
		System.out.println("m2.getEman()="+m2.getEman());
		System.out.println("m2.getDas()[0]="+m2.getDas()[0]);
		if(m2.getPenguin()!=null){
			System.out.println("m2.getPenguin().getQualified()="+m2.getPenguin().getQualified());			
		}

		System.out.println("-------------------------------");
		System.out.println("m1.getDi()="+m1.getDi());
		System.out.println("m1.getEman()="+m1.getEman());

		System.out.println("m1.getDas()[0]="+m1.getDas()[0]);
		System.out.println("m1.getPenguin().getQualified()="+m1.getPenguin().getQualified());
		System.out.println("done");	

	}

}
