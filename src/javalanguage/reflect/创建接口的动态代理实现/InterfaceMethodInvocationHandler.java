package javalanguage.reflect.创建接口的动态代理实现;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InterfaceMethodInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable {        
        System.out.println("proxyedObject class: "+proxy.getClass().getName());
        System.out.println("proxyed method decalaring class: "+method.getDeclaringClass().getName());
        System.out.println("proxyed method: "+method.getName());
    	//如果传进来是一个已实现的具体类（本次演示略过此逻辑)
        if (Object.class.equals(method.getDeclaringClass())) {  
            try {  
            	System.out.println("impl method call");
                return method.invoke(this, args);  
            } catch (Throwable t) {  
                t.printStackTrace();  
            }  
        //如果传进来的是一个接口（核心)
        } else {  
            //如远程http调用
            //如远程方法调用（rmi)
            //....
        	System.out.println("interface method call");
            return "method call success!"; 
        }  
        return null;
    }
    


}