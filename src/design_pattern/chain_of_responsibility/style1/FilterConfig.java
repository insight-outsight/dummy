package design_pattern.chain_of_responsibility.style1;

import java.util.Enumeration;


public interface FilterConfig {

    public String getFilterName();

    public ServletContext getServletContext();
    
    public String getInitParameter(String name);

    public Enumeration<String> getInitParameterNames();

}
