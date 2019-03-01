package javalanguage.regexp;


public class StringReplaceRegexTset {
    public static void main( String args[] ){
      String str = "DB7_RECONSITION_INTEGRAL_USER_TASK_206878128_24456";
      String regexStr = "DB7_RECONSITION_INTEGRAL_USER_TASK_(\\d{1,9})_(\\d{1,3})";  
      System.out.println("1."+str.replaceAll(regexStr,"$0"));
      System.out.println("2."+str.replaceAll(regexStr,"$1"));
      System.out.println("3."+str.replaceAll(regexStr,"$2"));
   }
}