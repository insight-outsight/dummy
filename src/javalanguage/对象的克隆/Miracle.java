package javalanguage.对象的克隆;

import commons.pojo.Penguin;


public class Miracle implements Cloneable {

	private Integer di;
	private String eman;
	private Integer[] das;
	//除非可安全地在多实例对象共享，指向可变对象的final域在clone后，多个对象仍引用同一final域，一改俱改。
	private final Penguin penguin;

	Miracle(){
		penguin = new Penguin("ahhhhhhhh");
	}
	
	public int getDi() {
		return di;
	}

	public void setDi(Integer di) {
		this.di = di;
	}

	public String getEman() {
		return eman;
	}

	public void setEman(String eman) {
		this.eman = eman;
	}

	public Integer[] getDas() {
		return das;
	}

	public void setDas(Integer[] das) {
		this.das = das;
	}

	public Penguin getPenguin() {
		return penguin;
	}

/*	public void setPenguin(Penguin penguin) {
		this.penguin = penguin;
	}*/

	public Miracle clone() {
		Miracle m = null;
		try {
			m = (Miracle) super.clone();
			//对数组单独克隆
			m.das = das.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		//m.penguin = penguin.clone();
		return m;
	}

}
