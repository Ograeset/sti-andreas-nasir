package sti.andreas.nasir.dao;
import sti.andreas.nasir.domain.*;

import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

import java.util.List;

public interface stiAndreasNasirDao {

    Teacher addTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage);

    boolean deleteTeacher(int ssNumber);

    Student addStudent(String firstName, String lastName, int ssNumber, List<Course> courses);

    boolean deleteStudent(int ssNumber);

    Student getStudent(int ssNumber);

    Course addCourse(int credits, int lengthOfCourse, Teacher teacher, String courseCode);

    boolean deleteCourse(String courseCode);


}
