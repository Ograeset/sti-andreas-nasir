package sti.andreas.nasir.dao.impl;

import sti.andreas.nasir.dao.stiAndreasNasirDao;
import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

import java.util.List;

public class stiAndreasNasirDaoImpl  implements stiAndreasNasirDao{

    @Override
    public Teacher addTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage) {
        return null;
    }

    @Override
    public boolean deleteTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage) {
        return false;
    }

    @Override
    public Student addStudent(String firstName, String lastName, int ssNumber, List<Course> courses) {
        return null;
    }

    @Override
    public boolean deleteStudent(String firstName, String lastName, int ssNumber, List<Course> courses) {
        return false;
    }
}
