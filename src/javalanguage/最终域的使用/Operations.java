package javalanguage.最终域的使用;

import commons.pojo.FedoraLinux;

public class Operations {

	public void of(final FedoraLinux a){
		a.setCode("域被设置");
		System.out.println("of end - "+ a.getCode());		
	}
	
	public void hof(FedoraLinux a){
		FedoraLinux a1 = new FedoraLinux();
		a = a1;
		final String s = "不工作";
		a.setCode(s);
		System.out.println("hof end- "+ a.getCode());
	}
	
}
