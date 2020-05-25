package javalanguage.reflect.创建接口的动态代理实现;

public class Tset {
    
    public static void main(String[] args) {
        IUserDao proxyIUserDao=(IUserDao)ProxyFactory.getProxyInstanceOf(IUserDao.class);
        System.out.println(proxyIUserDao.getUserName());
        
    }

}