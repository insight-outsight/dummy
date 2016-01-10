package design_pattern.factory.抽象对象工厂;

public class TropicalGardener implements Gardener {

	@Override
	public Fruit createFruit(String name) {
		return new TropicalFruit(name);
	}

	@Override
	public Vegetable createVegetable(String name) {
		return new TropicalVegetable(name);
	}

}
