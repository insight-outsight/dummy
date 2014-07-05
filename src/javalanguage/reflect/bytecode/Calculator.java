package javalanguage.reflect.bytecode;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


public class Calculator {

	public static void main(String[] args) throws Exception {     
		System.out.println(calculate("1+2"));
	}

	static class StringSourceJavaObject extends SimpleJavaFileObject {

		private String content = null;
		public StringSourceJavaObject(String name, String content) throws URISyntaxException {
			super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension), Kind.SOURCE);
		    this.content = content;
		}

		public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
			return content;
		}

	}
	
	private static double calculate(String expr) throws URISyntaxException {

		String className = "CalculatorMain";
		String methodName = "calculate";
		
		String source = "public class " + className
		      + " { public static double " + methodName + "() { return " + expr + "; } }";
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		StringSourceJavaObject sourceObject = new Calculator.StringSourceJavaObject("CalculatorMain", source);
		Iterable< ? extends JavaFileObject> fileObjects = Arrays.asList(sourceObject);
		CompilationTask task = compiler.getTask(null, fileManager, null, null, null, fileObjects);
		
	    boolean result = task.call();
	    if (result) {
	    	ClassLoader loader = Calculator.class.getClassLoader();
	    	try {           
	    		Class<?> clazz = loader.loadClass(className);
		        Method method = clazz.getMethod(methodName, new Class<?>[] {});
		        Object value = method.invoke(null, new Object[] {});
		        return (Double) value;
	    	} 
	    	catch (Exception e) {
	    		e.printStackTrace();
	    		throw new RuntimeException("内部错误。"); 
	    		
	    	}   
	    } 
	    else {
		   throw new RuntimeException("错误的表达式。");   
	    }

	}
	
}
