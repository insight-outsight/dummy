package javalanguage;

/**
 * 
 Description
 * 
 * Below I present you two different ways to get the current Class:
 * 
 * Using Thread Using getClass()
 * 
 * The simplest way to get the name of the class where your code is being
 * executed in is using the getClass() method present in every java object. Like
 * here:
 * 
 * String clazz = this.getClass().getName();
 * 
 * This works only if executed in an Object, namely an instanciated class. If
 * you try to execute the code above in a static method. It won't work. Even the
 * keyword this is meaningless in a static method.
 * 
 * Also, the class returned by the above method may actually be a subclass of
 * the class in which the method is defined. This is because subclasses inherit
 * the methods of their parents; and getClass() returns the actual runtime type
 * of the object. To get the actual class in which a method is defined, use the
 * method below also.
 * 
 * In a static method you can instead use the following:
 * 
 * String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
 * 
 * Which uses the static methodgetStackTrace() to get the whole stacktrace. This
 * method returns an array, where the first element (index 0) is the
 * getStackTrace() you called and the second element (index 1) is the method
 * your code is in.
 * 
 * A similar trick can be used to find out the name of the method currently
 * executed:
 * 
 * String method = Thread.currentThread().getStackTrace()[1].getMethodName();
 * 
 * It's exactly the same principle, just you dig out the name of the method
 * instead of the class.
 * 
 * 
 * Ref:http://blog.sina.com.cn/s/blog_4a4f9fb50101eyfp.html
 * 
 * @author zcx
 *
 */
public class 获取当前线程执行的类名和方法名 {
	public static void main(String[] args) {
		
//		getCaller();
		System.out.println("-------------------------------------------------");
		获取当前线程执行的类名和方法名 methodNameGetter = new 获取当前线程执行的类名和方法名();
//		String clazz = new Throwable().getStackTrace()[1].getClassName();//main方法中不能用这个，虽然这个据说速度更快
		/**
		 * As pointed in many answers below - the new Throwable().getStackTrace() is much faster, because it
		 *  doesn't need to check this != Thread.currentThread() and bypasses potential JVM overheads of
		 *   calling it through child-class
		 *   
		 *   Thread.currentThread().getStackTrace();
is fine if you don't care what the first element of the stack is.

new Throwable().getStackTrace();
will have a defined position for your current method, if that matters.

(new Throwable()).getStackTrace() is faster executing too (see bugs.sun.com/bugdatabase/view_bug.do?bug_id=6375302 ) – MightyE Aug

From: https://stackoverflow.com/questions/1069066/get-current-stack-trace-in-java

另一篇分析：https://www.cnblogs.com/lcchuguo/p/5335689.html

		 */
		String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("Class Name: " + clazz + "，Method Name: " + methodName);
		methodNameGetter.anotherMethod();

	}

	private void anotherMethod() {

//		String clazz = this.getClass().getName();
		String clazz = new Throwable().getStackTrace()[1].getClassName();

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("am Class Name: [" + clazz + "]，Method Name: " + methodName);
		methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println("am Caller Class Name: [" + clazz + "]，Caller Method Name: " + methodName);
		anotherAnotherMethod();

	}

	private void anotherAnotherMethod() {

//		String clazz = this.getClass().getName();
		String clazz = new Throwable().getStackTrace()[1].getClassName();

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("aam Class Name: [" + clazz + "]，Method Name: " + methodName);
		methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println("aam Caller Class Name: [" + clazz + "]，Caller Method Name: " + methodName);
		
	}

	public static void getCaller() {
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		for (int i = 0; i < stack.length; i++) {
			StackTraceElement ste = stack[i];
			System.out.println(ste.getClassName() + "." + ste.getMethodName() + "(...);");
			System.out.println(i + "--" + ste.getMethodName());
			System.out.println(i + "--" + ste.getFileName());
			System.out.println(i + "--" + ste.getLineNumber());
		}
	}

}
