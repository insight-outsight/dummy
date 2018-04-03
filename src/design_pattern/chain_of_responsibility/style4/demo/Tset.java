package design_pattern.chain_of_responsibility.style4.demo;

import java.util.HashMap;
import java.util.Map;

import commons.pojo.User;

import design_pattern.chain_of_responsibility.style4.GeneralExecutor;

public class Tset {

	public static void main(String[] args) {
		
		GeneralExecutor<User> ge = new GeneralExecutor<User>();
		ge.registerHandle(new HandlerAlpha());
		ge.registerHandle(new HandlerBeta());
		
		User user = new User(135,"mazi");
		System.out.println(ge.executor(user));
		
	}

}
