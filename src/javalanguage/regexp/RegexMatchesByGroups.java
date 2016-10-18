package javalanguage.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchesByGroups
{
    public static void main( String args[] ){

      // 按指定模式在字符串查找
      String line = "This order was placed for QT3000! OK?";
      String pattern = "(.*)(\\d+)(.*)"; //三个小括号，一共三个分组

      // 创建 Pattern 对象
      Pattern r = Pattern.compile(pattern);

      // 现在创建 matcher 对象
      Matcher m = r.matcher(line);
      if (m.find( )) {
         System.out.println("Found value: " + m.group(0) );//即匹配到的完整字符串内容 
         System.out.println("Found value: " + m.group(1) );//首个分组
         System.out.println("Found value: " + m.group(2) );//第二个
         System.out.println("Found value: " + m.group(3) );//第三个
         System.out.println("Found value: " + m.group(4) );//本例不存在每四个分组
      } else {
         System.out.println("NO MATCH");
      }
   }
}