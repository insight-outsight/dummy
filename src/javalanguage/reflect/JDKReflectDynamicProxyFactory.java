package javalanguage.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class JDKReflectDynamicProxyFactory {

	public static Object newProxyInstance(Object originalObject,InvocationHandler ih){
	    Class<? extends Object> clazz = originalObject.getClass();
	    return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), ih);
	}
	

}

