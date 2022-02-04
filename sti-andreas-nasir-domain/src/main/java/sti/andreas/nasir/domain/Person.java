
package sti.andreas.nasir.domain;

import java.util.List;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int ssNumber;
    private List<String> courses;

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
    public void addCourse(String courseToAdd) {this.courses.add(courseToAdd);}
    public void removeCourse(String courseToRemove){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i) == courseToRemove){
                this.courses.remove(i);
            }
        }
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getSsNumber() {
        return ssNumber;
    }
    public List<String> getCourses() {return courses; }
}
