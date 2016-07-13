/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javalanguage.reflect;

/**
 * 
 * @author root
 */
public class BelleAndBeast implements IBelle, IBeast {

	@Override
	public int eat(int iii, String nnn) {
		System.out.println("吃" + nnn);		
		return iii+1;
	}

	@Override
	public void show(String something) {
		// throw new UnsupportedOperationException("Not supported yet.");
		System.out.println("fucking damned...");

	}

}