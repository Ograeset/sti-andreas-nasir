package sti.andreas.nasir.service;

import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

import java.util.List;

public interface StiService {

    boolean addStudent(String firstName, String lastName, int ssNumber, List<String> courses);

    void deleteStudent(int ssNumber);

    Student getStudent(int ssNumber);

    void deleteStudentCourse(Student student, String courseToRemove);

    void addStudentCourse(Student student, String courseToAdd);

    List<String> getStudentCourses(int ssNumber);

    void run();
}
