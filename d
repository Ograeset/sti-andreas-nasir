[1mdiff --git a/sti-andreas-nasir-dao-impl/src/main/java/sti/andreas/nasir/dao/impl/stiAndreasNasirDaoImpl.java b/sti-andreas-nasir-dao-impl/src/main/java/sti/andreas/nasir/dao/impl/stiAndreasNasirDaoImpl.java[m
[1mindex 80f319b..7778934 100644[m
[1m--- a/sti-andreas-nasir-dao-impl/src/main/java/sti/andreas/nasir/dao/impl/stiAndreasNasirDaoImpl.java[m
[1m+++ b/sti-andreas-nasir-dao-impl/src/main/java/sti/andreas/nasir/dao/impl/stiAndreasNasirDaoImpl.java[m
[36m@@ -5,27 +5,137 @@[m [mimport sti.andreas.nasir.domain.Course;[m
 import sti.andreas.nasir.domain.Student;[m
 import sti.andreas.nasir.domain.Teacher;[m
 [m
[32m+[m[32mimport java.sql.Connection;[m
[32m+[m[32mimport java.sql.DriverManager;[m
[32m+[m[32mimport java.sql.PreparedStatement;[m
[32m+[m[32mimport java.sql.SQLException;[m
 import java.util.List;[m
 [m
 public class stiAndreasNasirDaoImpl  implements stiAndreasNasirDao{[m
 [m
[32m+[m
[32m+[m[32m    private Connection connection = null;[m
[32m+[m[32m    private PreparedStatement preparedStatement = null;[m
[32m+[m
[32m+[m[32m    public Connection getConnection() throws SQLException {[m
[32m+[m[32m        return DriverManager.getConnection("jdbc:mysql//localhost:3306/SchoolsDB", "sti", "sti");[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m
     @Override[m
     public Teacher addTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage) {[m
[31m-        return null;[m
[32m+[m[32m        final String ADD_TEACHER_SQL = "INSERT INTO Teacher(personNumber, firstName, lastName, hourlyWage) VALUES(?, ?, ?, ?)";[m
[32m+[m
[32m+[m[32m        try {[m
[32m+[m[32m            connection = getConnection();[m
[32m+[m[32m            preparedStatement = connection.prepareStatement(ADD_TEACHER_SQL);[m
[32m+[m
[32m+[m[32m            preparedStatement.setInt(1, ssNumber);[m
[32m+[m[32m            preparedStatement.setString(2, firstName);[m
[32m+[m[32m            preparedStatement.setString(3, lastName);[m
[32m+[m[32m            preparedStatement.setInt(4, hourlyWage);[m
[32m+[m
[32m+[m[32m            int rows = preparedStatement.executeUpdate();[m
[32m+[m
[32m+[m[32m        } catch (SQLException sqlException) {[m
[32m+[m[32m            System.err.println("Sql error");[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        return new Teacher(firstName,lastName,ssNumber,courses,hourlyWage);[m
[32m+[m
     }[m
 [m
     @Override[m
[31m-    public boolean deleteTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage) {[m
[31m-        return false;[m
[32m+[m[32m    public boolean deleteTeacher(int ssNumber) {[m
[32m+[m[32m        final String DELETE_TEACHER_SQL = "DELETE FROM Teacher WHERE ID = " + ssNumber;[m
[32m+[m
[32m+[m[32m        try {[m
[32m+[m[32m            connection = getConnection();[m
[32m+[m[32m            preparedStatement = connection.prepareStatement(DELETE_TEACHER_SQL);[m
[32m+[m
[32m+[m[32m            int rows = preparedStatement.executeUpdate();[m
[32m+[m
[32m+[m[32m        } catch (SQLException sqlException) {[m
[32m+[m[32m            System.err.println("Sql error");[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        return true;[m
     }[m
 [m
     @Override[m
     public Student addStudent(String firstName, String lastName, int ssNumber, List<Course> courses) {[m
[31m-        return null;[m
[32m+[m[32m        final String ADD_STUDENT_SQL = "INSERT INTO Student(personNumber, firstName, lastName) VALUES(?, ?, ?)";[m
[32m+[m
[32m+[m[32m        try {[m
[32m+[m[32m            connection = getConnection();[m
[32m+[m[32m            preparedStatement = connection.prepareStatement(ADD_STUDENT_SQL);[m
[32m+[m
[32m+[m[32m            preparedStatement.setInt(1, ssNumber);[m
[32m+[m[32m            preparedStatement.setString(2, firstName);[m
[32m+[m[32m            preparedStatement.setString(3, lastName);[m
[32m+[m
[32m+[m[32m            int rows = preparedStatement.executeUpdate();[m
[32m+[m
[32m+[m[32m        } catch (SQLException sqlException) {[m
[32m+[m[32m            System.err.println("Sql error");[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        return new Student(firstName, lastName, ssNumber, courses);[m
[32m+[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @Override[m
[32m+[m[32m    public boolean deleteStudent(int ssNumber) {[m
[32m+[m[32m        final String DELETE_STUDENT_SQL = "DELETE FROM Student WHERE ID = " + ssNumber;[m
[32m+[m
[32m+[m[32m        try {[m
[32m+[m[32m            connection = getConnection();[m
[32m+[m[32m            preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL);[m
[32m+[m
[32m+[m[32m            int rows = preparedStatement.executeUpdate();[m
[32m+[m
[32m+[m[32m        } catch (SQLException sqlException) {[m
[32m+[m[32m            System.err.println("Sql error");[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        return true;[m
     }[m
 [m
     @Override[m
[31m-    public boolean deleteStudent(String firstName, String lastName, int ssNumber, List<Course> courses) {[m
[31m-        return false;[m
[32m+[m[32m    public Course addCourse(int credits, int lengthOfCourse, Teacher teacher, String courseCode) {[m
[32m+[m[32m        final String ADD_COURSE_SQL = "INSERT INTO Course(courseCode, credits, hours) VALUES(?, ?, ?)";[m
[32m+[m
[32m+[m[32m        try {[m
[32m+[m[32m            connection = getConnection();[m
[32m+[m[32m            preparedStatement = connection.prepareStatement(ADD_COURSE_SQL);[m
[32m+[m
[32m+[m[32m            preparedStatement.setString(1, courseCode);[m
[32m+[m[32m            preparedStatement.setInt(2, credits);[m
[32m+[m[32m            preparedStatement.setInt(3, lengthOfCourse);[m
[32m+[m
[32m+[m[32m            int rows = preparedStatement.executeUpdate();[m
[32m+[m
[32m+[m[32m        } catch (SQLException sqlException) {[m
[32m+[m[32m            System.err.println("Sql error");[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        return new Course(credits, lengthOfCourse, teacher, courseCode);[m
[32m+[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    public boolean deleteCourse(String courseCode){[m
[32m+[m[32m        final String DELETE_COURSE_SQL = "DELETE FROM Course WHERE courseId = " + courseCode;[m
[32m+[m
[32m+[m[32m        try {[m
[32m+[m[32m            connection = getConnection();[m
[32m+[m[32m            preparedStatement = connection.prepareStatement(DELETE_COURSE_SQL);[m
[32m+[m
[32m+[m[32m            int rows = preparedStatement.executeUpdate();[m
[32m+[m
[32m+[m[32m        } catch (SQLException sqlException) {[m
[32m+[m[32m            System.err.println("Sql error");[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        return true;[m
     }[m
 }[m
[1mdiff --git a/sti-andreas-nasir-dao/src/main/java/sti/andreas/nasir/dao/stiAndreasNasirDao.java b/sti-andreas-nasir-dao/src/main/java/sti/andreas/nasir/dao/stiAndreasNasirDao.java[m
[1mindex a964012..650289c 100644[m
[1m--- a/sti-andreas-nasir-dao/src/main/java/sti/andreas/nasir/dao/stiAndreasNasirDao.java[m
[1m+++ b/sti-andreas-nasir-dao/src/main/java/sti/andreas/nasir/dao/stiAndreasNasirDao.java[m
[36m@@ -10,11 +10,15 @@[m [mpublic interface stiAndreasNasirDao {[m
 [m
     Teacher addTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage);[m
 [m
[31m-    boolean deleteTeacher(String firstName, String lastName, int ssNumber, List<Course> courses, int hourlyWage);[m
[32m+[m[32m    boolean deleteTeacher(int ssNumber);[m
 [m
     Student addStudent(String firstName, String lastName, int ssNumber, List<Course> courses);[m
 [m
[31m-    boolean deleteStudent(String firstName, String lastName, int ssNumber, List<Course> courses);[m
[32m+[m[32m    boolean deleteStudent(int ssNumber);[m
[32m+[m
[32m+[m[32m    Course addCourse(int credits, int lengthOfCourse, Teacher teacher, String courseCode);[m
[32m+[m
[32m+[m[32m    boolean deleteCourse(String courseCode);[m
 [m
 [m
 }[m
[1mdiff --git a/sti-andreas-nasir-domain/src/main/java/sti/andreas/nasir/domain/Course.java b/sti-andreas-nasir-domain/src/main/java/sti/andreas/nasir/domain/Course.java[m
[1mindex 45a00a7..7147972 100644[m
[1m--- a/sti-andreas-nasir-domain/src/main/java/sti/andreas/nasir/domain/Course.java[m
[1m+++ b/sti-andreas-nasir-domain/src/main/java/sti/andreas/nasir/domain/Course.java[m
[36m@@ -4,13 +4,24 @@[m [mpublic class Course {[m
 private int credits;[m
 private Teacher teacher;[m
 private String courseCode;[m
[32m+[m[32mprivate int lengthOfCourse;[m
 [m
[31m-    public void setcredits(int credits) {}[m
[31m-    public int credits(){return credits; }[m
[32m+[m[32m    public Course(int credits, int lengthOfCourse, Teacher teacher, String courseCode){[m
[32m+[m[32m        setcredits(credits);[m
[32m+[m[32m        setTeacher(teacher);[m
[32m+[m[32m        setCourseCode(courseCode);[m
[32m+[m[32m        setLengthOfCourse(lengthOfCourse);[m
[32m+[m[32m    }[m
 [m
[31m-    public void setCourseCode(String courseCode){}[m
[32m+[m[32m    public void setcredits(int credits) {this.credits = credits;}[m
[32m+[m[32m    public int getCredits(){return credits; }[m
[32m+[m
[32m+[m[32m    public void setCourseCode(String courseCode){this.courseCode = courseCode;}[m
     public String getCourseCode(){return courseCode;}[m
 [m
[31m-    public void setTeacher(Teacher teacher){}[m
[32m+[m[32m    public void setTeacher(Teacher teacher){this.teacher = teacher;}[m
     public Teacher getTeacher(){return teacher;}[m
[32m+[m
[32m+[m[32m    public void setLengthOfCourse(int lengthOfCourse) {this.lengthOfCourse = lengthOfCourse;}[m
[32m+[m[32m    public int getLengthOfCourse(){return lengthOfCourse;}[m
 }[m
[1mdiff --git a/sti-andreas-nasir-service-impl/pom.xml b/sti-andreas-nasir-service-impl/pom.xml[m
[1mindex 2c8605e..f8270da 100644[m
[1m--- a/sti-andreas-nasir-service-impl/pom.xml[m
[1m+++ b/sti-andreas-nasir-service-impl/pom.xml[m
[36m@@ -17,18 +17,21 @@[m
         <dependency>[m
             <groupId>org.sti</groupId>[m
             <artifactId>sti-andreas-nasir-dao</artifactId>[m
[31m-[m
[32m+[m[32m            <version>1.0-SNAPSHOT</version>[m
         </dependency>[m
[32m+[m
         <dependency>[m
             <groupId>org.sti</groupId>[m
             <artifactId>sti-andreas-nasir-domain</artifactId>[m
[31m-[m
[32m+[m[32m            <version>1.0-SNAPSHOT</version>[m
         </dependency>[m
[32m+[m
         <dependency>[m
             <groupId>org.sti</groupId>[m
             <artifactId>sti-andreas-nasir-service</artifactId>[m
[31m-[m
[32m+[m[32m            <version>1.0-SNAPSHOT</version>[m
         </dependency>[m
[32m+[m
     </dependencies>[m
 [m
 </project>[m
\ No newline at end of file[m
