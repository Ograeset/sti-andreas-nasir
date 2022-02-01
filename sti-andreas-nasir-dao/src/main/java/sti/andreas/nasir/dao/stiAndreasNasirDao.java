package sti.andreas.nasir.dao;
import sti.andreas.nasir.domain.*;

import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

public interface stiAndreasNasirDao {

    Teacher addTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage);

    boolean deleteTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage);

    Student addStudent(String firstName, String lastName, int ssNumber, List<Course> courses);

    boolean deleteStudent(String firstName, String lastName, int ssNumber, List<Course> courses);


}
