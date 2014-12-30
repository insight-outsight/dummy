package jdk8.newfeatures.pojo;


public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
