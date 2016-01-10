package javalanguage.threads.非线程安全对象;

public class UnsafeBean {

	private int i = 0;
	public UnsafeBean(int i ){
		this.i = i;
	}
	public void assertEquality(){
		if(i != i){
			throw new AssertionError("竟然会不等。");
		}
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
}
