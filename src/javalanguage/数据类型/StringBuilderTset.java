package javalanguage.数据类型;

import java.util.ArrayList;
import java.util.List;

public class StringBuilderTset {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();

		sb.append("a11").append("=").append("v11").append("&")
			.append("a22").append("=").append("v22");
		System.out.println(sb.toString());
		sb.insert(0,"prefix?");
//		sb.insert(0,"&").insert(0, "z0").insert(0, "=").insert(0, "v0");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(sb.toString());

		List<Integer> l = new ArrayList<Integer>();
		l.add(9);
		l.add(-1241);
		l.add(3453);
		System.out.println("1."+l.contains(8));
		System.out.println("2."+l.contains(-1241));
		System.out.println("3."+l.contains(9));
		System.out.println("4."+l.contains(34531));
	}

}
