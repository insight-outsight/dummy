package design_pattern.chain_of_responsibility.style1;

import java.io.IOException;

public class SecondFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("secondFilter start....");
		chain.doFilter(request, response);
		System.out.println("secondFilter end....");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}