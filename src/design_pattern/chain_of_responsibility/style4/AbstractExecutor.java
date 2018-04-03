package design_pattern.chain_of_responsibility.style4;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractExecutor<ArgBean> implements Executor<ArgBean> {

	private List<Handler<ArgBean>> registeredHandlers = new ArrayList<Handler<ArgBean>>();

	public AbstractExecutor<ArgBean> registerHandle(Handler<ArgBean> handler) {
		registeredHandlers.add(handler);
		return this;
	}

	public List<Handler<ArgBean>> getRegisteredHandlers() {
		return registeredHandlers;
	}
	
}
