package design_pattern.decorator;

public class SugarDecorator extends Beverage {

	private Beverage mBeverage;

	public SugarDecorator(Beverage mBeverage) {
		super();
		this.mBeverage = mBeverage;
	}

	@Override
	public String getDescription() {
		return mBeverage.getDescription() + " , sugar";
	}

	@Override
	public double cost() {
		return mBeverage.cost() + 2; // 加糖二元
	}
	
}
