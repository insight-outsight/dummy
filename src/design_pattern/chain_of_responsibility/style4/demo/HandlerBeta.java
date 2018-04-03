package design_pattern.chain_of_responsibility.style4.demo;

import commons.pojo.User;

import design_pattern.chain_of_responsibility.style4.AbstractCCBlackListHandler;

public class HandlerBeta extends AbstractCCBlackListHandler<User> {

	@Override
	public boolean doHandle(User user) {
		System.out.println(this.getClass().getSimpleName()+" Executed,argBean="+user.toString());
		return true;
	}

}
