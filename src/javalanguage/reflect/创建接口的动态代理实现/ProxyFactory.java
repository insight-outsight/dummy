package javalanguage.reflect.创建接口的动态代理实现;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    
    public static Object getProxyInstanceOf(Class<?> cls){        
    	InterfaceMethodInvocationHandler invocationHandler = new InterfaceMethodInvocationHandler();        
        Object newProxyInstance = Proxy.newProxyInstance(  
                cls.getClassLoader(),  
                new Class[] { cls }, 
                invocationHandler); 
        return (Object)newProxyInstance;
    }
    
}