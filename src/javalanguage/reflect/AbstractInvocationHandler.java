package javalanguage.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class AbstractInvocationHandler implements InvocationHandler {

	private Object originalObject;

	public AbstractInvocationHandler(Object originalObject){
	    this.originalObject = originalObject;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
	    Object result = null;
	    
	    try{
	        doBefore(originalObject,method);
	    }
	    catch(Throwable t){
	        System.out.println("doBefore() before "+method.getName()+"方法异常啦。");
	        throw t;
	    }
	    
	    try{
	        result = method.invoke(originalObject, args);
	    }
	    catch(Exception e){
	        System.out.println("AbstractInvocationHandler invoke "+method.getName()+"方法异常啦。");
	    	throw e;
	    }
	    
        
	    try{
	        doAfter(originalObject,method);           
	    }
	    catch(Throwable t){
	        System.out.println("doAfter() after "+method.getName()+"方法异常啦。");
	        throw t;
	    }

	    return result;
	}
	
	protected abstract void doBefore(Object originalObject,Method m) throws Throwable;
	protected abstract void doAfter(Object originalObject,Method m) throws Throwable;

}

