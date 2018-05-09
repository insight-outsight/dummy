package javalanguage.数据类型;

/**
 * 这个测试结果有点让人困惑
 * @author xuzhengchao
 *
 */
public class StringSplitTset {

	public static void main(String[] args) {
		
		String _SPLITTER = ",";
		
		System.out.println("=============1=============");
		String content = ""; //split后长度：1,字段分别为:""
		String[] splittedArray = content.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray.length);
		for(String str:splittedArray){
			System.out.println("--<"+str+">--");
		}
		System.out.println("=============2=============");

		String content2 = ","; //split后长度：0
		String[] splittedArray2 = content2.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray2.length);
		for(String str:splittedArray2){
			System.out.println("--<"+str+">--");
		}
		System.out.println("=============3=============");

		String content3 = ",,"; //split后长度：0
		String[] splittedArray3 = content3.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray3.length);
		for(String str:splittedArray3){
			System.out.println("--<"+str+">--");
		}
		System.out.println("=============4=============");

		
		String content4 = ",a,"; //split后长度：2。字段分别为:"","a"
		String[] splittedArray4 = content4.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray4.length);
		for(String str:splittedArray4){
			System.out.println("--<"+str+">--");
		}
		System.out.println("=============5=============");

		String content5 = "b,,"; //split后长度：1。字段分别为:"b"
		String[] splittedArray5 = content5.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray5.length);
		for(String str:splittedArray5){
			System.out.println("--<"+str+">--");
		}
		System.out.println("=============6=============");
		String content6 = ",,,c"; //split后长度：4。字段分别为:"","","","c"
		String[] splittedArray6 = content6.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray6.length);
		for(String str:splittedArray6){
			System.out.println("--<"+str+">--");
		}
	}

}
