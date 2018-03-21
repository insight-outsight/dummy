package design_pattern.chain_of_responsibility.style2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FilterInvokeChainBuilder {

    public static <T> Invoker<T> buildInvokerChain(List<Filter> filters,final Invoker<T> invoker, String key, String group) {
        Invoker<T> last = invoker;
//        List<Filter> filters = ExtensionLoader.getExtensionLoader(Filter.class).getActivateExtension(invoker.getUrl(), key, group);
        if (filters.size() > 0) {
            for (int i = filters.size() - 1; i >= 0; i --) {
                final Filter filter = filters.get(i);
                final Invoker<T> next = last;
                final AtomicInteger ai = new AtomicInteger(i);
                last = new Invoker<T>() {

                    @Override
                    public Class<T> getInterface() {
                        return invoker.getInterface();
                    }
                    
                    @Override
                    public Result invoke(Invocation invocation) throws Exception {
                    	System.out.println("goddamn invoked "+ai.get());
                        return filter.invoke(next, invocation);
                    }

                    @Override
                    public String toString() {
                        return invoker.toString();
                    }
                    
                };
            }
        }
        return last;
    }
    
}