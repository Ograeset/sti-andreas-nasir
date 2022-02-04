package sti.andreas.nasir.domain;

import java.util.List;

public class Student extends Person {

    public Student (String firstName, String lastName, int ssNumber, List<String> courses){
        setFirstName(firstName);
        setLastName(lastName);
        setSsNumber(ssNumber);
        setCourses(courses);
    }
}
