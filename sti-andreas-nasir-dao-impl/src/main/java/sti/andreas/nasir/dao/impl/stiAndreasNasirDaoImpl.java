package sti.andreas.nasir.dao.impl;

import sti.andreas.nasir.dao.stiAndreasNasirDao;
import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Person;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

import java.sql.*;
import java.util.List;

public class stiAndreasNasirDaoImpl  implements stiAndreasNasirDao{


    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql//localhost:3306/SchoolsDB", "sti", "sti");
    }


    @Override
    public Teacher addTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage) {
        final String ADD_TEACHER_SQL = "INSERT INTO Teacher(personNumber, firstName, lastName, hourlyWage) VALUES(?, ?, ?, ?)";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(ADD_TEACHER_SQL);

            preparedStatement.setInt(1, ssNumber);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, hourlyWage);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }

        return new Teacher(firstName,lastName,ssNumber,courses,hourlyWage);

    }

    @Override
    public boolean deleteTeacher(int ssNumber) {
        final String DELETE_TEACHER_SQL = "DELETE FROM Teacher WHERE ID = " + ssNumber;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_TEACHER_SQL);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }

        return true;
    }

    @Override
    public Student addStudent(String firstName, String lastName, int ssNumber, List<Course> courses) {
        final String ADD_STUDENT_SQL = "INSERT INTO Student(personNumber, firstName, lastName) VALUES(?, ?, ?)";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(ADD_STUDENT_SQL);

            preparedStatement.setInt(1, ssNumber);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }

        return new Student(firstName, lastName, ssNumber, courses);

    }

    @Override
    public boolean deleteStudent(int ssNumber) {
        final String DELETE_STUDENT_SQL = "DELETE FROM Student WHERE ID = " + ssNumber;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }

        return true;
    }

    @Override
    public Student getStudent(int ssNumber) {
        final String GET_STUDENT_SQL = "SELECT * FROM Student WHERE ID = " + ssNumber;
        String firstName,lastName;
        List<Course> courses;

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

        return true;
    }

    @Override
    public Course addCourse(int credits, int lengthOfCourse, Teacher teacher, String courseCode) {
        final String ADD_COURSE_SQL = "INSERT INTO Course(courseCode, credits, hours) VALUES(?, ?, ?)";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(ADD_COURSE_SQL);

            preparedStatement.setString(1, courseCode);
            preparedStatement.setInt(2, credits);
            preparedStatement.setInt(3, lengthOfCourse);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }

        return new Course(credits, lengthOfCourse, teacher, courseCode);

    }

    public boolean deleteCourse(String courseCode){
        final String DELETE_COURSE_SQL = "DELETE FROM Course WHERE courseId = " + courseCode;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_COURSE_SQL);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            System.err.println("Sql error");
        }

        return true;
    }
}
