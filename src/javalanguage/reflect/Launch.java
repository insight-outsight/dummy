package javalanguage.reflect;

import java.lang.reflect.Proxy;


public class Launch {

    public static void main(String[] args) {
        System.out.println("i am super!");
        
        IBelle b = new ColdBelle();

        IBelle bProxy = (IBelle) SimpleDynamicProxyFactory.getBean(b);
        bProxy.eat("strawberry and pineapple");
        
        IFucker b2 = new ColdBelle();
        //下面b2换成b效果一样
        IFucker bProxy2 = (IFucker) SimpleDynamicProxyFactory.getBean(b2);
        //IFucker bProxy2 = (IFucker) SimpleDynamicProxyFactory.getBean(b);
        bProxy2.kfc(234, "mf");
        
        //b==b2为假
        System.out.println(b == b2);
        //bProxy==bProxy2为假
        System.out.println(bProxy==bProxy2);
        //c1==c2为真
        Class<?> c1 = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), b.getClass().getInterfaces());      
        Class<?> c2 = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), b.getClass().getInterfaces());             
        System.out.println(c1 == c2);
        //ds2(3,new Integer[]{6,788,99});

/*      String s = String.valueOf(Character.toChars(0x2F81A));
        char[] csss = s.toCharArray();
        //char t = 'a';
        long etw = 9196456790000087676l;
        Character.isLetter('\uf833');
        Character.isLetter(0x1833);
        for(char c:csss){
            System.out.println("*****start*******");
            System.out.format("%x", (short)c);
            System.out.println("******end******");
        }
*/
/*        try {
            ds(4);
        } catch (Throwable ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
 */
    }
    
    public static void ds(int r) throws Throwable{
        if(r < 5){
            System.out.println("abe");
            throw new Throwable("hahaa");
        }
    }
    
    public static void ds2(int r,Object... oss){
    		for(int i=0;i<oss.length;i++){
    			if(oss[i] instanceof Integer){
    				System.out.println(Integer.valueOf(String.valueOf(oss[i]))+10000);
    			}
    		}
            

    }
}



