package design_pattern.singleton;

import javalanguage.serializable.FileSerializableHelper;
import javalanguage.serializable.Launcher;

import commons.pojo.Zebra;

public class 序列化单例类的思考 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
    	/*以下序列化/反序列化一个List对象*/
    	String thisClassPackageName = 序列化单例类的思考.class.getPackage().getName();
        String fileName = Launcher.class.getResource("/"+thisClassPackageName.replace(".", "/")+"/").getPath()
        				+序列化单例类的思考.class.getSimpleName()+".ser";
        //打印出/F:/ews/LearningJDK/bin/design_pattern.singleton/序列化单例类的思考.ser
        //System.out.println(fileName);
        
        /*以下序列化/反序列化一个JavaBean对象*/
        System.out.println("--------------------------------");

        Singleton s = Singleton.getInstance();
        FileSerializableHelper.object2File(s, fileName);
        System.out.println("成功序列化对象到文件"+fileName);

        Singleton sb = (Singleton) FileSerializableHelper.file2Object(fileName);
        System.out.println("成功从文件"+fileName+"反序列化对象");

        System.out.println("--------------------------------");
        
        System.out.println("单例反序列化后与原对象是同一个吗？"+(s==sb));
	}

}
