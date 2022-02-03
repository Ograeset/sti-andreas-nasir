
package sti.andreas.nasir.domain;

import java.util.List;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int ssNumber;
    private List<Course> courses;

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setSsNumber(int ssNumber){
        this.ssNumber = ssNumber;
    }
    public void setCourses(List<String> courses){ this.courses = courses;}

    public String getFirstName(){
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getSsNumber() {
        return ssNumber;
    }
    public List<Course> getCourses() {return courses; }
}
