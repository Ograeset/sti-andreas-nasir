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
        stiAndreasNasirDao daoObj = new stiAndreasNasirDaoImpl();

        if( daoObj.addStudent(firstName,lastName,ssNumber,courses) == true ){
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteStudent(int ssNumber) {
        stiAndreasNasirDao daoObj = new stiAndreasNasirDaoImpl();
        if(daoObj.deleteStudent(ssNumber) == true){
            return true;
        }
        else
        return false;
    }

    @Override
    public Student getStudent(int ssNumber) {

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
