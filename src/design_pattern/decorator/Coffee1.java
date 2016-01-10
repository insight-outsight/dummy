package design_pattern.decorator;

public class Coffee1 extends Beverage {

	@Override
	public String getDescription() {
		return "coffee1";
	}

	@Override
	public double cost() {
		return 2.0; // coffee1 价格2元
	}


}
