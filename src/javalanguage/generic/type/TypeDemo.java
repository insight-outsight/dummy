package javalanguage.generic.type;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;

public class TypeDemo {

	public static void main(String[] args) {
		
		Collection<String> c = new ArrayList<String>();
		ParameterizedType parameterizedType = (ParameterizedType) c.getClass().getGenericInterfaces()[0];
		System.out.println(parameterizedType.getActualTypeArguments()[0]);//E
		System.out.println(parameterizedType.getRawType());//interface java.util.List
		System.out.println(parameterizedType.getOwnerType());//null
		System.out.println("-------------------------------------------");
		ExtendNestedGenericParameterizedType<String> nestedClassObject = new ExtendNestedGenericParameterizedType<String>();
		ParameterizedType nestedParameterizedType = (ParameterizedType) nestedClassObject.getClass().getGenericSuperclass();
		System.out.println(nestedParameterizedType.getActualTypeArguments()[0]);//Q
		System.out.println(nestedParameterizedType.getRawType());//class javalanguage.generic.type.EnclosingNestedGenericParameterizedType$NestedGenericParameterizedType
		System.out.println(nestedParameterizedType.getOwnerType());//class javalanguage.generic.type.EnclosingNestedGenericParameterizedType

	}

}
