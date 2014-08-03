package javalanguage.数据类型.枚举类;

import javalanguage.serializable.FileSerializableHelper;
import commons.pojo.User;


/**
 * 枚举变量其实就是类的静态变量，因此Java中的枚举类型其实是具有很多对象的特性的，只不过平时我们都不太用到，
 * 比如枚举可以实现接口(但不能继承类)、定义方法等等。为了保证枚举类型像Java规范中所说的那样，每一个枚举类
 * 型极其定义的枚举变量在JVM中都是唯一的，在枚举类型的序列化和反序列化上，Java做了特殊的规定。
 * 
 * 参考 ：http://mysun.iteye.com/blog/1581119
 * @author zcx
 *
 */
public enum EnumTypeDemo {
	/*
	 * 一个常用的处理方式是让enum类实现统一的一些共用接口，
	 * 以达到所有enum类都有共同行为
	 */
	MT(5,"昆仑山"),HT(78,"天通河");
	private final int value;
	private final String meaning;
	
	private EnumTypeDemo(int value,String meaning){
		this.value = value;
		this.meaning = meaning;
	}
	
	public Integer getValue() {
		return this.value;
	}

	public String getMeaning() {
		return this.meaning;
	}
	
	@Override
	public String toString() {
		return "调用toString()返回字符串是：" + this.meaning + "," + this.value;
	}
	
    public static EnumTypeDemo valueOf(int value) {
        for (EnumTypeDemo  e : EnumTypeDemo.values()) {
            if (e.getValue() == value) {
                return e;
            }
        }
        return null;
    }
    
	public static void main(String[] args) {
		System.out.println(EnumTypeDemo.MT.getMeaning());
		EnumTypeDemo zsn = EnumTypeDemo.MT;
		System.out.println(zsn.getValue());
		System.out.println(EnumTypeDemo.valueOf(EnumTypeDemo.class, "HT").getMeaning());
		System.out.println(EnumTypeDemo.valueOf(5));
		
		//实验枚举序列化后与原对象是同一个，==操作返回true
		EnumTypeDemo em = EnumTypeDemo.HT;
		String fileLocation = System.getenv("TMP")+"\\6.txt";
		FileSerializableHelper.object2File(em, fileLocation);
		Object o = FileSerializableHelper.file2Object(fileLocation);

		System.out.println(em == o);//true
		System.out.println("-------------------");
		
		//而普通对象则不==
		User user  = new User(25,"xw");
		fileLocation = System.getenv("TMP")+"\\7.txt";
		FileSerializableHelper.object2File(user, fileLocation);
		Object o2 = FileSerializableHelper.file2Object(fileLocation);
		System.out.println(user == o2);//false
		
	}
}