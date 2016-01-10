package javalanguage.reflect;

import java.lang.reflect.Method;

public class SimpleDynamicProxyFactory extends AbstractDynamicProxyFactory {

	protected SimpleDynamicProxyFactory(Object object){
	    super(object);
	}

	public static Object getBean(Object object){
	    return getBean(object,new SimpleDynamicProxyFactory(object));
	}
	
	@Override
	protected void doBefore(Object o) {
	    System.out.println("被代理方法执行前may do something");
	}

	@Override
	protected void doAfter(Object o) {
	    System.out.println("被代理方法执行后may do something");

	}

	@Override
	protected void doBefore(Method m) {
		 System.out.println("开始以代理方式执行方法"+m.getName());
		
	}

	@Override
	protected void doAfter(Method m) {
		System.out.println("结束以代理方式执行方法"+m.getName());		
	}

}
