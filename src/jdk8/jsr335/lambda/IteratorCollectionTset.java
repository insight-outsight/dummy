package jdk8.jsr335.lambda;

import java.util.ArrayList;
import java.util.List;

public class IteratorCollectionTset {
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Joe","Doe"));
		persons.add(new Person("Jim","Green"));
		persons.add(new Person("John","Steven"));  
		for (Person p :  persons) {  
		   p.setLastName("Smith");  
		}
		System.out.println(persons);
		
		//lambda style
		persons.forEach(p->p.setLastName("Howard"));		
		System.out.println(persons);
	}
	
}

class Person{
	
	String firstName;
	String LastName;
	
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		LastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", LastName=" + LastName
				+ "]";
	}

	
}