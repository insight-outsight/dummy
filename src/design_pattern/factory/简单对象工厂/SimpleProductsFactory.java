package design_pattern.factory.简单对象工厂;


public class SimpleProductsFactory {

	public static AbstractProducts createProductsA(String name,double price){
		return new ConcreteProductsA(name,price);
	}
	
	public static AbstractProducts createProductsB(String dateOfManufacture){
		return new ConcreteProductsB(dateOfManufacture);
	}
	
}
