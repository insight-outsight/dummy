package design_pattern.chain_of_responsibility.style3;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;



/**
 * @author turbo
 *
 * 2016年10月25日
 */
@Intercepts({
    @Signature(
        type = Map.class,
        method = "get",
        args = {Object.class}
)})
public class ExamplePlugin2 implements Interceptor {

    /* 此方法用于实现拦截逻辑
     * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
    	System.out.println(this.getClass().getSimpleName()+" Executed");
        return "ExamplePlugin2";
    }

    /* 使用当前的这个拦截器实现对目标对象的代理（内部实现时Java的动态代理）
     * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /* 此方法和上一节所讲的自定义对象工厂中的setProperties一样，初始化Configuration时通过配置文件配置property传递参数给此方法并调用。
     * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
     */
    @Override
    public void setProperties(Properties properties) {
    	Iterator iterator = properties.keySet().iterator();
        while (iterator.hasNext()){
            String keyValue = String.valueOf(iterator.next());
            System.out.println(properties.getProperty(keyValue));
        }
    }

}