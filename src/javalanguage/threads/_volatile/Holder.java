package javalanguage.threads._volatile;
public class Holder {
    private int n;

    public Holder(int n) { this.n = n; }

    
    public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public void assertSanity() {

        if (n != n)
            throw new AssertionError("This statement is false.");
   
    }
	public void assertSanity2() {
		int n1 = n;
		int n2 = n;
		System.out.println("第一行n="+n1+",第二行n="+n2);
		
		if (n1 != n2)
			throw new AssertionError("This statement is false.");
		
	}
}


