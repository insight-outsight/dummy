package javalanguage.classloader.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UsingCustomClassLoaderLoadCustomClassesTset {

    /**
     * @param args
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

    	System.out.println("UsingCustomClassLoaderLoadCustomClassesTset's Context ClassLoader is ["+Thread.currentThread().getContextClassLoader()+"]");
    	System.out.println("UsingCustomClassLoaderLoadCustomClassesTset's ClassLoader is ["+UsingCustomClassLoaderLoadCustomClassesTset.class.getClassLoader()+"]");
    	//直接使用默认的sun.misc.Launcher$AppClassLoader加载不到抛java.lang.ClassNotFoundException，
    	//因为该类javalanguage.classloader.custom.SampleObject不存在 	
    	//Class class01 = Class.forName("javalanguage.classloader.custom.SampleObject");
    	
    	//使用定制的ClassLoader加载，
    	MyClassLoader myClassLoader = new MyClassLoader();
    	
    	//这两句不行，因为此时Class.forName会调用加载UsingCustomClassLoaderLoadClassesInCustomDirTset类的
 		//ClassLoader即AppClassLoader加载类javalanguage.classloader.custom.SampleObject，当然找不到			
    	/*    	Class sampleObjectClass = Class.forName("javalanguage.classloader.custom.SampleObject");*/
    	
    	//这样就行了
 		Thread.currentThread().setContextClassLoader(myClassLoader);
    	System.out.println("UsingCustomClassLoaderLoadCustomClassesTset's Context ClassLoader is ["+Thread.currentThread().getContextClassLoader()+"]");
    	System.out.println("UsingCustomClassLoaderLoadCustomClassesTset's ClassLoader is ["+UsingCustomClassLoaderLoadCustomClassesTset.class.getClassLoader()+"]");

 		Class sampleObjectClass = Thread.currentThread().getContextClassLoader().
 				loadClass("javalanguage.classloader.custom.SampleObject");
 		//还可以这样
// 		Class sampleObjectClass = 
// 				Class.forName("javalanguage.classloader.custom.SampleObject",true,myClassLoader);
		

    	Object obj1 = sampleObjectClass.newInstance();
    	Object obj2 = sampleObjectClass.newInstance();
        //调用对象方法
        Method method44 = sampleObjectClass.getMethod("setSample", java.lang.Object.class);
        method44.invoke(obj1, obj2);
        
/*        Method method555 = sampleObjectClass.getMethod("createSampleObjectField");
        method555.invoke(obj1);*/

        
/*        Method method55 = sampleObjectClass.getMethod("setSof", java.lang.Object.class);
        SampleObjectField sof = new SampleObjectField();
        sof.setValue("aaa");
        method55.invoke(obj1, sof);

        Method method66 = sampleObjectClass.getMethod("getSof");
        System.out.println(method66.invoke(obj1));
        
        */
        
        Method method77 = sampleObjectClass.getMethod("di");
       method77.invoke(obj1);
    }

}
