package design_pattern.chain_of_responsibility.style1;

import java.io.IOException;

public class FirstFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("firstFilter start....");
		chain.doFilter(request, response);
		System.out.println("firstFilter end....");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
}
