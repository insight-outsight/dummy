package javalanguage.regexp;

public class RegExpUtils {

	public static void main(String[] args) {

		String str1 = "http://192.168.1.6:9999/caservice/webservice/caServiceWs?wsdl ";
		System.out.println("gg=1===" + extractIPOrHostFromUrl(str1));
		str1 = "http://192.168.1.6/caservice/webservice/caServiceWs?wsdl";
		System.out.println("gg=2===" + extractIPOrHostFromUrl(str1));
		str1 = "https://28.168.1.6/caseebservice/caS.jsp";
		System.out.println("gg=3===" + extractIPOrHostFromUrl(str1));
		str1 = "http://www.k2343pd.com/xiaomi/query?bm=f0c31e1a_o3y66EnxkhiKwivo)a0joCTwPOCJY";
		System.out.println("gg=4===" + extractIPOrHostFromUrl(str1));

	}
	
	/**
	 * 匹配URL中的域名或者IP地址，不带端口号
	 * @param url
	 * @return
	 */
	public static String extractIPOrHostFromUrl(String url){
		String reg = ".*\\/\\/([^\\/\\:]*).*";
		return url.replaceAll(reg, "$1");
	}

}