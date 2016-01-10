package javalanguage.innerclass_accessscope;

public class ClassInnerMethod {
	
	static String great;
	int j;

	public int swy(String n) {
		class Cw{
			int wn;
			public int ds(){
				System.out.println(great);
				return wn;
			}
		}
		return new Cw().ds();
	}
	

	public static void main(String[] args) {
		great = "abc";
		System.out.println(new ClassInnerMethod().swy(great));
	}

}
