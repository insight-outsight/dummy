package design_pattern.factory.简单对象工厂;


public class LearnFactoryRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		AbstractProducts a = SimpleProductsFactory.createProductsA("牛奶", 3.5);
		AbstractProducts b = SimpleProductsFactory.createProductsB("2012-08-12");
		a.preserve();
		b.preserve();
		ConcreteProductsA cpa = (ConcreteProductsA)a;
		System.out.println(cpa.getName()+"^^^"+cpa.getPrice());
		
		AbstractProducts a2 = SimpleProductsFactory.createProductsA("牛奶", 3.5);
		System.out.println("a==a2条件为"+(a==a2));
		System.out.println("a.equals(a2)条件为"+(a.equals(a2)));

	}

}
