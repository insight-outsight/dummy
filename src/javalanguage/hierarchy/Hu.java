package javalanguage.hierarchy;


public class Hu {

	private int d = 6666;
	private int s = 7;

	public Hu(){
		System.out.println("---------Hu对象开始实例化了-------");
		//print();
		d=44;
		System.out.println("---------Hu对象结束实例化了-------");
	}
	
	public Hu(int d){
		this.d = d;
		System.out.println("---------Hu(int d)对象开始实例化了-------");
	}
	
	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	public int getS(){
		System.out.println("called Hu.getS()");
		return this.s;
	}

	public void setS(int s) {
		this.s = s;
	}
	void print(){
		System.out.println("Hu shuo " + d);	
	}

	static{
		System.out.println("类模板被虚拟机加载");			
	}

}

