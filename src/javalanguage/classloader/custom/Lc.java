package javalanguage.classloader.custom;

public class Lc {

	public static void main(String[] args) {
		
		MyClassLoader mcl = new MyClassLoader();
		System.out.println(mcl.getParent());

		MyClassLoader sscl = new SSCl();
		System.out.println(sscl.getParent());
		
	}

}
