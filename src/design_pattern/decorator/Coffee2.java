package design_pattern.decorator;

public class Coffee2 extends Beverage {

	@Override
	public String getDescription() {
		return "coffee2";
	}

	@Override
	public double cost() {
		return 4.0; //  coffee2 价格4元
	}
}
