package javalanguage.数据类型;

/**
 * 这个测试结果有点让人困惑
 * @author xuzhengchao
 *
 */
public class StringTset {

	public static void main(String[] args) {

		String content = ""; //split后长度：1
		
		String _SPLITTER = ",";
		String[] splittedArray = content.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray.length);
		for(String str:splittedArray){
			System.out.println("--"+str+"==");
		}
		
		String content2 = ","; //split后长度：0
		String[] splittedArray2 = content2.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray2.length);
		for(String str:splittedArray2){
			System.out.println("----"+str+"====");
		}
		
	}

}
