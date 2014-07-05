package javalanguage.reflect.method;

import java.lang.reflect.Method; 
import java.lang.reflect.InvocationTargetException; 

/** 
* Created by IntelliJ IDEA. 
* File: TestRef.java 
* User: leizhimin 
* Date: 2008-1-28 14:48:44 
* 
* 原文http://lavasoft.blog.51cto.com/62575/61002/
* 
* 这里代码有改动
*/ 
public class TestRef { 

    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, Exception { 
/*        Foo foo = new Foo("这个一个Foo对象！"); 
        Class clazz = foo.getClass(); */
    	Class<?> clazz = Class.forName("javalanguage.reflect.method.Foo");
    	Object o = clazz.newInstance();
        Method m1 = clazz.getDeclaredMethod("outInfo"); 
        Method m2 = clazz.getDeclaredMethod("setMsg", String.class); 
        Method m3 = clazz.getDeclaredMethod("getMsg"); 
        m1.invoke(o); 
        m2.invoke(o, "重新设置msg信息！"); 
        String msg = (String) m3.invoke(o); 
        System.out.println(msg); 
    } 
} 

class Foo { 
    private String msg; 

    public Foo(){
    	
    }
    
    public Foo(String msg) { 
        this.msg = msg; 
    } 

    public void setMsg(String msg) { 
        this.msg = msg; 
    } 

    public String getMsg() { 
        return msg; 
    } 

    public void outInfo() { 
        System.out.println("这是测试Java反射的测试类"); 
    } 
}