package javalanguage.classloader;

import commons.pojo.User;

public class 实例变量与局部变量初始化值的不同 {
	
	private int i;
	private String s;
	private boolean b;
	private User user;
	private 实例变量与局部变量初始化值的不同 qihu;
	
	
	
	public static void main(String[] args) {
		//int i;
		//String s0;
		//System.out.println(i);  //编译出错
		//System.out.println(s0); //编译出错
		System.out.println(new 实例变量与局部变量初始化值的不同().i); //0
		System.out.println(new 实例变量与局部变量初始化值的不同().s); //null
		System.out.println(new 实例变量与局部变量初始化值的不同().b); //false
		System.out.println(new 实例变量与局部变量初始化值的不同().user);//null
		System.out.println(new 实例变量与局部变量初始化值的不同().qihu);//null
	}
	
}
