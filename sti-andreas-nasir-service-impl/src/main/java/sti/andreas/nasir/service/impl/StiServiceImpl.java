package sti.andreas.nasir.service.impl;

import sti.andreas.nasir.dao.impl.stiAndreasNasirDaoImpl;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Vault;
import sti.andreas.nasir.service.StiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sti.andreas.nasir.dao.stiAndreasNasirDao;
public class StiServiceImpl implements StiService {
    Vault vault = new Vault();

    @Override
    public boolean addStudent(String firstName, String lastName, int ssNumber, List<String> courses) {
            Student studentToAdd = new Student(firstName, lastName, ssNumber, courses);
            vault.students.add(studentToAdd);
            return true;
    }

    @Override
    public void deleteStudent(int ssNumber) {

        for (int i = 0; i < vault.students.size() ; i++) {
            if(vault.students.get(i).getSsNumber() == ssNumber){
                vault.students.remove(i);
            }
        }
    }

    @Override
    public Student getStudent(int ssNumber) {
        for (Student s: vault.students) {
            if (s.getSsNumber() == ssNumber){
                return s;
            }
        }
        return null;
    }



    @Override
    public void deleteStudentCourse(Student student, String courseToRemove) {
        for (Student s : vault.getStudents()) {
            if (s.getSsNumber() == student.getSsNumber()){

            }
            else
                System.out.println("Student does not exist");
        }
    }

    @Override
    public void addStudentCourse(Student student, String courseToAdd) {
        for (Student s : vault.getStudents()) {
            if (s.getSsNumber() == student.getSsNumber()){
                s.addCourse(courseToAdd);
            }
            else
                System.out.println("Student does not exist");
        }
    }

    @Override
    public List<String> getStudentCourses(int ssNumber) {
        List<String> courses = new ArrayList<>();
        for (Student s : vault.getStudents()) {
            if(s.getSsNumber() == ssNumber){
                for (String course: s.getCourses()) {
                 courses.add(course);
                }
            }
            else System.out.println("invalid socialsecuritynumber");
        }
        return courses;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("****** WELCOME ******");

            System.out.println("1. Get student");

            System.out.println("2. Add student");

            System.out.println("3. Add course to student");

            System.out.println("4. Remove course from student");
            System.out.println("5. Cancel");
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
                        System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getCourses().toString());
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
                    vault.students.add(student2);
                    System.out.println("Student added");
                    break;

                case 3:
                    System.out.println("Enter social security number for the student");
                        int ssNumber3 = scanner.nextInt();
                            Student student3 = getStudent(ssNumber3);
                            System.out.println("Enter coursename to add");
                            String courseToAdd = scanner.next();
                            student3.addCourse(courseToAdd);
                            System.out.println(student3.getCourses().toString());
                            break;


                case 4:
                    System.out.println("Enter socialsecuritynumber for the student");
                    int ssNumber4 = scanner.nextInt();
                    Student student4 = getStudent(ssNumber4);
                    System.out.println("Enter coursename to remove");
                    String courseToRemove = scanner.next();
                    student4.removeCourse(courseToRemove);
                    System.out.println("courses left " +  student4.getCourses().toString());
                    break;

                case 5:
                    running=false;
                    break;
            }
        }

    }
}