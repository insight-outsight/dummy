package javalanguage.classloader.custom;

import java.io.IOException;
import java.io.InputStream;
import java.security.ProtectionDomain;

/**
 * a custom classloader which will load classes in 'work' direcotry ,don't use this in your code ,this is 
 * for demo only
 * 
 * @author xzc
 *
 */
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
    	System.out.println("MyClassLoader's Context ClassLoader is ["+Thread.currentThread().getContextClassLoader()+"]");
    	System.out.println("MyClassLoader's ClassLoader is ["+this.getClass().getClassLoader()+"]");
        //此ClassLoader将首先在本类的所在位置（如F:\git-repositories\dummy\bin\javalanguage\classloader\custom\）的
    	//目录work加载class文件，为演示方便直接使用类名作为文件名找class
        String fileName = "work/"+name.substring(name.lastIndexOf(".")+1)+".class";
        InputStream is = getClass().getResourceAsStream(fileName);
        if( is == null){
        	//System.out.println("n");
            return super.loadClass(name);
        }
        try {
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name,b,0,b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.loadClass(name);
    }
    

} 
