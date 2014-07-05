package javalanguage.interfaces;

/**
 * 创建接口对象
 * @see {@code CreateAbstractClassInstance}
 * 
 * @author XUZHENGCHAO
 *
 */
public class CreateInterfaceInstance {

	public static void main(String[] args) {
		
		new  Ambiguous (){
			public void doInfringe(){
				System.out.println("you huandian me");
			}
		}.doInfringe();
		
	}

}
