package design_pattern.factory.抽象对象工厂;

public interface Gardener {

    public Fruit createFruit(String name);
    public Vegetable createVegetable(String name);
    
}
