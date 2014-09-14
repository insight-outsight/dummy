package javalanguage.hierarchy;

public class Jiba extends Hu {

	int d = 70;
	int s = 2;

	public Jiba() {
		System.out.println("---------Jiba对象开始实例化了-------");
		//print();
		d = 68;
		System.out.println("---------Jiba对象结束实例化了-------");
	}
	
	public Jiba(int d) {
		this.d = d;
		System.out.println("---------Jiba(int d)对象结束实例化了-------");
	}
	
	public int getS(){
		System.out.println("called Jiba.getS()");
		return this.s;
	}

	public void setS(int s) {
		this.s = s;
	}
	
	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	
	void print(){
		System.out.println("Jiba shuo " + d);		
	}
	
	
}
