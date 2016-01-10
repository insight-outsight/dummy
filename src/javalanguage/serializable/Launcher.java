package javalanguage.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import commons.pojo.Zebra;


public class Launcher {


    /**
     * @param args
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    	
    	/*以下序列化/反序列化一个List对象*/
    	String thisClassPackageName = Launcher.class.getPackage().getName();
        String fileName = Launcher.class.getResource("/"+thisClassPackageName.replace(".", "/")+"/").getPath()
        				+"object.ser";
        //打印类似/F:/ews/LearningJDK/bin/javalanguage/serializable/
        //System.out.println(fileName);

/*        List<String> list = new ArrayList<String>();
        list.add("michael");
        list.add("大大");
        list.add("wb发脾气");

        object2File(list, fileName);
        System.out.println("success write List<String> to file.");

        List<String> tmpList = (List<String>) file2Object(fileName);  
        for (String tmp : tmpList) {  
            System.out.println(tmp);  
        }  */
        
        /*以下序列化/反序列化一个JavaBean对象*/
        System.out.println("--------------------------------");

        Zebra z = new Zebra("纽约动物园",35);
        FileSerializableHelper.object2File(z, fileName);
        System.out.println("success write bean:Zebra to file.");

        Zebra zb = (Zebra) FileSerializableHelper.file2Object(fileName);
        System.out.println("read bean:Zebra from file get info : \n" + zb);

   
    }

}



