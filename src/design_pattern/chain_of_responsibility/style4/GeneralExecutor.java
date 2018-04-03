package design_pattern.chain_of_responsibility.style4;


public class GeneralExecutor<ArgBean> extends AbstractExecutor<ArgBean> {


	@Override
	public boolean executor(ArgBean argBean) {
		for(Handler<ArgBean> registeredHandler :getRegisteredHandlers()) {
			try {
				if(!registeredHandler.handle(argBean)) {
					return false;
				}
			} catch (Throwable e) {
				System.out.println("handler '"+registeredHandler.getClass().getName()+"' execute Error");
				e.printStackTrace();
			}
		}
		return true;
	}

}
