package javalanguage.数据类型.数组;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {

	public static void main(String[] args) {

		/* 使用Java数组前必须对数组进行初始化，初始化的过程即给数组的所有元素都分配合适的内存空间，并指定初始值的过程。
		 * 数组初始化以后将不能重新改变数组对象在内存中的位置和大小。从用法角度看，数组元素相当于普通变量，程序既可以把
		 * 数组的值赋给普通变量，也可以把普通变量的值赋给数组元素。但其实质是对内存中数组元素对象的操作。
		 */
		
/*		1、数组初始化
		Java语言是典型的静态语言，所以Java的数组也是静态的。Java中的数组必须经初始化后才可以使用，
		初始化即为数组对象的所有元素分配一个连续的内存空间，并为每个元素指定初始值。数组的初始化有两种方式：

		>静态初始化：由程序员显式地指定每个数组元素的初始值，由系统决定数组的长度；
		>动态初始化：程序员只指定数组长度，由系统为数组元素分配初始值。

		下面是两种初始化方式的实例：*/

		//静态初始化数组
		String[] sa0 = new String[]{"众合" , "408"};
		//静态初始化的简化形式
		String[] sa1 = {"众合" , "408"};
		//动态初始化
		String[] sa2 = new String[2];
		float[] sa3 = new float[3];
		/* 执行动态初始化时，程序员指定了数组的长度，即为每个数组元素指定所需的内存空间，
		        系统负责为这些数组元素分配初始值。系统将按照如下规则分配到初始值：
		>基本类型：
       		>整数类型(byte , short , int , long)：数组元素的初始值为0；
       		>浮点类型(float , double)：0.0；
       		>字符类型(char , string)：’\u0000’；
       		>布尔型(boolean)：false；
		>引用类型(类、接口和数组)：null
		*/
		System.out.println(sa2[0]);
		System.out.println(sa3[0]);
		
		//结果打印true，若把sa1第一个元素换成new String("众合")，则打印false		
		System.out.println(sa0[0] == sa1[0]);
		
		
		/*Java中数组由两部分组成：数组变量和数组对象。
		 * 数组对象可以是基本类型（这时数组对象的元素直接存放就是数组内容），
		 * 也可以是引用类型（这时数组对象的元素存放对象在堆内存中地址的引用）。
		 * 无论哪种情况，数组对象是保存在堆内存中的连续内存空间。理解了这两个概念之后，我们可以对数组的初始化有一个更深的认识，
		 * 即对数组执行初始化，其实并不是对数组变量执行初始化，而是要对数组对象执行初始化(即为该数组对象分配一块连续的内存空间)。
		 * 认识到这一点之后我们可以解释这样一种假象，即认为数组的长度是可变的，例如下面的实例：
		 */
        String[] str0 = new String[]{"小武灵灵" , "41009160" , "陕西师范大学"};
        String[] str1 = new String[2];
        str1 = str0;
        System.out.println("str0的长度为:" + str0.length);
        System.out.println("str1的长度为:" + str1.length);
        /*相信大家可以自行解释这种假象*/
        
        /*上面说到数组对象分两种基本类型和引用类型。
         * 1).基本类型数组的初始化过程为：程序直接为数组分配内存空间，再将数组元素的值存入对应的内存里。例如下面的代码块：
         * int[] nums;
         * nums = new int[]{3,2,1};
         * 
         * 2).引用类型数组的数组元素依然是引用类型的，因此数组元素里存储的还是引用，它指向另一块内存，
         * 这块内存里存储了该引用变量所引用的对象。例如：
         * Student[] stu = new Student[2];
         * System.out.println(“数组长度:” + stu.length);
         * Student xiaoming = new Student("小明","100092");
         * stu[0] = xiaoming;
		 * //下面两行代码所输出的结果都是一样的
       	 * stu[0].getName();
         * xiaoming.getName();
         */
        
        System.out.println("--------------以下测试数组类型---------------");
        System.out.println(String.class);
        System.out.println(Integer.class);
        System.out.println(Long.class);
        System.out.println(Double.class);
        System.out.println(Object.class);
        System.out.println(int.class);
        System.out.println(int.class.getName());
        System.out.println(long.class);
        System.out.println(double.class);
        System.out.println(int[].class);
        System.out.println(long[].class);
        System.out.println(float[].class);
        System.out.println(double[].class);
        System.out.println(long[].class.getSimpleName());
        System.out.println(String[].class);
        System.out.println(String[].class.getName());
        System.out.println(String[].class.getSimpleName());
        System.out.println(Integer[].class);
        System.out.println(Integer[].class.getName());
        System.out.println(Integer[].class.getSimpleName());
        System.out.println(int[].class);
        System.out.println(int[].class.getName());
        System.out.println(int[].class.getSimpleName());
        
        Long[] o = new Long[2];
        o[0]=9l;
        System.out.println(o[0]);
        int[] a5 = new int[3];
        System.out.println(a5 instanceof int[]);
        Integer[] u7 = new Integer[7];
        System.out.println(u7 instanceof Number[]);  
        Number[] n7 = new Integer[7];
        System.out.println(n7 instanceof Number[]);
        System.out.println(n7 instanceof Integer[]);  
        
        Object[] o7 = new Object[7];
        System.out.println(o7 instanceof Object[]);
        System.out.println(o7 instanceof String[]);
	}
	
	
	
}
