package javalanguage.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynaProxyDemo {

	public static void main(String[] args) {
		HelloWorld hyyy = new ProxyFactory().hellWorldProxyFactory(new HelloWorldImpl());
		hyyy.sayHelloWorld();
		hyyy.sayGoodBye();
	}

}

interface HelloWorld {
    void sayHelloWorld();
    void sayGoodBye();
 }
 
class HelloWorldImpl implements HelloWorld {
     public void sayHelloWorld() {
         System.out.println("Hello World!");             
     }

	public void sayGoodBye() {
		System.out.println("Ŭ����"); 
		
	}
}

class ProxyFactory implements InvocationHandler {

    //Ҫ�����ԭʼ����
    private Object objOriginal;
    /**
     * ���캯��
     * @param obj Ҫ�����ԭʼ����
     */
    public HelloWorld hellWorldProxyFactory(Object hw) {
        this.objOriginal = hw ;
       return (HelloWorld) java.lang.reflect.Proxy.newProxyInstance(  hw.getClass().getClassLoader(), hw.getClass().getInterfaces(), this); 
    }

    /**
     * ������ԭʼ����ķ���ʱ������ִ�еķ���
     * @param proxy �������
     * @param method Ҫִ�е�ԭʼ���󷽷�
     * @param args ԭʼ���󷽷��Ĳ���ֵ��
     * @return ԭʼ���󷽷�ִ�еķ���ֵ
     */
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable {
            Object result ; 
            //��������֮ǰ
            doBefore();
            //����ԭʼ����ķ���
            result = method.invoke(this.objOriginal ,args);
            //��������֮��
            doAfter();
            return result ;
    }
    /**
     * ��������֮ǰִ�еķ���
     */
    private void doBefore() {
        System.out.println("before method invoke!");
    }
    
    /**
     * ��������֮��ִ�еķ���
     */
    private void doAfter() {
        System.out.println("after method invoke!");
    }
}

