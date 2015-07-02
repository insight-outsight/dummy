package javalanguage.generic;

public class InterfaceAImplExt extends InterfaceAImpl {
	public InterfaceAImplExt(){
		System.out.println("not print");		
	}
	static{
		System.out.println("fuc bel,oh yeah");
	}
	@Override
	public int au(int i,int j) throws NullPointerException{
		return i+j;
	}
}
