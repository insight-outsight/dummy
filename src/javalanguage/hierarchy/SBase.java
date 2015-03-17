package javalanguage.hierarchy;

public class SBase {
	
	private int ag;
	private String nm;
	String flour = "免奋";
	protected String rice = "打密";
	
	public SBase(){
		System.out.println("SBase no-args Constructor ran");
	}
	
	public SBase(String welcomeWord){
		this.nm=welcomeWord;
		System.out.println("[SBase]"+this.getClass().getName()+"中热烈欢迎,"+welcomeWord);
	}

	public int getAg() {
		return ag;
	}

	public void setAg(int ag) {
		this.ag = ag;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}
	
	protected String squish(String bb){
		return bb+"alpha";
	}
	
	
}