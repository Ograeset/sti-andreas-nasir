package sti.andreas.nasir.dao;

import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

import java.util.List;

public interface stiAndreasNasirDao {

    Teacher addTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage);

    boolean deleteTeacher(int ssNumber);

    boolean addStudent(String firstName, String lastName, int ssNumber, List<Course> courses);

    boolean deleteStudent(int ssNumber);


}
