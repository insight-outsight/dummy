package javalanguage.数据类型.枚举类;

public enum 只可实现接口不可继承  implements BaseEnum{
	是,否;

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(只可实现接口不可继承.是.name());
		System.out.println(只可实现接口不可继承.valueOf("否"));
		System.out.println(Enum.valueOf(只可实现接口不可继承.class, "是"));
		System.out.println(只可实现接口不可继承.是.getVersion());
		System.out.println(只可实现接口不可继承.valueOf("wer"));
	}

}
