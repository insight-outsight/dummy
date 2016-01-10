/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javalanguage.reflect;

/**
 * 
 * @author root
 */
public class ColdBelle implements IBelle, IFucker {

	
	@Override
	public void eat(String something) {
		// throw new UnsupportedOperationException("Not supported yet.");
		System.out.println("吃" + something);
	}

	@Override
	public int kfc(int iii, String nnn) {
		System.out.println("fucking damned...");
		return 0;
	}

}