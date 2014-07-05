package javalanguage.hierarchy;

public class Hu {

	int d = 55;
	int s = 7;
	
	public Hu(){
		System.out.println("Hu对象开始实例化了");
		print();
		d=44;
		System.out.println("Hu对象结束实例化了");
	}
	
	void print(){
		System.out.println("Hu shuo " + d);	
	}
	
	static{
		System.out.println("类模板被虚拟机加载");			
	}
	
	int getS(){
		return this.s;
	}
	

}

