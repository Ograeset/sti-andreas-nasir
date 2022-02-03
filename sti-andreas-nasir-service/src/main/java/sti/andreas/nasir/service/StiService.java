package sti.andreas.nasir.service;

import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

import java.util.List;

public interface StiService {
    boolean addStudent(String firstName, String lastName, int ssNumber, List<Course> courses);

    boolean deleteStudent(int ssNumber);

    String getStudent(int ssNumber);

    boolean deleteStudentCourse(int ssNumber, String course);

    boolean addStudentCourse(int ssNumber, String course);
}
