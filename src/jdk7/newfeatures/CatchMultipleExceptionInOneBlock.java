package jdk7.newfeatures;


public class CatchMultipleExceptionInOneBlock {

	public static void main(String[] args) {
		
		try{
			int a = Integer.parseInt("58");
			System.out.println(a);
			int b[] = {2,4,7};
			System.out.println(b[4]);
		}
		catch(NumberFormatException |ArrayIndexOutOfBoundsException e){
			System.out.println("出错了。");
			e.printStackTrace();		
		}

	}

}
