<<<<<<< HEAD:sti-andreas-nasir-domain/src/main/java/sti/andreas/nasir/domain/Person.java
=======
package sti.andreas.nasir.domain;

import java.util.List;
>>>>>>> 885381594e45dc2771fe139bc68498050d1ba3a8:sti-andreas-nasir-domain/Person.java

package sti.andreas.nasir.domain;

import java.util.List;
public abstract class Person {
    private String firstName;
    private String lastName;
    private int ssNumber;
    //private List<Course> courses;

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setSsNumber(int ssNumber){
        this.ssNumber = ssNumber;
    }
    /*public void setCourses(Course course){
        this.courses.add(course);
    }*/
    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSsNumber() {
        return ssNumber;
    }

    /*public List<Course> getCourses() {
        return courses;
    }*/
}
