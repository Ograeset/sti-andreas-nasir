package sti.andreas.nasir.domain;

import java.util.List;

public class Teacher extends Person {
    private int hourlyWage;

    public Teacher (String firstName, String lastName, int ssNumber, Course course, int hourlyWage){
        setFirstName(firstName);
        setLastName(lastName);
        setSsNumber(ssNumber);
        setCourses(course);
        setHourlyWage(hourlyWage);
    }

    public void setHourlyWage(int hourlyWage){
        this.hourlyWage = hourlyWage;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }
}
