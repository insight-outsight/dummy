package javalanguage.classloader.classes;

import java.net.URL;
import java.security.CodeSource;


public class ShowClassJarAndVersion {

	public static void main(String[] args) {
			String location = null;
             final CodeSource source = String.class.getProtectionDomain().getCodeSource();
             if (source != null) {
                 final URL locationURL = source.getLocation();
                 if (locationURL != null) {
                     final String str = locationURL.toString().replace('\\', '/');
                     int index = str.lastIndexOf("/");
                     if (index >= 0 && index == str.length() - 1) {
                         index = str.lastIndexOf("/", index - 1);
                         location = str.substring(index + 1);
                     } else {
                         location = str.substring(index + 1);
                     }
                 }
             }
      	   System.out.println(location);//JDK类获取为null，第三方jar中类显示为jar名称,如mybatis-3.4.1.jar

		   final Package pkg = String.class.getPackage();
           if (pkg != null) {
        	   System.out.println(pkg.getName());
               final String ver = pkg.getImplementationVersion();
               if (ver != null) {
            	   System.out.println(ver);
               }
           }
	}

}
