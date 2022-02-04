package sti.andreas.nasir.domain;

import java.util.ArrayList;
import java.util.List;

public class Vault {
    List<Course> coursesList = new ArrayList<>();
    public List<Student> students = new ArrayList<>();


    Course javab = new Course(50, 100, null, "JavaB");
    Course html = new Course(25, 50, null, "HTML");
    Course databas = new Course(75, 125, null, "Databas");

    List<String> teacher_courses1 = new ArrayList<String>();
    List<String> teacher_courses2 = new ArrayList<String>();
    List<String> student_courses = new ArrayList<String>();
    List<String> student_courses2 = new ArrayList<String>();


    public Vault() {
        Teacher teacher = new Teacher("Kibar", "Özgur", 910101, teacher_courses1, 150);
        teacher_courses1.add("JavaB");
        teacher_courses1.add("Databas");
        javab.setTeacher(teacher);
        databas.setTeacher(teacher);


        Teacher teacher1 = new Teacher("Kibba", "Öz", 901010, teacher_courses2, 300);
        teacher_courses2.add("HTML");
        html.setTeacher(teacher1);

        student_courses.add("JavaB");
        Student student = new Student("Andreas", "Sjödén", 920727, null);
        student.setCourses(student_courses);
        students.add(student);

        student_courses2.add("JavaB");
        student_courses2.add("HTML");
        Student student1 = new Student("Nasir", "Tedros", 880101, null);
        student1.setCourses(student_courses2);
        students.add(student1);
    }

    public List<Student> getStudents() {
        return this.students;
    }
}
