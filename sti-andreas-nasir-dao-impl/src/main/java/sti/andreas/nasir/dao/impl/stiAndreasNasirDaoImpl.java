package sti.andreas.nasir.dao.impl;

import sti.andreas.nasir.dao.stiAndreasNasirDao;
import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Person;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class stiAndreasNasirDaoImpl  implements stiAndreasNasirDao{


    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql//localhost:3306/sti-mysql", "sti", "sti");
    }


    @Override
    public boolean addTeacher(String firstName, String lastName, int ssNumber, List<String> courses, int hourlyWage) {
        final String ADD_TEACHER_SQL = "INSERT INTO Teacher(personNumber, firstName, lastName, hourlyWage) VALUES(?, ?, ?, ?)";
        boolean addOk;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(ADD_TEACHER_SQL);

            preparedStatement.setInt(1, ssNumber);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, hourlyWage);

            preparedStatement.executeUpdate();
            addOk = true;

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
            addOk = false;
        }

        for (String course : courses) {
            final String ADD_TEACHER_COURSE_RELATION = "INSERT INTO Teacher_Course(personNumber, courseId)" +
                                                        " VALUES (" + ssNumber + ", '" + course + "')";
        }
        return addOk;

    }

    @Override
    public boolean deleteTeacher(int ssNumber) {
        boolean deleteTeacherOk, deleteRelationOk, deletionDone;
        final String DELETE_TEACHER_SQL = "DELETE FROM Teacher WHERE ID = " + ssNumber;
        final String DELETE_TEACHER_COURSE_RELATION_SQL = "DELETE FROM Teacher_Course WHERE personNumber = " + ssNumber;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_TEACHER_SQL);
            preparedStatement.executeUpdate();
            deleteTeacherOk = true;

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
            deleteTeacherOk = false;
        }
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_TEACHER_COURSE_RELATION_SQL);
            preparedStatement.executeUpdate();
            deleteRelationOk = true;

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
            deleteRelationOk = false;
        }
        if (deleteTeacherOk && deleteRelationOk){
            deletionDone = true;
        }
        else {
            deletionDone = false;
        }
        return deletionDone;
    }

    @Override
    public Teacher getTeacher(String courseId) {
        String firstName = null,lastName = null;
        int ssNumber = 0,wage = 0;
        List<String> courses  = null;



        final String GET_TEACHER_SQL = "SELECT * FROM Teacher " +
                                        "JOIN Teacher_Course " +
                                        "ON Teacher_Course.personNumber = Teacher.personNumber " +
                                        "WHERE Teacher_Course.courseId = " + courseId;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(GET_TEACHER_SQL);
            ResultSet rs = preparedStatement.executeQuery(GET_TEACHER_SQL);

            while(rs.next()){
                ssNumber = (rs.getInt(1));
                firstName = (rs.getString(2));
                lastName  = (rs.getString(3));
                wage = (rs.getInt(4));
            }

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }


        final String GET_TEACHER_COURSE_RELATION_SQL = "SELECT * FROM Teacher_Course" +
                " WHERE peronNumber = " + ssNumber;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(GET_TEACHER_COURSE_RELATION_SQL);
            ResultSet rs = preparedStatement.executeQuery(GET_TEACHER_COURSE_RELATION_SQL);

            while(rs.next()){
                courses.add(rs.getString(2));
            }

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }

        Teacher teacher = new Teacher(firstName,lastName,ssNumber,courses,wage);

        return teacher;
    }

    @Override
    public boolean addStudent(String firstName, String lastName, int ssNumber, List<String> courses) {
        final String ADD_STUDENT_SQL = "INSERT INTO Student(personNumber, firstName, lastName) VALUES(?, ?, ?)";
        boolean addOk;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(ADD_STUDENT_SQL);

            preparedStatement.setInt(1, ssNumber);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);

            preparedStatement.executeUpdate();
            addOk = true;

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
            addOk = false;
        }

        for (String course : courses) {
            final String ADD_STUDENT_COURSE_RELATION_SQL = "INSERT INTO Student_Course(personNumber, courseId)" +
                    " VALUES (" + ssNumber + ", '" + course + "')";
        }
        return addOk;

    }

    @Override
    public boolean deleteStudent(int ssNumber) {
        boolean deleteStudentOk, deleteRelationOk, deletionDone;
        final String DELETE_STUDENT_SQL = "DELETE FROM Student WHERE ID = " + ssNumber;
        final String DELETE_STUDENT_COURSE_RELATION_SQL = "DELETE FROM Student_Course WHERE personNumber = " + ssNumber;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL);
            preparedStatement.executeUpdate();
            deleteStudentOk = true;

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
            deleteStudentOk = false;
        }
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_STUDENT_COURSE_RELATION_SQL);
            preparedStatement.executeUpdate();
            deleteRelationOk = true;

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
            deleteRelationOk = false;
        }
        if (deleteStudentOk && deleteRelationOk){
            deletionDone = true;
        }
        else {
            deletionDone = false;
        }
        return deletionDone;


    }

    @Override
    public Student getStudent(int ssNumber) {
        String firstName = null,lastName = null;
        List<String> courses = null;

        final String GET_STUDENT_SQL = "SELECT * FROM Student WHERE personNumber = " + ssNumber;



        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(GET_STUDENT_SQL);
            ResultSet rs = preparedStatement.executeQuery(GET_STUDENT_SQL);

            while(rs.next()){
                firstName = (rs.getString(2));
                lastName  = (rs.getString(3));
            }

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }

        final String GET_STUDENT_COURSE_SQL = "SELECT * FROM Student_Course WHERE personNumber = " + ssNumber;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(GET_STUDENT_COURSE_SQL);
            ResultSet rs = preparedStatement.executeQuery(GET_STUDENT_COURSE_SQL);

            while(rs.next()){
                courses.add(rs.getString(2));

            }

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }
        Student student = new Student(firstName,lastName,ssNumber,courses);
        return student;
    }

    @Override
    public boolean deleteStudentCourse(int ssNumber, String course){
        final String DELETE_STUDENT_COURSE_SQL = "DELETE FROM Student_Course WHERE ssNumber LIKE '" +
                                                    ssNumber + "' AND courseId LIKE " + course;
        return true;
    }
    
    @Override
    public boolean addStudentCourse(Student student, String course){
        final String ADD_STUDENT_COURSE_RELATION_SQL = "INSERT INTO Student_Course(personNumber, courseId)" +
                " VALUES (" + student.getSsNumber() + ", '" + course + "')";
        return true;
    }

    @Override
    public boolean addCourse(int credits, int lengthOfCourse, Teacher teacher, String courseCode) {
        boolean addOk;
        final String ADD_COURSE_SQL = "INSERT INTO Course(courseCode, credits, hours) VALUES(?, ?, ?)";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(ADD_COURSE_SQL);

            preparedStatement.setString(1, courseCode);
            preparedStatement.setInt(2, credits);
            preparedStatement.setInt(3, lengthOfCourse);

            preparedStatement.executeUpdate();
            addOk = true;

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
            addOk = false;
        }

        return addOk;

    }

    public boolean deleteCourse(String courseCode){
        boolean deleteCourseOk, deleteRelationOk, deletionDone;
        final String DELETE_COURSE_SQL = "DELETE FROM Course WHERE courseId = " + courseCode;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_COURSE_SQL);

            preparedStatement.executeUpdate();
            deleteCourseOk = true;

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
            deleteCourseOk = false;
        }

        final String DELETE_STUDENT_COURSE_SQL = "DELETE FROM Student_Course WHERE courseId = " + courseCode;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_STUDENT_COURSE_SQL);

            preparedStatement.executeUpdate();
            deleteRelationOk = true;

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
            deleteRelationOk = false;
        }
        if (deleteCourseOk && deleteRelationOk){
            deletionDone = true;
        }
        else {
            deletionDone = false;
        }

        return deletionDone;
    }
}
