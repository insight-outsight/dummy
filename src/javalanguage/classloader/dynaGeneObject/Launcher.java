package javalanguage.classloader.dynaGeneObject;


public class Launcher {

	/**
	 * 怎样使用classloader动态加载类
	 * 注意，
	 * 1.对于动态加载的类，一定要有相应作用域可见的构造函数，一般是public,避免抛java.lang.IllegalAccessException
	 * 2.老规矩，如果类中有有参构造函数，一定要显示提供一个无参构造函数，否则抛java.lang.InstantiationException。
	 * 
	 */
	public static void main(String[] args) {
		
		String CLASS_IS = "javalanguage.classloader.dynaGeneObject.BeLoadedDynamic";		

		try {
			//Class<research.classloader.BeLoadedDynamic> c = 
				//(Class<research.classloader.BeLoadedDynamic>) Class.forName(CLASS_IS);
			Class<? extends Object> c = Class.forName(CLASS_IS);
			System.out.println("Class类的名称是"+c.getClass().getName());
			
			try {
				//直接得到对象
				Object o =  c.newInstance();
				System.out.println("载入的类名称是"+o.getClass().getName());
				
				if(o instanceof BeLoadedDynamic){
					System.out.println("forName()后不丢失类型");
				}
				//客户端拿到返回对象后可以再转成具体对象，但前提是客户端确定并已知返回类型
				BeLoadedDynamic bld = (BeLoadedDynamic)o;
				System.out.println("Sunday@@@@" + bld.oha);;
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
