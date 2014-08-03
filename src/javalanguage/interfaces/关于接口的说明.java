package javalanguage.interfaces;



public class 关于接口的说明 {

	/**
	 * 关于接口的说明
	 * 1.除非在类的内部定义，接口不允许使用static修饰，在类内部定义时，接口自动就是static。
	 * 2.除非在类的内部定义，接口不允许使用protected修饰。
	 * 3.接口默认是abstract的，不管是否显式声明。
	 *   接口前修饰符只能是public，不加任何修饰符默认是包作用域可见。
	 * 4.一个接口允许继承自多个父接口。
	 * 4.接口中字段会被隐式的声明为public final static，不管加不加这些修饰
	 *   不像类中字段，接口中字段不能声名为protected.
	 *   接口中的字段只是被存储在该接口的静态存储区域内，而不属于该接口。
	 * 5.接口中的方法被隐式的声明为抽象方法public abstract，不管加不加这些修饰，
	 *   接口中的方法不能是静态方法(static)，并且不能出现方法体.
	 *   当实现一个接口时，需要将被定义的方法声明为public类型的，否则为默认访问类型，这将减小方法的
	 *   可视范围（违背LSP原则[The Liskov Substitution Principle]）,Java
	 *   编译器不允许这种情况
	 */
	public static void main(String[] args) {

	}

}
