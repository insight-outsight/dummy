package design_pattern.chain_of_responsibility.style1;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args) {
		Filter filter1 = new FirstFilter();
		Filter filter2 = new SecondFilter();
		FilterChain fc = new FilterChainImpl(filter1,filter2);
		try {
			fc.doFilter(new ServletRequest(), new ServletResponse());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
}
