package javalanguage.hierarchy;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Hu hu = new Jiba();
		System.out.println("hu-"+hu.d);
		System.out.println("hu-"+hu.s);
		hu.print();
		System.out.println(hu.getS());
		
/*		Jiba jiba = new Jiba();
		System.out.println("jiba-"+jiba.d);
		System.out.println("jiba-"+jiba.s);*/

	}

}
