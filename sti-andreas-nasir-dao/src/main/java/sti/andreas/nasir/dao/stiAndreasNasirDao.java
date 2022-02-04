package sti.andreas.nasir.dao;

import sti.andreas.nasir.domain.*;

import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

import java.util.List;

public interface stiAndreasNasirDao {

    boolean addTeacher(String firstName, String lastName, int ssNumber, List<String> courses, int hourlyWage);

    boolean deleteTeacher(int ssNumber);

    Teacher getTeacher(String courseId);

    boolean addStudent(String firstName, String lastName, int ssNumber, List<String> courses);

    boolean deleteStudent(int ssNumber);

    Student getStudent(int ssNumber);

    boolean deleteStudentCourse(int ssNumber, String course);

    boolean addCourse(int credits, int lengthOfCourse, Teacher teacher, String courseCode);

    boolean addStudentCourse(Student student, String course);

    boolean deleteCourse(String courseCode);

    List<String> getStudentCourses(int ssNumber);


}
