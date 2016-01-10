package commons.pojo;

public class Phone {

	private String brandName;
	
	public Phone() {
		super();
	}
	
	public Phone(String brandName) {
		super();
		this.brandName = brandName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
