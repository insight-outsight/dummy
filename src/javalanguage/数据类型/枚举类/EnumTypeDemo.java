package javalanguage.数据类型.枚举类;

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
	}
}