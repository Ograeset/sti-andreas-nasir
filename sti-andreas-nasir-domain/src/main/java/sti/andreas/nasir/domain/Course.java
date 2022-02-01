package sti.andreas.nasir.domain;

public class Course {
private int credits;
private Teacher teacher;
private String courseCode;
private int lengthOfCourse;

    public Course(int credits, int lengthOfCourse, Teacher teacher, String courseCode){
        setcredits(credits);
        setTeacher(teacher);
        setCourseCode(courseCode);
        setLengthOfCourse(lengthOfCourse);
    }

    public void setcredits(int credits) {this.credits = credits;}
    public int getCredits(){return credits; }

    public void setCourseCode(String courseCode){this.courseCode = courseCode;}
    public String getCourseCode(){return courseCode;}

    public void setTeacher(Teacher teacher){this.teacher = teacher;}
    public Teacher getTeacher(){return teacher;}

    public void setLengthOfCourse(int lengthOfCourse) {this.lengthOfCourse = lengthOfCourse;}
    public int getLengthOfCourse(){return lengthOfCourse;}
}
