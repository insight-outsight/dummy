package design_pattern.chain_of_responsibility.style1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterChainImpl implements FilterChain{

	private List<Filter> filterList = new ArrayList<Filter>();
	private int currentExecutingFilterPos = 0;
	private Servlet servlet;
	
	public FilterChainImpl(Filter... filter){
		filterList.addAll(Arrays.asList(filter));
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response)
			throws IOException, ServletException {
        if (currentExecutingFilterPos < filterList.size()) {
            Filter filter = filterList.get(currentExecutingFilterPos++);
            filter.doFilter(request, response, this);
        } else {
			// filter都处理完毕后，执行servlet
        	if(servlet!=null){
                servlet.service(request, response);
        	}
        }
	}

}
