package javalanguage.数据类型;

import java.text.DecimalFormat;

public class FormatterTset {

	public static void main(String[] args) {
		
		System.out.println(String.format("ni hao %s,da xue cheng,%10d", "jj",80));
		System.out.println(String.format("da xue cheng %s,kk%skk,%d", "jj",800,123));

        long c = 1595848;
        System.out.println("1===="+new DecimalFormat(",###").format(c));       // 1,595,848
        System.out.println("2===="+new DecimalFormat("#,###.00").format(c));       // 1,595,848
        
	}

}
