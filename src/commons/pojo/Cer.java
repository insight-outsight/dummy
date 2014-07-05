package commons.pojo;

import java.io.Serializable;

/*import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;*/

public class Cer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5627920611858624893L;
	
	private int code;
	private String explain;
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getExplain() {
		return explain;
	}
	
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
/*	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
	}*/
	
}
