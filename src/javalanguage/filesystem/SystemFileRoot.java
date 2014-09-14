package javalanguage.filesystem;

import java.io.File;


public class SystemFileRoot{

	public static void main(String[] args) {

		File roots[] = File.listRoots();
		for (int i = 0; i < roots.length; i++) {
			System.out.println(roots[i]);
		}

	}

}
