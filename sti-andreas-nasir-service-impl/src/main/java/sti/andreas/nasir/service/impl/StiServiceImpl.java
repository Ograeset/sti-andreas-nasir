package sti.andreas.nasir.service.impl;

import sti.andreas.nasir.dao.impl.stiAndreasNasirDaoImpl;
import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.service.StiService;

import java.util.List;
import sti.andreas.nasir.dao.stiAndreasNasirDao;
public class StiServiceImpl implements StiService {
    @Override
    public boolean addStudent(String firstName, String lastName, int ssNumber, List<String> courses) {
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
        stiAndreasNasirDao daoObj = new stiAndreasNasirDaoImpl();
        Student student = daoObj.getStudent(ssNumber);
        return student;
    }

    @Override
    public boolean deleteStudentCourse(Student student, String courseToRemove) {
        stiAndreasNasirDao daoObj = new stiAndreasNasirDaoImpl();

        if(daoObj.deleteStudentCourse(student.getSsNumber(), courseToRemove) == true){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean addStudentCourse(Student student, String courseToAdd) {
        stiAndreasNasirDao daoObj = new stiAndreasNasirDaoImpl();

        if(daoObj.addStudentCourse(student, courseToAdd) == true){
            return true;
        }
        else{
            return false;
        }
    }
}
