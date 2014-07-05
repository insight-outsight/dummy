package design_pattern.factory.抽象对象工厂;

public class SubtropicalFruit implements Fruit {

    private String name;
    public SubtropicalFruit(String name) {
        System.out.println("创建了亚热带水果－"+name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
