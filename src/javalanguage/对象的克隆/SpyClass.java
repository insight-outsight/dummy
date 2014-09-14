package javalanguage.对象的克隆;

import commons.pojo.User;


public class SpyClass implements Cloneable{

	private boolean flag;
	private User user = new User(5,"Jacob");


	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	@Override
	public String toString() {
		return "SpyClass [flag=" + flag + ", user=" + user + "]";
	}
	
	public SpyClass clone(){
		try {
			System.out.println("omg="+super.clone().getClass());
			SpyClass cloned =  (SpyClass)super.clone();
			cloned.setUser(new User(22,"Allison"));
			return cloned;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {

		SpyClass sc = new SpyClass();
		System.out.println("origin---"+sc);
		SpyClass c = sc.clone();
		System.out.println("cloned---"+c);
		
		sc.getUser().setName("mmmmmmmmmmmmmmmm");
		//sc.s(37);
		System.out.println("...origin---"+sc);
		System.out.println("...cloned---"+c);
		
		System.out.println(sc==c);
	}
}
