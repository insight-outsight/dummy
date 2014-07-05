package javalanguage.jar;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;


public class Manifest文件中属性读取 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarLocation = "F:\\Java\\jdk1.7.0_03\\jre\\lib\\rt.jar";
		String attributeName = "Created-By";
		System.out.println(getManifestAttribute(jarLocation,attributeName));
	}
	
	/**
	 * 	
	 * 从jar包中META-INF/MANIFEST.MF中属性值
	 *
	 * @param filePath  jar包位置
	 * @param attrName	MANIFEST.MF中属性名
	 * @return 相应名称的属性值
	 * 
	 */
	public static String getManifestAttribute(String filePath,String attrName) {  
	    if (filePath == null || filePath.equals("")  
	            || !filePath.endsWith(".jar"))  {  
	        return null;  
	    }  
	  
	    try{  
	        JarFile jf = new JarFile(filePath);  
	        Manifest mf = jf.getManifest();  
	        Attributes attributes = mf.getMainAttributes();  
	        String value = attributes.getValue(attrName);  
	        return value;  
	    }  
	    catch (IOException e) {  
	        return null;  
	    }  
	}  

}
