package javalanguage.reflect.method;

import java.lang.reflect.Field;

import commons.pojo.User;

public class 操作类的私有方法或属性 {

	public static void main(String[] args) {
		Class<?> userClazz = null;
		try {
			userClazz = Class.forName("commons.pojo.User");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
			Field nameField = userClazz.getDeclaredField("name");
			User user = new User();
			try {
				//直接操作私有属性会抛以下异常:
				//java.lang.IllegalAccessException: Class javalanguage.reflect.method.
				//操作类的私有方法或属性 can not access a member of class commons.pojo.User with modifiers "private"
				//因此，调用setAccessible打开私有属性访问权限。有时候这会成为一个安全隐患，为防止应用程序这么做，可以启用
				//java.security.manager来判断程序是否具有调用setAccessible()的权限。默认情况下，内核API和扩展目录的代码具有该权限，
				//而类路径或通过URLClassLoader加载的应用程序不拥有此权限。例如：当我们以这种方式来执行上述程序时将会抛出异常
				//java -Djava.security.manager 操作类的私有方法或属性.class  
				//Exception in thread "main" java.security.AccessControlException: access denied ("java.lang.reflect.ReflectPermission" "suppressAccessChecks")          
				//	at java.security.AccessControlContext.checkPermission(AccessControlContext.java:457)
				//	at java.security.AccessController.checkPermission(AccessController.java:884)
				//	at java.lang.SecurityManager.checkPermission(SecurityManager.java:549)
				//	at java.lang.reflect.AccessibleObject.setAccessible(AccessibleObject.java:128)
				//	at javalanguage.reflect.method.操作类的私有方法或属性.main(操作类的私有方法或属性.java:32)
				nameField.setAccessible(true);
				nameField.set(user, "st");
				System.out.println(user.getName());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} 
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		} 
		catch (SecurityException e) {
			e.printStackTrace();
		}

	}

}

