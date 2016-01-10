package javalanguage.数据类型.数组;

/*
 * 如果已有的类型是int，在其后增加[]后得到一个数组类型；以int[]类型为已有类型，在其后增加[]后得到int[][]依然是数组类型；
 * 以int[][]类型为已有类型，在其后增加[]后得到int[][][]依然是数组类型。
 * 从上面可以看出，所谓多维数组，其实就是数组元素依然是数组的1维数组，2维数组是数组元素是1维数组的数组，
 * 3维数组是数组元素是2维数组的数组，4维数组是数组元素是3维数组的数组……N维数组是数组元素是N-1维数组的数组。
 * 
 * 所以，实际上我们可以这样认为：没有多维数组，只有基本数据类型和引用数据类型。
 */
public class 多维数组 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//定义一个三维数据
    	String[][][] ser = {
    			{
    				{},{"235","dgr","ubb"},{"使命","5","大规模授信","wer"}
    					},
    			{
    					{},{}
    					}
    			};
    	//数据定位时顺序是按[][][]从右往左
    	System.out.println(ser[1].length);
    	System.out.println(ser[0][1].length);
    	System.out.println(ser[0][0].length);

	}

}
