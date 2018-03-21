package design_pattern.chain_of_responsibility.style3;

import java.util.Properties;

/**
 * copy from package org.apache.ibatis.plugin;
 * @author Clinton Begin
 */
public interface Interceptor {

  Object intercept(Invocation invocation) throws Throwable;

  Object plugin(Object target);

  void setProperties(Properties properties);

}