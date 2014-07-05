package design_pattern.factory.简单对象工厂;

public class ConcreteProductsB implements AbstractProducts {

	private String dateOfManufacture;

	public ConcreteProductsB(String dateOfManufacture) {
		super();
		this.dateOfManufacture = dateOfManufacture;
	}
	
	public String getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(String dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	@Override
	public void preserve() {
		System.out.println("ConcreteProductsB贮藏方法：放在冰箱。");		
	}


}
