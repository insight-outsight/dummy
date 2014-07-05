package design_pattern.factory.简单对象工厂;

public class ConcreteProductsA implements AbstractProducts {

	private String name;
	private double price;
	
	public ConcreteProductsA(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}
	
	@Override
	public void preserve() {
		System.out.println("ConcreteProductsA贮藏方法：密封好置于通风干燥处。");	
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof ConcreteProductsA){
			ConcreteProductsA cpa = (ConcreteProductsA)o;
			if(this.name.equals(cpa.getName()) && this.getPrice() == cpa.getPrice()){
				return true;
			}
		}
		return false;		
	}

}
