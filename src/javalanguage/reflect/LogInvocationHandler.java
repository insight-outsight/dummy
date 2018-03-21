package javalanguage.reflect;

import java.lang.reflect.Method;

public class LogInvocationHandler extends AbstractInvocationHandler {
	
	@Override
	protected void doBefore(Object originalObject, Method m) {
		System.out.println(originalObject.getClass().getName()+"的方法"+m.getName()+"以代理方式执行前");				
	}

	@Override
	protected void doAfter(Object originalObject, Method m) {
		System.out.println(originalObject.getClass().getName()+"的方法"+m.getName()+"以代理方式执行后");						
	}

}
