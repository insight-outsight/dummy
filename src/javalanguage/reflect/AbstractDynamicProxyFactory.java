package javalanguage.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class AbstractDynamicProxyFactory implements InvocationHandler {

	private Object object;

	protected AbstractDynamicProxyFactory(Object object){
	    this.object = object;
	}

	public static Object getBean(Object object,InvocationHandler ih){
	    Class<? extends Object> clazz = object.getClass();
	    return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), ih);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
	    Object result = null;
	    try{
	        doBefore(method);
	        result = method.invoke(object, args);
	    }
	    catch(InvocationTargetException e){
	        throw e.getTargetException();    
	    }
	    catch(Exception e){
	        System.out.println("AbstractDynamicProxyFactory.invoke方法异常啦:" + e.toString());
	    }
	    finally{
	        doAfter(method);           
	    }
	    return result;
	}
	
	protected abstract void doBefore(Object o);
	protected abstract void doAfter(Object o);
	protected abstract void doBefore(Method m);
	protected abstract void doAfter(Method m);

}

