package sti.andreas.nasir.dao;

import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

public interface stiAndreasNasirDao {

    Teacher addTeacher(String firstName, String lastName, int ssNumber, Course course, int hourlyWage);

    boolean deleteTeacher(String firstName, String lastName, int ssNumber, Course course, int hourlyWage);

    Student addStudent(String firstName, String lastName, int ssNumber, Course course);

    boolean deleteStudent(String firstName, String lastName, int ssNumber, Course course);


}
