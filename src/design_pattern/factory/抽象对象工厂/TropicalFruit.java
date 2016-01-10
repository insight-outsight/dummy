package design_pattern.factory.抽象对象工厂;

public class TropicalFruit implements Fruit {

    private String name;
    
    public TropicalFruit(String name) {
        System.out.println("创建了热带水果－"+name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
