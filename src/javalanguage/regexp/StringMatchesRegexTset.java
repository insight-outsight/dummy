package javalanguage.regexp;


public class StringMatchesRegexTset {
    public static void main( String args[] ){
//    	包含serverInfo、serverError、org.开头、com.开头但排出com.hd
      String regexStr = "serverInfo|serverError|org\\..*|com\\.[^h][^d].*";  
      System.out.println("1:" + "aa".matches(regexStr));
      System.out.println("2:" + "serverIn".matches(regexStr));
      System.out.println("3:" + "serverInfo".matches(regexStr));
      System.out.println("4:" + "verError".matches(regexStr));
      System.out.println("5:" + "serverError".matches(regexStr));
      System.out.println("6:" + "serverErrorr".matches(regexStr));
      System.out.println("7:" + "com.hd.dao.aa".matches(regexStr));
      System.out.println("8:" + "com.hd.daoaa".matches(regexStr));
      System.out.println("9:" + "org.a".matches(regexStr));
      System.out.println("10:" + "org1.a".matches(regexStr));
      System.out.println("11:" + "com.aa".matches(regexStr));
      System.out.println("12:" + "com.dhfhde.bb".matches(regexStr));
      System.out.println("13:" + "rebootTempLog".matches(regexStr));
      System.out.println("14:" + "com.101tec.f.r".matches(regexStr));
      System.out.println("15:" + "com.hd.dao.relax.VZyRelaxArticleDao.getRecommendRelaxList".matches(regexStr));
      
   }
}