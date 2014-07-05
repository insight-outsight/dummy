package design_pattern.factory.抽象对象工厂;

public class SubtropicalGardener implements Gardener {

	@Override
	public Fruit createFruit(String name) {
		return new SubtropicalFruit(name);
	}

	@Override
	public Vegetable createVegetable(String name) {
		return new SubtropicalVegetable(name);
	}

}
