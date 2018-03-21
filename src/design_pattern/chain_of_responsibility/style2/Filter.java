package design_pattern.chain_of_responsibility.style2;

public interface Filter {

	/**
	 * do invoke filter.
	 * 
	 * <code>
	 * // before filter
     * Result result = invoker.invoke(invocation);
     * // after filter
     * return result;
     * </code>
     * 
     * @see com.alibaba.dubbo.rpc.Invoker#invoke(Invocation)
	 * @param invoker service
	 * @param invocation invocation.
	 * @return invoke result.
	 * @throws RpcException
	 */
	Result invoke(Invoker<?> invoker, Invocation invocation) throws Exception;

}