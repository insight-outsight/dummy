package design_pattern.chain_of_responsibility.style2;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

	public static void main(String[] args) {
		
		Filter filter1 = new Filter(){

			@Override
			public Result invoke(Invoker<?> invoker, Invocation invocation)
					throws Exception {
				System.out.println("filter1 begin");
				Result r = invoker.invoke(invocation);
				System.out.println("filter1 end");
				return r;
			}
			
		};
		
		Filter filter2 = new Filter(){
			
			@Override
			public Result invoke(Invoker<?> invoker, Invocation invocation)
					throws Exception {
				System.out.println("filter2 begin");
				Result r = invoker.invoke(invocation);
				System.out.println("filter2 end");
				return r;
			}
			
		};
		
		
		List<Filter> filterList = new ArrayList<Filter>();
		filterList.add(filter1);
		filterList.add(filter2);
		
		Invoker<String> lastInvoker = new Invoker<String>(){

			@Override
			public Class<String> getInterface() {
				return null;
			}

			@Override
			public Result invoke(Invocation invocation) throws Exception {
				System.out.println("last invoked");
				return null;
			}
			
		};
		
		Invoker<String> builtInvoker = FilterInvokeChainBuilder.buildInvokerChain(filterList, lastInvoker, "key", "group");
		
		try {
			builtInvoker.invoke(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
