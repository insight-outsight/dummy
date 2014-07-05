package javalanguage;

public class AssertTset {
	
	//要使用assert，必须在java命令执行时加-ea参数，否则assert关键字无效。
	//与之相对应的是-da。
	public static void main(String[] args) {

		int i=5;
		assert i>10:"nidakai";
		System.out.println("not reachable");
	}

}




