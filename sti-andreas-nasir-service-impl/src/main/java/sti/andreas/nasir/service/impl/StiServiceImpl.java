package sti.andreas.nasir.service.impl;

import sti.andreas.nasir.dao.impl.stiAndreasNasirDaoImpl;
import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.service.StiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sti.andreas.nasir.dao.stiAndreasNasirDao;
public class StiServiceImpl implements StiService {
    @Override
    public boolean addStudent(String firstName, String lastName, int ssNumber, List<String> courses) {
        stiAndreasNasirDao daoObj = new stiAndreasNasirDaoImpl();


        if (daoObj.addStudent(firstName, lastName, ssNumber, courses) == true) {
            return true;
        } else

            return false;
    }

    @Override
    public boolean deleteStudent(int ssNumber) {
        stiAndreasNasirDao daoObj = new stiAndreasNasirDaoImpl();
        if (daoObj.deleteStudent(ssNumber) == true) {
            return true;
        } else
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

        if (daoObj.deleteStudentCourse(student.getSsNumber(), courseToRemove) == true) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean addStudentCourse(Student student, String courseToAdd) {
        stiAndreasNasirDao daoObj = new stiAndreasNasirDaoImpl();

        if (daoObj.addStudentCourse(student, courseToAdd) == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> getStudentCourses(int ssNumber) {
        return null;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("****** WELCOME ******");

            System.out.println("1. Get student");

            System.out.println("2. Add student");

            System.out.println("3. Add course to student");

            System.out.println("4. Remove course from student");
            /* TODO
            System.out.println("5. Calculate monthly salary for teacher");

            System.out.println("6. Calculate average salary for all teachers");

             */
            System.out.println("Enter a number");
             int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Please enter social security number");
                    int ssNumber = scanner.nextInt();
                    Student student = getStudent(ssNumber);
                    System.out.println(student.getFirstName());
                    List<String> courses = student.getCourses();
                    System.out.println(student.getFirstName() + " " + student.getLastName() + " " + courses.toString());
                    break;

                case 2:
                    System.out.println("Enter firstname");
                    String firstName = scanner.next();
                    System.out.println("Enter lastname");
                    String lastName = scanner.next();
                    System.out.println("Enter social security number");
                    int ssNumber2 = scanner.nextInt();
                    List<String> courses3 = new ArrayList<String>();
                    Student student2 = new Student(firstName, lastName, ssNumber2, courses3);
                    break;

                case 3:
                    System.out.println("Enter social security number for the student");
                    int ssNumber3 = scanner.nextInt();
                    Student student3 = getStudent(ssNumber3);
                    System.out.println("Enter coursename to add");
                    String courseToAdd = scanner.next();
                    addStudentCourse(student3, courseToAdd);
                    break;

                case 4:
                    System.out.println("Enter social security number for the student");
                    int ssNumber4 = scanner.nextInt();
                    Student student4 = getStudent(ssNumber4);
                    System.out.println("Enter coursename to remove");
                    String courseToRemove = scanner.next();
                    deleteStudentCourse(student4, courseToRemove);
            }
        }


    }
}