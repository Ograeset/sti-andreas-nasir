package sti.andreas.nasir.service.impl;

import sti.andreas.nasir.dao.impl.stiAndreasNasirDaoImpl;
import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.service.StiService;

import java.util.List;
import sti.andreas.nasir.dao.stiAndreasNasirDao;
public class StiServiceImpl implements StiService {
    @Override
    public boolean addStudent(String firstName, String lastName, int ssNumber, List<Course> courses) {
        return true;
    }

    @Override
    public boolean deleteStudent(int ssNumber) {
        return false;
    }

    @Override
    public String getStudent(int ssNumber) {
        return null;
    }

    @Override
    public boolean deleteStudentCourse(int ssNumber, String course) {
        return false;
    }

    @Override
    public boolean addStudentCourse(int ssNumber, String course) {
        return false;
    }
}
