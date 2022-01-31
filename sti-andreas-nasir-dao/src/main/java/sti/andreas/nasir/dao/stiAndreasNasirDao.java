package sti.andreas.nasir.dao;

import sti.andreas.nasir.domain.Person;
import sti.andreas.nasir.domain.Teacher;

public interface stiAndreasNasirDao {
    Teacher addTeacher(String firstName, String lastName, int ssNumber, Course course, int hourlyWage);

    boolean deleteTeacher(String firstName, String lastName, int ssNumber, Course course, int hourlyWage);


}
