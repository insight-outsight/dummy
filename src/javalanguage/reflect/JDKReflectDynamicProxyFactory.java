package javalanguage.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class JDKReflectDynamicProxyFactory {

	public static <T> T newProxyInstance(T originalObject,AbstractInvocationHandler aih){
	    Class<?> clazz = originalObject.getClass();
	    aih.setOriginalObject(originalObject);
	    return (T)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), aih);
	}
	

}

