package sti.andreas.nasir.domain;

import java.util.List;

public class Teacher extends Person {
    private int hourlyWage;
    List<String> courses;

    public Teacher (String firstName, String lastName, int ssNumber, List<String> courses, int hourlyWage){
        setFirstName(firstName);
        setLastName(lastName);
        setSsNumber(ssNumber);
        setTeacherCourses(courses);
        setHourlyWage(hourlyWage);
    }

    public void setTeacherCourses(List<String> courses){this.courses = courses;}


    public void setHourlyWage(int hourlyWage){
        this.hourlyWage = hourlyWage;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }
}
