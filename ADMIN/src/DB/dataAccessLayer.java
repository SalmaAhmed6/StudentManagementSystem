package DB;

import dto.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dataAccessLayer {
    static ResultSet rs;
     
    public static Connection connectDb(){
        
        try{
            
            Class.forName("oracle.jdbc.OracleDriver");
            
            Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Admin", "root");
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    public static void connect() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Admin", "root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM students", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = pst.executeQuery();
            con.close(); // Close the connection after use
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(dataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static boolean registrationSuccessful;

    public static boolean addStudent(students stu) {
        registrationSuccessful = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Admin", "root");

            // Check if the student with the given ID already exists
            try (PreparedStatement checkExistence = con.prepareStatement("SELECT STUDENTID FROM STUDENTS WHERE STUDENTID=?")) {
                checkExistence.setInt(1, stu.getStudentId());
                ResultSet rs = checkExistence.executeQuery();

                if (!rs.next()) {
                    // User does not exist, proceed with registration
                    try (PreparedStatement pst = con.prepareStatement("INSERT INTO STUDENTS VALUES(?,?,?,?,?,?,?,?,?,?,?,?)")) {
                        pst.setInt(1, stu.getStudentId());
                        pst.setString(2, stu.getFirstName());
                        pst.setString(3, stu.getLastName());
                        pst.setDate(4, new java.sql.Date(stu.getDateOfBirth().getTime())); // Assuming dateOfBirth is a java.util.Date
                        pst.setString(5, stu.getStreet());
                        pst.setString(6, stu.getCity());
                        pst.setString(7, stu.getGovernment());
                        pst.setString(8, stu.getEmail());
                        pst.setString(9, stu.getPhone());
                        pst.setInt(10, stu.getSemester());
                        pst.setInt(11, stu.getGradeLevel());
                        pst.setInt(12, stu.getDepartmentId());

                        int rowsAffected = pst.executeUpdate();

                        if (rowsAffected > 0) {
                            Logger.getLogger(dataAccessLayer.class.getName()).log(Level.INFO, "Student Added Successfully");
                            registrationSuccessful = true;
                        } else {
                            Logger.getLogger(dataAccessLayer.class.getName()).log(Level.WARNING, "Failed to add student");
                        }
                    }
                } else {
                    Logger.getLogger(dataAccessLayer.class.getName()).log(Level.WARNING, "Student with ID {0} already exists", stu.getStudentId());
                }
            }

            con.close(); // Close the connection after use
        } catch (SQLException ex) {
            Logger.getLogger(dataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registrationSuccessful;
    }
}
