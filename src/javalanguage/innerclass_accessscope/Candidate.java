package javalanguage.innerclass_accessscope;

import java.io.Serializable;

import commons.pojo.Cer;


/*import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;*/

public class Candidate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8696431063666222888L;
	private String[] s = new String[2];
	private Cer cer;
	protected String beta;
	int octopus = 15;
	public Candidate(){
		System.out.println("ni bu xing a");
	}
	
	public Candidate(String haha){
		System.out.println("ni bu xing a");
	}

	public String[] getS() {
		return s;
	}

	public void setS(String[] s) {
		this.s = s;
	}

	public Cer getCer() {
		return cer;
	}

	public void setCer(Cer cer) {
		this.cer = cer;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
/*	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
	}*/
}
