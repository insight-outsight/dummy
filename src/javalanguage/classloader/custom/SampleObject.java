/*package javalanguage.classloader.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SampleObject {
    
    private SampleObject instance;
    
    SampleObjectField sof;
    
    public void setSample(Object obj){
        this.instance = (SampleObject)obj;
        System.out.println("set SampleObject.");
    }

    public void createSampleObjectField() throws ClassNotFoundException, 
    InstantiationException, IllegalAccessException, 
    NoSuchMethodException, SecurityException, 
    IllegalArgumentException, ReflectiveOperationException{
    	System.out.println("SampleObject.getClass().getClassLoader()="+getClass().getClassLoader());
    	Class sofClass = Class.forName("javalanguage.classloader.custom.SampleObjectField");
    	Object o = sofClass.newInstance();
    	Method method55 = sofClass.getMethod("setValue", String.class);
        method55.invoke(o, "v2");
    	Method method56 = sofClass.getMethod("toString");
        System.out.println(method56.invoke(o));
    }
	public SampleObjectField getSof() {
		return sof;
	}

	public void setSof(SampleObjectField sof) {
		this.sof = sof;
	}
    
} */
