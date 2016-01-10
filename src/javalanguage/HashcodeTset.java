package javalanguage;


public class HashcodeTset {

	public static void main(String[] args) {
		
		System.out.println(new String("ewrwr").hashCode());// print:96934107
		System.out.println(new String("ni 好").hashCode());// print:3401816
		System.out.println(new Integer(67).hashCode()); // print:67
		System.out.println(new Integer(7044).hashCode());// print:7044
		System.out.println(new Integer(-9000).hashCode());// print:-9000
		System.out.println(2000010000 + 1100040000);
		System.out.println(new String("good guys wash!").hashCode());// print:1178654477
		
	}

}
