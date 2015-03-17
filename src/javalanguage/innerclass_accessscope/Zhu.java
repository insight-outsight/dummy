package javalanguage.innerclass_accessscope;

import commons.pojo.Cer;


public class Zhu {

	private String wtt = "bbc";
	public final static Cer cer = new Cer();
	
	public String getWtt() {
		return wtt;
	}
	public void setWtt(String wtt) {
		this.wtt = wtt;
	}
	public static Cer getCer() {
		String tp = new Candidate().beta;
		int a = new Candidate().octopus;
		return cer;
	}
	public void accessParent(){
		System.out.println(new Zhu.Rou().accessParent());
	}
	
	public static class Rou{
		private String relinquish;
		private String wtt = "bbc2";
		public String getRelinquish() {
			return relinquish;
		}

		public void setRelinquish(String relinquish) {
			this.relinquish = relinquish;
		}
		
		public String  accessParent(){
			//Zhu zhu = new Zhu();
			
			return wtt;
		}
		public void setParent(String val){
			wtt = val;
		}
	}
	
}
