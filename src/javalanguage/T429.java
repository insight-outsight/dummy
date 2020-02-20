package javalanguage;

public class T429 {

	static int[] a = {3000,20,590,380,60,470,10000,990,4000,1,2,3,4,6,0,9};
	
	public static int maxIncSeq(int[] elements){
		if(elements.length == 1){
			return 1;
		}
		else{
			int[] elements0 = new int[elements.length-1];
			System.arraycopy(elements, 1, elements0, 0, elements0.length);
			if(elements[0] > elements[1]){
				return maxIncSeq(elements0);
			}
			else{
				return 1+maxIncSeq(elements0);
			}
		}
	}
	
	static int i = 0;
	public static void main(String[] args) {
		System.out.println(maxIncSeq(a));
		System.out.println(tf());
		
		Thread.currentThread().interrupt();
		if(Thread.currentThread().isInterrupted()){
			System.out.println(" 0 is Interrupted");
		}
		else{
			System.out.println(" 0 is not Interrupted");
		}
		if(Thread.currentThread().isInterrupted()){
			System.out.println(" 1 is Interrupted");
		}
		else{
			System.out.println(" 1 is not Interrupted");
		}
		if(Thread.currentThread().isInterrupted()){
			System.out.println(" 2 is Interrupted");
		}
		else{
			System.out.println(" 2 is not Interrupted");
		}
		System.out.println("nothing");

	}
	
	
	
	public static int tf(){
		try{
			return i;
		}finally{
			i=1000;
		}
	}
	
	public static int t(){
		i++;
		System.out.println("t"+i);
		return i;
	}
	
	public static int f(){
		i--;
		System.out.println("f"+i);
		return i;
	}
}
