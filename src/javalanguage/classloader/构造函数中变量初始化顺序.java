package javalanguage.classloader;

public class 构造函数中变量初始化顺序 {
	
	public static void main(String[] args) {
		System.out.println("门恩执行");
		Cups.c1.f(99);
	}

	static Cups x = new Cups();
	static Cups y = new Cups();

}

class Cup {
	int marker;
	Cup(int marker) {
		this.marker = marker;
		System.out.println("Cup(" + marker + ")");
	}
	void f(int marker) {
		System.out.println("marker="+this.marker+",f(" + marker + ")");
	}

}

class Cups {
	static Cup c1 = new Cup(11);
	static Cup c2;

	Cup c3 = new Cup(33);
	Cup c4;
	{
		c3 = new Cup(3);
		c4 = new Cup(4);
	}

	static {
		c1 = new Cup(1);
		c2 = new Cup(2);
	}
	//static Cup c1 = new Cup(11);
	Cups() {
		System.out.println("Cups()");
	}
	
}