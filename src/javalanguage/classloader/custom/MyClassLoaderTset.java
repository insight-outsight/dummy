package javalanguage.classloader.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class MyClassLoaderTset {

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

    	MyClassLoader loader1 = new MyClassLoader();    
        MyClassLoader loader2 = new MyClassLoader();
        Class class1 = loader1.loadClass("javalanguage.classloader.custom.SampleObject");
        Class class2 = loader2.loadClass("javalanguage.classloader.custom.SampleObject");
        System.out.println("不同ClassLoader加载的同一个类比较:"+(class1==class2));
        Object obj1 = class1.newInstance();
        System.out.println("11:"+class1.getClassLoader());
        System.out.println("112:"+class2.getClassLoader());
        System.out.println("1221:"+obj1.getClass().getClassLoader());
        Object obj2 = class2.newInstance();

        Object obj3 = loader1.loadClass("javalanguage.classloader.custom.MyClassLoaderTset");
        System.out.println(obj3);
        System.out.println(obj3 instanceof javalanguage.classloader.custom.MyClassLoaderTset);
//        Thread.currentThread().setContextClassLoader(loader1);
//        System.out.println(Thread.currentThread().getContextClassLoader());
/*        Class class4 = Class.forName("javalanguage.classloader.custom.SampleObject",true,loader1);
//        Class class4 = Class.forName("javalanguage.classloader.custom.SampleObject",true,loader1);
        Object obj4 = class4.newInstance();
        Method method = class1.getMethod("setSample", java.lang.Object.class);
        method.invoke(obj1, obj4);*/
        
        //不同ClassLoader加载的同一个类分别构造的对象无法互相转换。
        Method method = class1.getMethod("setSample", java.lang.Object.class);
        method.invoke(obj1, obj2);
    }

}
