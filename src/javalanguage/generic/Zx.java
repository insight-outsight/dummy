package javalanguage.generic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Zx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		Me722 mb = new Me722();
		System.out.println( mb.returnCh().getGenericType() );
		List<String> li = mb.listObjects();
		for(String wet :li){
			System.out.println( wet);	
		}*/
		
		Map m = new Zx().sm();
		System.out.println(m);
		
		String s = new Zx().sm();
		System.out.println(s);
		
		List l = new Zx().getExtensions(String.class);
		System.out.println(l.size());
		
	}
	
	
	public <T extends Object> T sm() {
		final int et = 5;
		return null;
	}
	public <R> R sm(R[] atg) {
		final int et = 5;
		return null;
	}
	
	<T> List<T> getExtensions(Class<T> extensionType){
		List<T> l = new ArrayList<T>(3);
		return l;
	}
	

}
