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
			System.out.println("--<"+str+">--");
		}
		System.out.println("==========================");

		String content2 = ","; //split后长度：0
		String[] splittedArray2 = content2.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray2.length);
		for(String str:splittedArray2){
			System.out.println("--<"+str+">--");
		}
		System.out.println("==========================");

		String content3 = ",,"; //split后长度：0
		String[] splittedArray3 = content3.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray3.length);
		for(String str:splittedArray3){
			System.out.println("--<"+str+">--");
		}
		System.out.println("==========================");

		
		String content4 = ",a,"; //split后长度：2
		String[] splittedArray4 = content4.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray4.length);
		for(String str:splittedArray4){
			System.out.println("--<"+str+">--");
		}
		System.out.println("==========================");

		String content5 = "b,,"; //split后长度：1
		String[] splittedArray5 = content5.split(_SPLITTER);
		System.out.println("split后长度："+splittedArray5.length);
		for(String str:splittedArray5){
			System.out.println("--<"+str+">--");
		}
		
	}

}
