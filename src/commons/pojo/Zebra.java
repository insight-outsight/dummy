package commons.pojo;

import java.io.Serializable;

public class Zebra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5465693005543473065L;
	
	private String residence; 
	private int age;
	
	
	public Zebra() {
		super();
	}

	public Zebra(String residence, int age) {
		super();
		this.residence = residence;
		this.age = age;
	}
	
	public String getResidence() {
		return residence;
	}
	
	public void setResidence(String residence) {
		this.residence = residence;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return "residence="+residence+"\n"
				+"age="+age;
	}
	

}
