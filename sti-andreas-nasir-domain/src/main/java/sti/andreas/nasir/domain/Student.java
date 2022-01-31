package sti.andreas.nasir.domain;

public class Student extends Person {

    public Student (String firstName, String lastName, int ssNumber, Course course){
        setFirstName(firstName);
        setLastName(lastName);
        setSsNumber(ssNumber);
        setCourses(course);
    }

}
