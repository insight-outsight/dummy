package javalanguage.hierarchy;


public class SExtd extends SBase {

	private String nm;
	
	public SExtd() {
		System.out.println("SExtd no-args Constructor ran");
	}

	public SExtd(String welcomeWord){
		super(welcomeWord);
		//this.nm = welcomeWord+"[[[[]]]]";
		System.out.println("[SExtd]"+this.getClass().getName()+"中热烈欢迎,"+welcomeWord);
	}
	
	public String getSExtdNM(){
		return this.nm;
	}
	
	public void relinquish() {
		squish(flour);
		squish(rice);
	}

	
	public static void main(String[] args) {
		
/*		System.out.println(new SBase().squish("default作用域为包内可见"));

		new SExtd().relinquish();*/
		
		SExtd sextd = new SExtd("往昔是枷锁"); 
		System.out.println(sextd.getSExtdNM());
		System.out.println(sextd.getNm());
	}


}