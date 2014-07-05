package design_pattern.factory.抽象对象工厂;

public class SubtropicalVegetable implements Vegetable {

    private String name;
    public SubtropicalVegetable(String name) {
        System.out.println("创建了亚热带蔬菜－"+name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
