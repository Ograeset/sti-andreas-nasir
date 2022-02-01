package sti.andreas.nasir.domain;

import java.util.List;

public class Teacher extends Person {
    private int hourlyWage;

    public Teacher (String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage){
        setFirstName(firstName);
        setLastName(lastName);
        setSsNumber(ssNumber);
        setCourses(courses);
        setHourlyWage(hourlyWage);
    }

    public void setHourlyWage(int hourlyWage){
        this.hourlyWage = hourlyWage;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }
}
