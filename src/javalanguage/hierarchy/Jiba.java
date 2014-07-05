package javalanguage.hierarchy;

public class Jiba extends Hu {

	int d = 70;
	int s = 2;

	public Jiba() {
		System.out.println("Jiba对象开始实例化了");
		print();
		d = 68;
		System.out.println("Jiba对象结束实例化了");
	}
	
	void print(){
		System.out.println("Jiba shuo " + d);		
	}

	int getS(){
		return this.s;
	}
	
	
}
