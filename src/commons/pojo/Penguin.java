package commons.pojo;

import java.io.Serializable;

public class Penguin implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5550665185301710168L;
	
	private String qualified;
	
	public Penguin(){
		System.out.println("Dog构造函数       "+System.currentTimeMillis());
	}
	
	public Penguin(String qualified) {
		super();
		this.qualified = qualified;
	}

	public String getQualified() {
		return qualified;
	}

	public void setQualified(String qualified) {
		this.qualified = qualified;
	}


	
	public Penguin clone(){
		Penguin d = null;
		try {
			d = (Penguin) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Dog 没实现Cloneable接口");
			e.printStackTrace();
		}
		return d;
	}
	
}
