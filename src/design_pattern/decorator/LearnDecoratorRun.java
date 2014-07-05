package design_pattern.decorator;

import java.net.URL;

public class LearnDecoratorRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		System.out.println("要一份加糖的种类为coffee1的咖啡：");
		Beverage beverage = new SugarDecorator(new Coffee1());
		System.out.println("种类 : " + beverage.getDescription() + "\n价格 : "
				+ beverage.cost());

		System.out.println("要一份加糖加两份牛奶的种类为coffee2的咖啡：");
		beverage = new SugarDecorator(new MilkDecorator(new MilkDecorator(
				new Coffee2())));
		System.out.println("种类 : " + beverage.getDescription() + "\n价格 : "
				+ beverage.cost());


	}
}
