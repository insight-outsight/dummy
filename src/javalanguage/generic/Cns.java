package javalanguage.generic;

public class Cns implements Lgj {

	@Override
	public String getGenericType() {
		// TODO Auto-generated method stub
		if(new Cns() instanceof Lgj){
			return "cut";
		}
		return "洽泥斯";
	}

	public int au(int i,int j){
		int n =99;
		try{
			if(i==2)throw new Exception();
			System.out.println("kkk"+n);
		}
		catch(Exception e){
			System.out.println("yi chang"+n);
			return 0;
		}
		finally{
			System.out.println("zhong"+n);
		}
		System.out.println("n ddd"+n);
		return i+j;
	}
	public static void main(String[] args) {

		String hah = "现场";
	    char u = 'S';
	    short s = 4;
	    boolean b = s==3;
	    //COMMENT 编译器JDK 8需要强转，JDK 7不需要。
	    Integer u2 = (int) 'j';
	    char hn = 98;
	    System.out.println(b);
	    System.out.println(u+3);
	    System.out.println(u2);
	    System.out.println(hn);
	    
	}
}
