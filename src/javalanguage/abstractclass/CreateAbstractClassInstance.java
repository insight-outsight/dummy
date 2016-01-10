package javalanguage.abstractclass;

public class CreateAbstractClassInstance {

	public static void main(String[] args) {
		
		new Develop(){
			public Develop analyze(){
				System.out.println("analyzing...");
				return this;
			}
		}.analyze().design();
	}

}
