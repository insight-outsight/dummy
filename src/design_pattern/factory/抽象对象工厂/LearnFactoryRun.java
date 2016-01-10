package design_pattern.factory.抽象对象工厂;

public class LearnFactoryRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Gardener tropicalGardener = new TropicalGardener();
		Gardener subtropicalGardener = new SubtropicalGardener();
		
		@SuppressWarnings("unused")
		Fruit coconut,apple;
		@SuppressWarnings("unused")
		Vegetable fiddlehead,eggplant;
		
		coconut = tropicalGardener.createFruit("椰子");
		fiddlehead = tropicalGardener.createVegetable("蕨菜 ");
		
		apple = subtropicalGardener.createFruit("苹果");
		eggplant = subtropicalGardener.createVegetable("茄子");
		
		

	}

}
