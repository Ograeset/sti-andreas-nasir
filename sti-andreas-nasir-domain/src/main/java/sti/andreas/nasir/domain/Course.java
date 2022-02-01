package sti.andreas.nasir.domain;

public class Course {
private int credits;
private Teacher teacher;
private String courseCode;

    public Course(int credits, Teacher teacher, String courseCode){
        setcredits(credits);
        setTeacher(teacher);
        setCourseCode(courseCode);
    }

    public void setcredits(int credits) {}
    public int credits(){return credits; }

    public void setCourseCode(String courseCode){}
    public String getCourseCode(){return courseCode;}

    public void setTeacher(Teacher teacher){}
    public Teacher getTeacher(){return teacher;}
}
