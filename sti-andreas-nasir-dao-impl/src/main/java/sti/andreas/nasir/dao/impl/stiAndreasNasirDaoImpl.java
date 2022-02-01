package sti.andreas.nasir.dao.impl;

import com.sun.org.slf4j.internal.LoggerFactory;
import sti.andreas.nasir.dao.stiAndreasNasirDao;
import sti.andreas.nasir.domain.Course;
import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.domain.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class stiAndreasNasirDaoImpl  implements stiAndreasNasirDao{


    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql//localhost:3306/SchoolsDB", "sti", "sti");
    }

    @Override
    public Teacher addTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage) {
        return null;
    }

    @Override
    public boolean deleteTeacher(int ssNumber) {
        return false;
    }

    @Override
    public boolean addStudent(String firstName, String lastName, int ssNumber, List<Course> courses) {
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

        return true;
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
}
