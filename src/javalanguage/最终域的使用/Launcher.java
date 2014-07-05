package javalanguage.最终域的使用;

import commons.pojo.FedoraLinux;

public class Launcher {

	private final FedoraLinux fedoraLinux;
	
	public Launcher(){
		fedoraLinux = new FedoraLinux();
	}
	
	public static void main(String[] args){
		Operations ops = new Operations();
		//可以有两个变量名称相同吗？  fedoraLinux有两个？？
		//可以，一个全局域，一个局部变量
		final FedoraLinux fedoraLinux = new FedoraLinux();
		System.out.println("000- "+ fedoraLinux.getCode());
		ops.of(fedoraLinux);
		System.out.println("1111- "+ fedoraLinux.getCode());
		ops.hof(fedoraLinux);
		System.out.println("2222- "+ fedoraLinux.getCode());
		
	}
	

}
