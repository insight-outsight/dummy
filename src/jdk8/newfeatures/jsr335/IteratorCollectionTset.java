package jdk8.newfeatures.jsr335;

import java.util.ArrayList;
import java.util.List;

import jdk8.newfeatures.pojo.Person;

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

