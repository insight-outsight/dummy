package design_pattern.chain_of_responsibility.style4;


public abstract class AbstractHandler<ArgBean> implements Handler<ArgBean> {

	@Override
	public boolean handle(ArgBean argBean) {
		if(canHandle(true)) {
			return doHandle(argBean);
		}
		else {
			return true;
		}
	}

	protected boolean canHandle(boolean defaultValue) {
		return defaultValue;
	}

	public abstract boolean doHandle(ArgBean argBean);
	
}
