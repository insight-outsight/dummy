package design_pattern.chain_of_responsibility.style1;

import java.io.IOException;

public interface FilterChain {

    public void doFilter ( ServletRequest request, ServletResponse response )
    		throws IOException, ServletException;

}
