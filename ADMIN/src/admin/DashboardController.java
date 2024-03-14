/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import DB.dataAccessLayer;
import static DB.dataAccessLayer.connectDb;
import dto.CourseAvgGPA;
import dto.DepartmentCourse;
import dto.StudentGrade;
import dto.Student_Course;
import dto.courses;
import dto.departments;
import dto.students;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author salma
 */
public class DashboardController implements Initializable {
    @FXML
    private AnchorPane ADDCOURSETODEPT;

    @FXML
    private Button ADD_DEPTCOURSE;
    @FXML
    private Button calcGPA;

    @FXML
    private Label showGpa;

    @FXML
    private Button delete_DEPTCOURSE;

    @FXML
    private Button update_DEPTCOURSE;

    @FXML
    private Button clear_DEPTCOURSE;

    @FXML
    private ComboBox<?> COURSEID1;
     @FXML
    private BarChart<String, Number> student_courseCount_Chart;

    @FXML
    private ComboBox<?> DEPTID;

    @FXML
    private TextField addStudents_Search1;

    @FXML
    private TableView<DepartmentCourse > DEPTCOURSET;

    @FXML
    private TableColumn<DepartmentCourse , String> availableDEPT_col_DEPTCOURSE;

    @FXML
    private TableColumn<DepartmentCourse , String> availableCourse_col_DEPTCOURSE;
    @FXML
    private Button DEPTCOURSE;
    @FXML
    private AnchorPane main_form;
    
    @FXML
    private Button deptBtn;

    @FXML
    private Button close;
    
    @FXML
    private TextField addStudents_Search;

    @FXML
    private Button home_btn;
    @FXML
    private ComboBox<?> STUDENTID;

    @FXML
    private Button logOut;

    @FXML
    private AnchorPane addStudents_form;

    @FXML
    private TextField addStudents_studentNum;

    @FXML
    private TextField addStudents_firstName;

    @FXML
    private TextField addStudents_lastName;

    @FXML
    private DatePicker addStudents_birth;

    @FXML
    private TextField addStudents_email;

    @FXML
    private TextField addStudents_phone;

    @FXML
    private TextField addStudents_Street;

    @FXML
    private TextField addStudents_city;

    @FXML
    private ComboBox<?> addStudents_gover;
    @FXML
    private TableView<students> addStudents_tableView;
    
    @FXML
    private TextField availableCourse_course;

    @FXML
    private TextField availableCourse_Name;

    @FXML
    private TextField availableCourse_Credits;
    @FXML
    Button STUDENT_GRADE;
    @FXML
    private TextField availableCourse_scale;


    @FXML
    private ComboBox<?> addStudents_deptId;

    @FXML
    private ComboBox<?> addStudents_Semester;

    @FXML
    private ComboBox<?> addStudents_GadeLevel;

    @FXML
    private AnchorPane home_form;
    @FXML
    private AnchorPane STUDENT_GRADEF;
    @FXML
    private Label countStudent;

    @FXML
    private Label countCourse;
    @FXML
    private Button addStudents_btn;

    @FXML
    private Button availableCourse_btn;
    @FXML
    private Label countDepartment;

    @FXML
    private AnchorPane availableCourse_form;  
    @FXML
    private Button ADD_btn;

    @FXML
    private Button delete_btn;

    @FXML
    private Button update_btn;

    @FXML
    private Button clear_btn;
    @FXML
    private TableColumn<courses, String> availableCourse_col_course;

    @FXML
    private TableColumn<courses, String> availableCourse_col_courseName;
    
    @FXML
    private TableView<courses> availableCourse_tableView;

    @FXML
    private TableColumn<courses, String> availableCourse_col_courseCredit;

    @FXML
    private TableColumn<courses, String> availableCourse_col_courseScale;
    
    @FXML
    private TableColumn<students, String> addStudents_col_studentNum;

    @FXML
    private TableColumn<students, String> addStudents_col_firstName;

    @FXML
    private TableColumn<students, String> addStudents_col_lastName;

    @FXML
    private TableColumn<students, String> addStudents_col_birth;

    @FXML
    private TableColumn<students, String> addStudents_col_street;

    @FXML
    private TableColumn<students, String> addStudents_col_city;

    @FXML
    private TableColumn<students, String> addStudents_col_gover;

    @FXML
    private TableColumn<students, String> addStudents_col_email;

    @FXML
    private TableColumn<students, String> addStudents_col_phone;

    @FXML
    private TableColumn<students, String> addStudents_col_semester;

    @FXML
    private TableColumn<students, String> addStudents_col_gradelevel;

    @FXML
    private TableColumn<students, String> addStudents_col_deptid;
    @FXML
    private AnchorPane DeptForm;

    @FXML
    private TextField deptId;

    @FXML
    private TextField deptName;

    @FXML
    private TextField HOF;

    @FXML
    private Button ADD_btnd;

    @FXML
    private Button delete_btnd;

    @FXML
    private Button update_btnd;
    @FXML
   private BarChart<String, Number> avgGPA;


    @FXML
    private Button clear_btnd;

    @FXML
    private TableView<departments> availableDept_tableView;

    @FXML
    private TableColumn<departments, String> availableCourse_col_did;

    @FXML
    private TableColumn<departments, String> availableCourse_col_dn;

    @FXML
    private TableColumn<departments, String> availableCourse_col_hod;
    @FXML
    private AnchorPane ENROLLCOURSE;

    @FXML
    private TextField stuID;

    @FXML
    private TextField CourseID;

    @FXML
    private Button ADD_btnd1;
    
    @FXML
    private Button Enroll_Course;

    @FXML
    private Button delete_btnd1;

    @FXML
    private Button update_btnd1;

    @FXML
    private Button clear_btnd1;

    @FXML
    private TextField GRADE;

    @FXML
    private DatePicker EnrolmentDate;

    @FXML
    private ComboBox<?> SEMESTER;

    @FXML
    private ComboBox<?> GRADELEVEL;
    @FXML
    private ComboBox<?> COURSEID;
    @FXML
    private ComboBox<?> STATUS;

    @FXML
    private TableView<Student_Course> STUCOURSE;

    @FXML
    private TableColumn<Student_Course, String> availableCourse_col_STUID;

    @FXML
    private TableColumn<Student_Course, String> availableCourse_col_COURSEID;

    @FXML
    private TableColumn<Student_Course, String> availableCourse_col_ENROLMENTDATE;

    @FXML
    private TableColumn<Student_Course, String> availableCourse_col_GRADELEVEL;

    @FXML
    private TableColumn<Student_Course, String> availableCourse_col_SEMESTER;

    @FXML
    private TableColumn<Student_Course, String> availableCourse_col_GRADE;

    @FXML
    private TableColumn<Student_Course, String> availableCourse_col_STATUS;
    @FXML
    private ComboBox<?> StudentIdGrade;

    @FXML
    private TableView<StudentGrade> STUDENT_GRADE_TABLE;

    @FXML
    private TableColumn<StudentGrade, Integer> courseColumn;

    @FXML
    private TableColumn<StudentGrade, Integer> gradeColumn;


    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result; 
    private double x= 0 ;
    private double y= 0;
public List<CourseAvgGPA> calculateAvgGPAForCourses() {
    List<CourseAvgGPA> avgGPAList = new ArrayList<>();

    // Retrieve data from your database and calculate average GPA for each course
    String query = "SELECT COURSENAME, AVG(GRADE) AS AVG_GPA " +
                   "FROM student_course " +
                   "JOIN courses ON student_course.COURSEID = courses.COURSEID " +
                   "GROUP BY student_course.COURSEID, COURSENAME";

    try (Connection connection = dataAccessLayer.connectDb();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
            String courseName = resultSet.getString("COURSENAME");
            double avgGPA = resultSet.getDouble("AVG_GPA");

            CourseAvgGPA courseAvgGPA = new CourseAvgGPA(courseName, avgGPA);
            avgGPAList.add(courseAvgGPA);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception or show an error message
    }

    return avgGPAList;
}
public void displayAvgGPAChart() {
    // Clear existing data
    avgGPA.getData().clear();

    // Calculate average GPA for each course
    List<CourseAvgGPA> avgGPAList = calculateAvgGPAForCourses();

    // Create a series to store data
    XYChart.Series<String, Number> series = new XYChart.Series<>();

    // Add data to the series
    for (CourseAvgGPA courseAvgGPA : avgGPAList) {
        series.getData().add(new XYChart.Data<>(courseAvgGPA.getCourseName(), courseAvgGPA.getAvgGPA()));
    }

    // Add the series to the bar chart
    avgGPA.getData().add(series);

    // Customize the chart as needed
    avgGPA.setTitle("Average GPA for Courses");
    avgGPA.getXAxis().setLabel("Courses");
    avgGPA.getYAxis().setLabel("Average GPA");
}
public void homeDisplayTotalEnrolledChart() {
    // Clear existing data
    student_courseCount_Chart.getData().clear();

    // SQL query to get course names and count of students enrolled
    String sql = "SELECT courses.COURSENAME, COUNT(student_course.STUDENTID) " +
                 "FROM student_course " +
                 "JOIN courses ON student_course.COURSEID = courses.COURSEID " +
                 "GROUP BY courses.COURSENAME";

    try {
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        // Execute the query and populate the chart series
        connect = dataAccessLayer.connectDb();
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String courseName = resultSet.getString(1);
            int enrollmentCount = resultSet.getInt(2);
            series.getData().add(new XYChart.Data<>(courseName, enrollmentCount));
        }

        // Add the series to the chart
        student_courseCount_Chart.getData().add(series);
        student_courseCount_Chart.setTitle("Students Count for each Course");
        student_courseCount_Chart.getXAxis().setLabel("Courses");
        student_courseCount_Chart.getYAxis().setLabel("Number of students");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

//student function    
 public ObservableList<Student_Course> addStudentCourseListData() {
    ObservableList<Student_Course> listStudentCourses = FXCollections.observableArrayList();

    String sql = "SELECT * FROM admin.student_course";

    connect = dataAccessLayer.connectDb();

    try {
        Student_Course studentCourse;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()) {
            studentCourse = new Student_Course(
                    result.getInt("studentID"),
                    result.getInt("courseID"),
                    result.getDate("enrolmentDate"),
                    result.getString("semester"),
                    result.getInt("grade"),
                    result.getInt("gradeLevel"),
                    result.getString("status")
            );

            listStudentCourses.add(studentCourse);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return listStudentCourses;
}
public void handleStudentIdSelection(ActionEvent event) {
    try {
        // Assuming getDepartmentIdByStudentId returns an integer
        Integer selectedStudentId = (Integer) STUDENTID.getValue();

        if (selectedStudentId != null) {
            int dept_id = getDepartmentIdByStudentId(selectedStudentId);
            System.out.print(dept_id);
            getCourseId(dept_id);
        } else {
            // Handle the case when no student is selected
            System.out.println("No student selected.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        // Handle other exceptions
    }
    // Handle SQLException, show error to the user, etc.
}
public ObservableList<students> addStudentsListData() {

        ObservableList<students> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT * FROM students";

        connect = dataAccessLayer.connectDb();

        try {
            students studentD;
            prepare = connect.prepareStatement(sql);        
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new students(result.getInt("studentId"),   
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getDate("dateOfBirth"),
                        result.getString("street"),
                        result.getString("city"),
                        result.getString("government"),
                        result.getString("email"),
                        result.getString("phone"),
                        result.getInt("semester"),
                        result.getInt("grade_Level"),
                        result.getInt("departmentId")
                        );

                listStudents.add(studentD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }
   
    private ObservableList<students> addStudentsListD;
public void addStudentsShowListData() {
        addStudentsListD = addStudentsListData();

        addStudents_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        addStudents_col_gover.setCellValueFactory(new PropertyValueFactory<>("government"));
        addStudents_col_street.setCellValueFactory(new PropertyValueFactory<>("street"));
        addStudents_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addStudents_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addStudents_col_semester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        addStudents_col_birth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        addStudents_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        addStudents_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addStudents_col_gradelevel.setCellValueFactory(new PropertyValueFactory<>("gradeLevel"));
        addStudents_col_deptid.setCellValueFactory(new PropertyValueFactory<>("departmentId"));
        addStudents_col_city.setCellValueFactory(new PropertyValueFactory<>("city"));


        addStudents_tableView.setItems(addStudentsListD);

    }
public void loadStudentGrades(ActionEvent event) {
    Integer selectedStudentId = (Integer)StudentIdGrade.getSelectionModel().getSelectedItem();

    if (selectedStudentId != null) {
        loadStudentGrades(selectedStudentId);
    } else {
        // Handle the case where no student is selected
        // You can show an alert or provide some feedback to the user
    }
}
 public ObservableList<StudentGrade> fetchStudentGrades(int studentId) {
    ObservableList<StudentGrade> studentGrades = FXCollections.observableArrayList();

    // Assuming you have a table named 'student_course' with columns 'course' and 'grade'
    String sql = "SELECT courseid, grade FROM student_course WHERE studentID = ?";

    connect = dataAccessLayer.connectDb();

    try {
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setInt(1, studentId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int course = resultSet.getInt("courseid");
            int grade = resultSet.getInt("grade");

            StudentGrade studentGrade = new StudentGrade(course, grade);
            studentGrades.add(studentGrade);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return studentGrades;
}

private ObservableList<StudentGrade> studentGradesList;

public void loadStudentGrades(int studentId) {
    studentGradesList = fetchStudentGrades(studentId);

    // Assuming you have columns named 'courseColumn' and 'gradeColumn' in your FXML file
    courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
    gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

    STUDENT_GRADE_TABLE.setItems(studentGradesList);
}
   
 
public void addStudentsSelect() {

        students studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
        int num = addStudents_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
 
        addStudents_studentNum.setText(String.valueOf(studentD.getStudentId()));
        addStudents_firstName.setText(studentD.getFirstName());
        addStudents_lastName.setText(studentD.getLastName());
        addStudents_birth.setValue(LocalDate.parse(String.valueOf(studentD.getDateOfBirth())));
        addStudents_email.setText(studentD.getEmail());
        addStudents_phone.setText(studentD.getPhone());
        addStudents_Street.setText(studentD.getStreet());
        addStudents_city.setText(studentD.getCity());
 
 }
public void addStudentsSearch() {

        FilteredList<students> filter = new FilteredList<>(addStudentsListD, e -> true);

        addStudents_Search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateStudentData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

               if (String.valueOf(predicateStudentData.getStudentId()).contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateStudentData.getSemester()).contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateStudentData.getGradeLevel()).contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getPhone().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getEmail().toLowerCase().contains(searchKey)) {
                    return true;    
                } else if (predicateStudentData.getDateOfBirth().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getStreet().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateStudentData.getCity().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getGovernment().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateStudentData.getDepartmentId()).contains(searchKey)) {
                    return true;    
                } else {
                    return false;
                }

            });
        });

        SortedList<students> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(addStudents_tableView.comparatorProperty());
        addStudents_tableView.setItems(sortList);

    }
///////////////////////////////////////////////////////////////////////////////////////////////

//student course part
private ObservableList<Student_Course> addStudentCourseListD;
public ObservableList<StudentGrade> getStudentGrades(int studentId) {
    ObservableList<StudentGrade> studentGrades = FXCollections.observableArrayList();

    // Assuming there is a SQL query to fetch courses and grades for the selected student ID
    String sql = "SELECT course, grade FROM student_courses WHERE studentId = ?";

    try {
        prepare = connect.prepareStatement(sql);
        prepare.setInt(1, studentId);
        result = prepare.executeQuery();

        while (result.next()) {
            StudentGrade studentGrade = new StudentGrade(
                    result.getInt("course"),
                    result.getInt("grade")
            );

            studentGrades.add(studentGrade);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return studentGrades;
}


public void addStudentCourseShowListData() {
    addStudentCourseListD = addStudentCourseListData();

    // Assuming these are the TableColumn names in your FXML file
    availableCourse_col_STUID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
    availableCourse_col_COURSEID.setCellValueFactory(new PropertyValueFactory<>("courseID"));
    availableCourse_col_ENROLMENTDATE.setCellValueFactory(new PropertyValueFactory<>("enrolmentDate"));
    availableCourse_col_SEMESTER.setCellValueFactory(new PropertyValueFactory<>("semester"));
    availableCourse_col_GRADE.setCellValueFactory(new PropertyValueFactory<>("grade"));
    availableCourse_col_GRADELEVEL.setCellValueFactory(new PropertyValueFactory<>("gradeLevel"));
    availableCourse_col_STATUS.setCellValueFactory(new PropertyValueFactory<>("status"));

    STUCOURSE.setItems(addStudentCourseListD);
}
public void addStudentCourseSelect() {
    Student_Course studentCourse = STUCOURSE.getSelectionModel().getSelectedItem();

    if (studentCourse == null) {
        // No selection, do nothing or show a message
        return;
    }

    // Assuming these are the TextField and other UI components in your FXML file
    STUDENTID.getSelectionModel().select(Integer.valueOf(studentCourse.getStudentID()));
    COURSEID.getSelectionModel().select(Integer.valueOf(studentCourse.getCourseID()));
    // Set other fields accordingly
    GRADE.setText(String.valueOf(studentCourse.getGrade()));
}
private int getStudentDepartmentId() throws SQLException {
    // Assuming you have a method to get the student ID, replace it with the actual method
    int studentId = getSelectedStudentId();

    String query = "SELECT departmentId FROM students WHERE studentid = ?";
    try (PreparedStatement stmt = connect.prepareStatement(query)) {
        stmt.setInt(1, studentId);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("departmentId");
            }
        }
    }
    throw new SQLException("Department ID not found for student ID: " + studentId);
}

// Replace this method with the actual method to get the selected student ID
private int getSelectedStudentId() {
    return (Integer) STUDENTID.getSelectionModel().getSelectedItem();
}

public void addStudentCourse() {
    String insertData = "INSERT INTO student_course (studentID, courseID, enrolmentDate, semester, grade, gradeLevel, status) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    connect = dataAccessLayer.connectDb();
    try {
        Alert alert;

        if (STUDENTID.getSelectionModel().getSelectedItem() == null
                || EnrolmentDate.getValue() == null
                || SEMESTER.getSelectionModel().getSelectedItem() == null
                || GRADE.getText().isEmpty()
                || GRADELEVEL.getSelectionModel().getSelectedItem() == null
                || STATUS.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // CHECK IF THE STUDENT COURSE RECORD IS ALREADY EXIST
            String checkData = "SELECT * FROM student_course WHERE studentID = ? AND courseID = ?";
            PreparedStatement checkStatement = connect.prepareStatement(checkData);
            checkStatement.setInt(1, (Integer) STUDENTID.getSelectionModel().getSelectedItem());
            checkStatement.setInt(2, (Integer) COURSEID.getSelectionModel().getSelectedItem());
            ResultSet checkResult = checkStatement.executeQuery();

            if (checkResult.next()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Student #" + (Integer) STUDENTID.getSelectionModel().getSelectedItem() + " is already enrolled in Course #" + (Integer) COURSEID.getSelectionModel().getSelectedItem() + "!");
                alert.showAndWait();
            } else {
                try {
                    // Additional checks for grade
                    int selectedGrade = Integer.parseInt(GRADE.getText());
                    int gradingScale = getGradingScaleForCourse((Integer) COURSEID.getSelectionModel().getSelectedItem());

                    if (selectedGrade < 0 || selectedGrade > gradingScale) {
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid grade. Grade should be between 0 and " + gradingScale);
                        alert.showAndWait();
                        return;  // Don't proceed if the grade is invalid
                    }

                    // Proceed with adding the student course record
                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    java.sql.Date sqlEnrolmentDate = java.sql.Date.valueOf(EnrolmentDate.getValue());

                    prepare.setInt(1, (Integer) STUDENTID.getSelectionModel().getSelectedItem());
                    prepare.setInt(2, (Integer) COURSEID.getSelectionModel().getSelectedItem());
                    prepare.setDate(3, sqlEnrolmentDate);
                    prepare.setInt(5, selectedGrade);
                    prepare.setInt(6, (Integer) GRADELEVEL.getSelectionModel().getSelectedItem());
                    prepare.setString(7, (String) STATUS.getSelectionModel().getSelectedItem());
                    prepare.setInt(4, (Integer) SEMESTER.getSelectionModel().getSelectedItem());
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    addStudentCourseShowListData();
                    clearStudentCourseFields();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Handle the exception or show an error message
                } catch (NumberFormatException e) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid grade. Please enter a valid number.");
                    alert.showAndWait();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
private int getGradingScaleForCourse(int courseId) throws SQLException {
    String query = "SELECT gradingScale FROM courses WHERE courseID = ?";
    try (PreparedStatement stmt = connect.prepareStatement(query)) {
        stmt.setInt(1, courseId);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("gradingScale");
            }
        }
    }
    throw new SQLException("Grading scale not found for course ID: " + courseId);
}


private void populateCourseComboBox(int departmentId) {
        COURSEID.getItems().clear(); // Clear existing items

        // Query to fetch courses based on the department ID
        String query = "SELECT courseID FROM department_course WHERE departmentID = ?";
        ObservableList listC = FXCollections.observableArrayList();
        try (PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setInt(1, departmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Add each course ID to the ComboBox
                    listC.add(rs.getInt("courseID"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an error message
        }
        COURSEID.setItems(listC);
    }

//generel func
private int getCoursetId(String coursename) throws SQLException {
    String query = "SELECT courseid FROM courses WHERE coursename = ?";
    try (PreparedStatement stmt = connect.prepareStatement(query)) {
        stmt.setString(1, coursename);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("courseid");
            }
        }
    }
    throw new SQLException("Department ID not found for department name: " + coursename);
}  
private int getDepartmentId(String departmentName) throws SQLException {
    String query = "SELECT departmentId FROM departments WHERE departmentname = ?";
    try (PreparedStatement stmt = connect.prepareStatement(query)) {
        stmt.setString(1, departmentName);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("departmentId");
            }
        }
    }
    throw new SQLException("Department ID not found for department name: " + departmentName);
}
   private String[] governmentList = {
    "Cairo", "Alexandria", "Giza", "Luxor", "Aswan", "Suez", "Ismailia",
    "Port Said", "Sharm El Sheikh", "Hurghada", "Minya", "Fayoum", "Qena",
    "Mansoura", "Zagazig", "Damietta", "Kafr El Sheikh", "Asyut", "Sohag",
    "Beni Suef", "Damanhur", "Banha", "Assiut", "Tanta", "El-Mahalla El-Kubra",
    "Qalyobia","Marsa Matruh", "El Arish"
};
public void addGovernmentList() {
        List<String> governmentL = new ArrayList<>();

        for (String data : governmentList) {
            governmentL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(governmentL);
        // Assuming addGovernment is the name of your ComboBox or ListView for governments
        addStudents_gover.setItems(ObList);
    }
    private String[] statusOptions = {
        "Enrolled",
        "Dropped",
        "Completed",
        // Add other status options as needed
};
    ObservableList<String> statusList = FXCollections.observableArrayList(statusOptions);
public void addstatus() {
        List<String> sL = new ArrayList<>();

        for (String data : statusList) {
            sL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(sL);
        // Assuming addGovernment is the name of your ComboBox or ListView for governments
                STATUS.setItems(ObList);
    }

private Integer[] semester = {1,2,3};
public void addsemester(){
     List<Integer> semesterl = new ArrayList<>();
      for (Integer data : semester) {
            semesterl.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(semesterl);
        // Assuming addGovernment is the name of your ComboBox or ListView for governments
        addStudents_Semester.setItems(ObList);
        SEMESTER.setItems(ObList);
    }
private Integer[] gradelevel = {1,2,3,4};
public void addgadelevel(){                     
     List<Integer> gradel = new ArrayList<>();
      for (Integer data : gradelevel) {
            gradel.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(gradel);
        // Assuming addGovernment is the name of your ComboBox or ListView for governments
        addStudents_GadeLevel.setItems(ObList);
        GRADELEVEL.setItems(ObList);
    }
public void addDeptList() {

        String listCourse = "SELECT * FROM departments";

        connect = dataAccessLayer.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("departmentname"));
            }
            addStudents_deptId.setItems(listC);
            DEPTID.setItems(listC);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
private int getDepartmentIdByStudentId(int studentId) throws SQLException {
    String query = "SELECT departmentId FROM students WHERE studentid = ?";
    try (PreparedStatement stmt = connect.prepareStatement(query)) {
        stmt.setInt(1, studentId);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                populateCourseComboBox(rs.getInt("departmentId"));
                return rs.getInt("departmentId");
            }
        }
    }
    throw new SQLException("Department ID not found for student ID: " + studentId);
}

public void getStudenteId() {

        String listCourse = "SELECT * FROM students";

        connect = dataAccessLayer.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getInt("studentid"));
            }
            STUDENTID.setItems(listC);
            StudentIdGrade.setItems(listC);

   
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

public void getCourseId(int deptid) {
         
       String listCourse = "SELECT * FROM courses ";

        connect = dataAccessLayer.connectDb();

        try {
            ObservableList listC = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getInt("COURSEID"));
            }
            COURSEID1.setItems(listC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void getCourseId() {
           String listCourse = "SELECT * FROM courses";

        connect = dataAccessLayer.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("coursename"));
            }
            COURSEID1.setItems(listC);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
////////////////////////////////////////////////////////////////////////
//dept_course part
public void updateDepartmentCourse() throws SQLException {
    try {
        DepartmentCourse selectedDepartmentCourse = DEPTCOURSET.getSelectionModel().getSelectedItem();

        if (selectedDepartmentCourse != null) {
            int departmentId = getDepartmentId((String) DEPTID.getSelectionModel().getSelectedItem());
            int courseId =getCoursetId((String) COURSEID1.getSelectionModel().getSelectedItem());

            // Check if the new combination already exists
            if (isDuplicateDepartmentCourse(departmentId, courseId)) {
                Alert duplicateAlert = new Alert(AlertType.ERROR);
                duplicateAlert.setTitle("Error Message");
                duplicateAlert.setHeaderText(null);
                duplicateAlert.setContentText("This department-course combination already exists. Please choose a different combination.");
                duplicateAlert.showAndWait();
                return; // Exit the method to prevent further execution
            }

            // Update query to update the department course information
            String updateQuery = "UPDATE department_course SET " +
                    "departmentID = " + departmentId + ", " +
                    "courseID = " + courseId + " " +
                    "WHERE departmentID = " + selectedDepartmentCourse.getDepartmentId() +
                    " AND courseID = " + selectedDepartmentCourse.getCourseId();

            // Execute the update query
            try (Connection connection = dataAccessLayer.connectDb();
                 Statement statement = connection.createStatement()) {

                statement.executeUpdate(updateQuery);

                // Display success message or handle success as needed
                Alert successAlert = new Alert(AlertType.INFORMATION);
                successAlert.setTitle("Information Message");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Successfully Updated!");
                successAlert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                addDepartmentCourseShowListData();
                // TO CLEAR THE FIELDS
                clearDepartmentCourseFields();

            } catch (SQLException e) {
                // Handle SQL exception
                e.printStackTrace();

                // Display error message or handle error as needed
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("Error Message");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Error updating department course information. See console for details.");
                errorAlert.showAndWait();
            }
        } else {
            // Handle the case when no department course is selected for update
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please select a department course for update.");
            errorAlert.showAndWait();
        }
    } catch (NullPointerException e) {
        // Handle if any ComboBox selection is not made
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error Message");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("Please select values for all fields.");
        errorAlert.showAndWait();
    }
}

// Method to check if the new department-course combination already exists
private boolean isDuplicateDepartmentCourse(int departmentId, int courseId) {
    String checkDuplicateQuery = "SELECT * FROM department_course WHERE departmentID = ? AND courseID = ?";
    try (Connection connection = dataAccessLayer.connectDb();
         PreparedStatement preparedStatement = connection.prepareStatement(checkDuplicateQuery)) {

        preparedStatement.setInt(1, departmentId);
        preparedStatement.setInt(2, courseId);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next(); // Returns true if the combination already exists

    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Assume no duplicate in case of an error
    }
}

public void insertDepartmentCourse() throws SQLException {
    try {
        // Assuming these are the ComboBox components in your FXML file
        int departmentId = getDepartmentId((String) DEPTID.getSelectionModel().getSelectedItem());
        int courseId = getCoursetId((String) COURSEID1.getSelectionModel().getSelectedItem());

        // Check if the new combination already exists
        if (isDuplicateDepartmentCourse(departmentId, courseId)) {
            Alert duplicateAlert = new Alert(AlertType.ERROR);
            duplicateAlert.setTitle("Error Message");
            duplicateAlert.setHeaderText(null);
            duplicateAlert.setContentText("This department-course combination already exists. Please choose a different combination.");
            duplicateAlert.showAndWait();
            return; // Exit the method to prevent further execution
        }

        // Insert query to insert data into the department_course table
        String insertQuery = "INSERT INTO department_course (departmentId, courseId) VALUES (?, ?)";

        // Execute the insert query
        try (Connection connection = dataAccessLayer.connectDb();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, departmentId);
            preparedStatement.setInt(2, courseId);

            preparedStatement.executeUpdate();

            // Display success message or handle success as needed
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Information Message");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Successfully Inserted into department_course!");
            successAlert.showAndWait();

            // TO UPDATE THE TABLEVIEW
            // Add the logic to update your table view if needed

            // TO CLEAR THE FIELDS
            addDepartmentCourseShowListData();
            clearDepartmentCourseFields();
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();

            // Display error message or handle error as needed
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error inserting data into department_course. See console for details.");
            errorAlert.showAndWait();
        }
    } catch (NullPointerException e) {
        // Handle if any ComboBox selection is not made
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error Message");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("Please select values for all fields.");
        errorAlert.showAndWait();
    }
}

public void addDepartmentCourseShowListData() {
    addDepartmentCourseListD = addDepartmentCourseListData();

    // Assuming you have appropriate TableColumn instances for DEPARTMENTID and COURSEID
    // Adjust the types accordingly
    availableDEPT_col_DEPTCOURSE.setCellValueFactory(new PropertyValueFactory<>("departmentId"));
    availableCourse_col_DEPTCOURSE.setCellValueFactory(new PropertyValueFactory<>("courseId"));

    DEPTCOURSET.setItems(addDepartmentCourseListD);
}
public void addDepartmentCourseSearch() {
    FilteredList<DepartmentCourse> filter = new FilteredList<>(addDepartmentCourseListD, e -> true);

    addStudents_Search1.textProperty().addListener((Observable, oldValue, newValue) -> {
        filter.setPredicate(predicateDepartmentCourseData -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            return String.valueOf(predicateDepartmentCourseData.getDepartmentId()).contains(searchKey) ||
                    String.valueOf(predicateDepartmentCourseData.getCourseId()).contains(searchKey);
        });
    });

    SortedList<DepartmentCourse> sortList = new SortedList<>(filter);

    // Assuming you have appropriate TableColumn instances for DEPARTMENTID and COURSEID
    // Adjust the types accordingly
    sortList.comparatorProperty().bind(DEPTCOURSET.comparatorProperty());
    DEPTCOURSET.setItems(sortList);
}
public void deleteDepartmentCourse() throws SQLException {
    DepartmentCourse departmentCourse = DEPTCOURSET.getSelectionModel().getSelectedItem();
    int departmentId = getDepartmentId((String) DEPTID.getSelectionModel().getSelectedItem());
    int courseId = getCoursetId((String) COURSEID1.getSelectionModel().getSelectedItem());

    if (COURSEID1 != null && DEPTID != null) {
        // Create a confirmation dialog
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText("Are you sure you want to delete this department course?");

        Optional<ButtonType> result = confirmationAlert.showAndWait();

        // Check if the user clicked OK (result is present and OK)
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User clicked OK, proceed with the deletion
            // Delete query to delete the department course
            String deleteQuery = "DELETE FROM department_course WHERE DEPARTMENTID = " + departmentId +
                    " AND COURSEID = " + courseId;

            try (Connection connection = dataAccessLayer.connectDb();
                 Statement statement = connection.createStatement()) {

                statement.executeUpdate(deleteQuery);

                // Display success message or handle success as needed
                Alert successAlert = new Alert(AlertType.INFORMATION);
                successAlert.setTitle("Information Message");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Successfully Deleted!");
                successAlert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                addDepartmentCourseShowListData();

            } catch (SQLException e) {
                // Handle SQL exception
                e.printStackTrace();

                // Display error message or handle error as needed
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("Error Message");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Error deleting department course. See console for details.");
                errorAlert.showAndWait();
            }
        }
        // If the user clicked Cancel, do nothing
    } else {
        // Handle the case when no department course is selected
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error Message");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("Please select a department course before deleting.");
        errorAlert.showAndWait();
    }
}
public void addDeptClear() {
    deptId.setText("");
    deptName.setText("");
    HOF.setText("");
}
private ObservableList<DepartmentCourse> addDepartmentCourseListD;
private boolean isValidEmail(String email) {
    // Regular expression for a basic email validation
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    return email.matches(emailRegex);
}

private boolean isValidPhoneNumber(String phoneNumber) {
    // Regular expression for a basic phone number validation
    // This regex allows digits, optional spaces, dashes, and parentheses
    String phoneRegex = "^[0-9\\s\\-\\(\\)]+$";
    return phoneNumber.matches(phoneRegex);
}


public void addStudentsAdd() {
    String insertData = "INSERT INTO students "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    connect = dataAccessLayer.connectDb();
    try {
        Alert alert;

        if (addStudents_studentNum.getText().isEmpty()
                || addStudents_Street.getText().isEmpty()
                || addStudents_deptId.getSelectionModel().getSelectedItem() == null
                || addStudents_firstName.getText().isEmpty()
                || addStudents_lastName.getText().isEmpty()
                || addStudents_gover.getSelectionModel().getSelectedItem() == null
                || addStudents_birth.getValue() == null
                || addStudents_Semester.getSelectionModel().getSelectedItem() == null
                || addStudents_city.getText().isEmpty()
                || addStudents_GadeLevel.getSelectionModel().getSelectedItem() == null
                || addStudents_email.getText().isEmpty()
                || addStudents_phone.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // CHECK IF THE STUDENTNUMBER IS ALREADY EXIST
            String checkData = "SELECT STUDENTID FROM students WHERE STUDENTID = '"
                    + addStudents_studentNum.getText() + "'";

            Statement statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            if (result.next()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Student #" + addStudents_studentNum.getText() + " already exists!");
                alert.showAndWait();
            } else {
                if (isValidEmail(addStudents_email.getText()) && isValidPhoneNumber(addStudents_phone.getText())) {
                    // Email and phone number are valid, proceed with insertion
                    prepare = connect.prepareStatement(insertData);
                    String departmentName = (String) addStudents_deptId.getSelectionModel().getSelectedItem();
                    int departmentId = getDepartmentId(departmentName);
                    java.sql.Date sqlDate = java.sql.Date.valueOf(addStudents_birth.getValue());
                    prepare.setString(1, addStudents_studentNum.getText());
                    prepare.setString(2, addStudents_firstName.getText());
                    prepare.setString(3, addStudents_lastName.getText());
                    prepare.setDate(4, sqlDate);
                    prepare.setString(5, addStudents_Street.getText());
                    prepare.setString(6, addStudents_city.getText());
                    prepare.setString(8, addStudents_email.getText());
                    prepare.setString(9, addStudents_phone.getText());
                    prepare.setString(7, (String) addStudents_gover.getSelectionModel().getSelectedItem());
                    prepare.setInt(10, (Integer) addStudents_Semester.getSelectionModel().getSelectedItem());
                    prepare.setInt(11, (Integer) addStudents_GadeLevel.getSelectionModel().getSelectedItem());
                    prepare.setInt(12, departmentId);

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();
                } else {
                    // Invalid email or phone number
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid email or phone number format");
                    alert.showAndWait();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void addStudentsDelete() {
    String studentId = addStudents_studentNum.getText();

    if (studentId.isEmpty()) {
        // If student ID is not provided
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please Enter the Student Id ");
        alert.showAndWait();
        return;
    }

    // Confirm deletion with the user
    Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Confirmation Message");
    confirmationAlert.setHeaderText(null);
    confirmationAlert.setContentText("Are you sure you want to DELETE Student #" + studentId + "?");

    Optional<ButtonType> option = confirmationAlert.showAndWait();

    if (option.isPresent() && option.get() == ButtonType.OK) {
        // Proceed with deletion
        try (Connection connection = dataAccessLayer.connectDb()) {
            // Delete from students table
           

            // Check if the student ID exists in student_History
            String checkData = "SELECT studentId FROM student_History WHERE studentid = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkData)) {
                checkStatement.setString(1, studentId);
                ResultSet result = checkStatement.executeQuery();

                if (result.next()) {
                    // If the student ID exists in student_History, delete from student_History
                    String deleteGrade = "DELETE FROM student_History WHERE studentid = ?";
                    try (PreparedStatement deleteGradeStatement = connection.prepareStatement(deleteGrade)) {
                        deleteGradeStatement.setString(1, studentId);
                        deleteGradeStatement.executeUpdate();
                    }
                }
            }

            // Delete from student_course
            String deleteCourse = "DELETE FROM student_course WHERE studentid = ?";
            try (PreparedStatement deleteCourseStatement = connection.prepareStatement(deleteCourse)) {
                deleteCourseStatement.setString(1, studentId);
                deleteCourseStatement.executeUpdate();
            }
             String deleteStudent = "DELETE FROM students WHERE studentid = ?";
            try (PreparedStatement deleteStudentStatement = connection.prepareStatement(deleteStudent)) {
                deleteStudentStatement.setString(1, studentId);
                deleteStudentStatement.executeUpdate();
            }

            // Display success message
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Information Message");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Successfully Deleted!");
            successAlert.showAndWait();

            // Update the table view
            addStudentsShowListData();
            // Clear the fields
            addStudentCourseShowListData();
            addStudentsClear();
            getStudenteId();
            getCourseId();

        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();

            // Display error message to the user
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("An error occurred during deletion. Please try again.");
            errorAlert.showAndWait();
        }
    }
}


public void addStudentsUpdate() {
    try {
        int studentId = Integer.parseInt(addStudents_studentNum.getText());
        String newFirstName = addStudents_firstName.getText();
        String newLastName = addStudents_lastName.getText();
        LocalDate newDateOfBirth = addStudents_birth.getValue(); // Assuming addStudents_birth is a DatePicker
        String newEmail = addStudents_email.getText();
        String newPhone = addStudents_phone.getText();
        String newStreet = addStudents_Street.getText();
        String newCity = addStudents_city.getText();
        String newGovernment =  (String) addStudents_gover.getSelectionModel().getSelectedItem(); // Assuming addStudents_gover is a ComboBox<String>
        int newSemester =(Integer) addStudents_Semester.getSelectionModel().getSelectedItem(); // Assuming addStudents_Semester is a ComboBox<Integer>
        int newGradeLevel = (Integer) addStudents_GadeLevel.getSelectionModel().getSelectedItem(); // Assuming addStudents_GadeLevel is a ComboBox<Integer>
        String newDeptId = (String) addStudents_deptId.getSelectionModel().getSelectedItem(); // Assuming addStudents_deptId is a ComboBox<String>
        // Get other values as needed

        // Call the stored procedure to update the student information
        try (Connection connection = dataAccessLayer.connectDb();
             CallableStatement callableStatement = connection.prepareCall("{CALL ADMIN.UpdateStudentInfo(?,?,?,?,?,?,?,?,?,?,?,?)}")) {

            callableStatement.setInt(1, studentId);
            callableStatement.setString(2, newFirstName);
            callableStatement.setString(3, newLastName);
            callableStatement.setDate(4, java.sql.Date.valueOf(newDateOfBirth));
            callableStatement.setString(5, newStreet);
            callableStatement.setString(6, newCity);
            callableStatement.setString(7, newGovernment);
            callableStatement.setString(8, newEmail);
            callableStatement.setString(9, newPhone);
            callableStatement.setInt(10, newSemester);
            callableStatement.setInt(11, newGradeLevel);
            callableStatement.setInt(12, getDepartmentId(newDeptId)); // Assuming getDepartmentId is a method to retrieve department ID
            // Set other parameters as needed

            callableStatement.execute();

            // Display success message or handle success as needed
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Information Message");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Successfully Updated!");
            successAlert.showAndWait();

            // TO UPDATE THE TABLEVIEW
            addStudentsShowListData();
            // TO CLEAR THE FIELDS
            addStudentsClear();

        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();

            // Display error message or handle error as needed
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error updating student information. See console for details.");
            errorAlert.showAndWait();
        }
    } catch (NumberFormatException e) {
        // Handle if studentId is not a valid number
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error Message");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("Please enter a valid Student ID.");
        errorAlert.showAndWait();
    }
}
public void calcGpa() {
    try {
        int studentId = (Integer) StudentIdGrade.getSelectionModel().getSelectedItem(); 
      
        // Call the stored function to calculate GPA
        try (Connection connection = dataAccessLayer.connectDb();
             CallableStatement callableStatement = connection.prepareCall("{? = CALL ADMIN.CalculateGPAA(?)}")) {

            callableStatement.registerOutParameter(1, Types.DOUBLE);  // Assuming the GPA is of type DOUBLE
            callableStatement.setInt(2, studentId);
          
            callableStatement.execute();

            // Get the calculated GPA from the CallableStatement
            double gpa = callableStatement.getDouble(1);

            // Display the GPA in the showGpa label
            showGpa.setText("GPA: " + gpa);

            // Optionally, you can inform the user about the successful calculation
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("GPA calculation successful.");
            successAlert.showAndWait();

        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();

            // Display error message to the user
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("An error occurred during GPA calculation. Please try again.");
            errorAlert.showAndWait();
        }
    } catch (NumberFormatException e) {
        // Handle if studentId is not a valid number
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("Please enter a valid Student ID.");
        errorAlert.showAndWait();
    }}

public void addStudentsClear() {
        addStudents_studentNum.setText("");
        addStudents_firstName.setText("");
        addStudents_lastName.setText("");
        addStudents_birth.setValue(null);
        addStudents_phone.setText("");
        addStudents_email.setText("");
        addStudents_city.setText("");
        addStudents_Street.setText("");
       addStudents_deptId.setValue(null);
       addStudents_Semester.setValue(null);
       addStudents_gover.setValue(null);
       addStudents_GadeLevel.setValue(null);

    }
public void setLabels() {
        setCount("students", countStudent);
        setCount("courses", countCourse);
        setCount("departments", countDepartment);
    }

private void setCount(String tableName, Label countLabel) {
        String sql = "SELECT count(*) FROM " + tableName;
        connect = dataAccessLayer.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                int count = result.getInt(1);
                countLabel.setText(Integer.toString(count));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public ObservableList<courses> availableCourseListData() {

        ObservableList<courses> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM courses";

        connect = dataAccessLayer.connectDb();

        try {
            courses courseD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                courseD = new courses(result.getInt("courseId"),
                        result.getString("coursename"),
                        result.getInt("credits"),
                        result.getInt("gradingscale")
                );

                listData.add(courseD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
     
public ObservableList<departments> availableDeptListData() {

        ObservableList<departments> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM departments";

        connect = dataAccessLayer.connectDb();

        try {
            departments departmentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                departmentD = new departments(result.getInt("DepartmentId"),
                        result.getString("DepartmentName"),
                        result.getString("HeadOfDepartment")
                );

                listData.add(departmentD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
private ObservableList<departments> availableDeptList;

public void availableDeptShowListData() {
        availableDeptList = availableDeptListData();

        availableCourse_col_did.setCellValueFactory(new PropertyValueFactory<>("DepartmentId"));
        availableCourse_col_dn.setCellValueFactory(new PropertyValueFactory<>("DepartmentName"));
        availableCourse_col_hod.setCellValueFactory(new PropertyValueFactory<>("HeadOfDepartment"));
        availableDept_tableView.setItems(availableDeptList);

    }

    private ObservableList<courses> availableCourseList;

public void availableCourseShowListData() {
        availableCourseList = availableCourseListData();

        availableCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
        availableCourse_col_courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        availableCourse_col_courseCredit.setCellValueFactory(new PropertyValueFactory<>("Credits"));
        availableCourse_col_courseScale.setCellValueFactory(new PropertyValueFactory<>("GradingScale"));
        availableCourse_tableView.setItems(availableCourseList);

    }
public void availableDeptSelect() {
        departments departmentD = availableDept_tableView.getSelectionModel().getSelectedItem();
        int num = availableDept_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        availableCourse_col_did.setText(Integer.toString(departmentD.getDepartmentId()));
        availableCourse_col_dn.setText(departmentD.getDepartmentName());
        availableCourse_col_hod.setText(departmentD.getHeadOfDepartment());
    }

    public void availableCourseSelect() {
        courses courseD = availableCourse_tableView.getSelectionModel().getSelectedItem();
        int num = availableCourse_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        availableCourse_col_course.setText(Integer.toString(courseD.getCourseId()));
        availableCourse_col_courseName.setText(courseD.getCourseName());
        availableCourse_col_courseCredit.setText(Integer.toString(courseD.getCredits()));
        availableCourse_col_courseScale.setText(Integer.toString(courseD.getGradingScale()));
    }

    
         public void defaultNav(){
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,  #995bd5, #bf99f2);");
    }
public void addStudentsCourseList() {

        String listCourse = "SELECT * FROM departments";

        connect = dataAccessLayer.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("departmentname"));
            }
            addStudents_deptId.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
public void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            setLabels();
            home_form.setVisible(true);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            DeptForm.setVisible(false);
            ENROLLCOURSE.setVisible(false);
            ADDCOURSETODEPT.setVisible(false);
            STUDENT_GRADEF.setVisible(false);
            showGpa.setText("");
            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #995bd5, #bf99f2);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            availableCourse_btn.setStyle("-fx-background-color:transparent");
            deptBtn.setStyle("-fx-background-color:transparent");
            STUDENT_GRADE.setStyle("-fx-background-color:transparent");
            Enroll_Course.setStyle("-fx-background-color:transparent");
            DEPTCOURSE.setStyle("-fx-background-color:transparent");
             homeDisplayTotalEnrolledChart();
             displayAvgGPAChart();
             clearStudentGrades();
             addDeptClear();
             availableCourseClear();
             addStudentsClear();
             clearDepartmentCourseFields();
             clearStudentCourseFields();
        } else if (event.getSource() == addStudents_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(true);
            availableCourse_form.setVisible(false);
            DeptForm.setVisible(false);
            ENROLLCOURSE.setVisible(false);
            STUDENT_GRADEF.setVisible(false);
            clearStudentGrades();
            clearStudentCourseFields();
            clearDepartmentCourseFields();
            showGpa.setText("");
            ADDCOURSETODEPT.setVisible(false);
            addStudents_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,  #995bd5, #bf99f2);");
            home_btn.setStyle("-fx-background-color:transparent");
            availableCourse_btn.setStyle("-fx-background-color:transparent");
            deptBtn.setStyle("-fx-background-color:transparent");
            Enroll_Course.setStyle("-fx-background-color:transparent");
            DEPTCOURSE.setStyle("-fx-background-color:transparent");
            STUDENT_GRADE.setStyle("-fx-background-color:transparent");


//            TO BECOME UPDATED ONCE YOU CLICK THE ADD STUDENTS BUTTON ON NAV
            addStudentsShowListData();
            addgadelevel();
            availableCourseClear();
            addDeptClear();
            addsemester();
            addDeptList();
            addGovernmentList();
            addStudentsCourseList();
//            addStudentsSearch();

        } else if (event.getSource() == availableCourse_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(true);
            DeptForm.setVisible(false);
            ENROLLCOURSE.setVisible(false);
            STUDENT_GRADEF.setVisible(false);
            clearStudentGrades();
            ADDCOURSETODEPT.setVisible(false);
            showGpa.setText("");
            addStudentsClear();
            DEPTCOURSE.setStyle("-fx-background-color:transparent");
            availableCourse_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #995bd5, #bf99f2);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            deptBtn.setStyle("-fx-background-color:transparent");
            Enroll_Course.setStyle("-fx-background-color:transparent");
            STUDENT_GRADE.setStyle("-fx-background-color:transparent");
             clearStudentCourseFields();
             clearDepartmentCourseFields();
             clearStudentCourseFields();
             addDeptClear();
            availableCourseShowListData();

       } else if (event.getSource() == deptBtn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            DeptForm.setVisible(true);
            ENROLLCOURSE.setVisible(false);
            STUDENT_GRADEF.setVisible(false);
            clearStudentGrades();
            clearStudentCourseFields();
            showGpa.setText("");
            addStudentsClear();
            availableCourseClear();
            ADDCOURSETODEPT.setVisible(false);
            deptBtn.setStyle("-fx-background-color:linear-gradient(to bottom right,  #995bd5, #bf99f2);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            availableCourse_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            Enroll_Course.setStyle("-fx-background-color:transparent");
            DEPTCOURSE.setStyle("-fx-background-color:transparent");
            STUDENT_GRADE.setStyle("-fx-background-color:transparent");
            clearDepartmentCourseFields();
            clearStudentCourseFields();
           /* studentGradesShowListData();
            studentGradesSearch();*/

        }
        else if (event.getSource() == Enroll_Course) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            DeptForm.setVisible(false);
            ENROLLCOURSE.setVisible(true);
            ADDCOURSETODEPT.setVisible(false);
            STUDENT_GRADEF.setVisible(false);
            clearStudentGrades();  
            showGpa.setText("");
            addStudentsClear();
            Enroll_Course.setStyle("-fx-background-color:linear-gradient(to bottom right,  #995bd5, #bf99f2);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            availableCourse_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            deptBtn.setStyle("-fx-background-color:transparent");
            DEPTCOURSE.setStyle("-fx-background-color:transparent");
            STUDENT_GRADE.setStyle("-fx-background-color:transparent");
            clearDepartmentCourseFields();
            addgadelevel();
            addsemester();
            addDeptList();
            clearStudentCourseFields();
            addDeptClear();
            addGovernmentList();
           /* studentGradesShowListData();
            studentGradesSearch();*/
        }
         else if (event.getSource() == DEPTCOURSE) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            DeptForm.setVisible(false);
            ENROLLCOURSE.setVisible(false);
            ADDCOURSETODEPT.setVisible(true);
            clearStudentCourseFields();
            STUDENT_GRADEF.setVisible(false);            
            DEPTCOURSE.setStyle("-fx-background-color:linear-gradient(to bottom right, #995bd5, #bf99f2);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            availableCourse_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            deptBtn.setStyle("-fx-background-color:transparent");
            Enroll_Course.setStyle("-fx-background-color:transparent");
            STUDENT_GRADE.setStyle("-fx-background-color:transparent");
            showGpa.setText("");
            clearStudentGrades();
            addgadelevel();
            addsemester();
            addDeptList();
            addStudentsClear();
            availableCourseClear();
            addGovernmentList();
            addDeptClear();
            clearStudentCourseFields();
           /* studentGradesShowListData();
            studentGradesSearch();*/
        }
        else if (event.getSource() == STUDENT_GRADE) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            DeptForm.setVisible(false);
            ENROLLCOURSE.setVisible(false);
            ADDCOURSETODEPT.setVisible(false);
            STUDENT_GRADEF.setVisible(true);            
            STUDENT_GRADE.setStyle("-fx-background-color:linear-gradient(to bottom right,  #995bd5, #bf99f2);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            availableCourse_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            deptBtn.setStyle("-fx-background-color:transparent");
            Enroll_Course.setStyle("-fx-background-color:transparent");
            DEPTCOURSE.setStyle("-fx-background-color:transparent");
            clearStudentCourseFields();
            addgadelevel();
            addsemester();
            clearDepartmentCourseFields();
            addDeptList();
            addGovernmentList();
            addDeptClear();
            addStudentsClear();
            availableCourseClear();
            clearStudentCourseFields();
           /* studentGradesShowListData();
            studentGradesSearch();*/
        }
        
    }
public void availableCourseAdd() {
    String insertData = "INSERT INTO courses VALUES(?,?,?,?)";
    connect = dataAccessLayer.connectDb();

    try {
        Alert alert;

        if (availableCourse_course.getText().isEmpty()
                || availableCourse_Name.getText().isEmpty()
                || availableCourse_Credits.getText().isEmpty()
                || availableCourse_scale.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // Validate if Credits and Grading Scale are numbers
            if (isNumeric(availableCourse_Credits.getText()) && isNumeric(availableCourse_scale.getText())) {
                // CHECK IF THE COURSE YOU WANT TO INSERT IS ALREADY EXIST!
                String checkData = "SELECT courseID FROM courses WHERE courseid = '"
                        + availableCourse_course.getText() + "'";

                Statement statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Course: " + availableCourse_course.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, availableCourse_course.getText());
                    prepare.setString(2, availableCourse_Name.getText());
                    prepare.setInt(3, Integer.parseInt(availableCourse_Credits.getText()));
                    prepare.setInt(4, Integer.parseInt(availableCourse_scale.getText()));

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableCourseShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableCourseClear();
                }
            } else {
                // Credits or Grading Scale is not a number
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Credits and Grading Scale must be numbers");
                alert.showAndWait();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Helper method to check if a string is a number
private boolean isNumeric(String str) {
    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}



public void availableCourseUpdate() {

        String updateData = "UPDATE courses SET coursename = '"
                + availableCourse_Name.getText() + "', credits = '"
                + availableCourse_Credits.getText() + "', GradingScale = '"
                + availableCourse_scale.getText()+ "' WHERE courseid = '"
                + availableCourse_course.getText() + "'";

        connect = dataAccessLayer.connectDb();

        try {
            Alert alert;
   

            if (availableCourse_course.getText().isEmpty()
                    || availableCourse_Name.getText().isEmpty()
                    || availableCourse_Credits.getText().isEmpty()
                    ||availableCourse_scale.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Course: " + availableCourse_course.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    Statement statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableCourseShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableCourseClear();

                } else {
                    return;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

public void availableCourseDelete() {
    String courseId = availableCourse_course.getText();

    if (courseId.isEmpty()) {
        // Display an error message if the course ID is not provided
        showErrorAlert("Please enter the course ID");
        return;
    }

    // Check if there are enrolled students
    boolean hasEnrolledStudents = checkEnrolledStudents(courseId);

    // If there are enrolled students, show a warning
    if (hasEnrolledStudents && !showEnrolledStudentsWarning()) {
        // User canceled the deletion
        return;
    }

    // Proceed with course deletion
    if (confirmCourseDeletion(courseId)) {
        deleteCourse(courseId);
    }
}

// Helper method to check if there are enrolled students in a course
private boolean checkEnrolledStudents(String courseId) {
    try (Connection connection = dataAccessLayer.connectDb()) {
        String checkEnrolledStudentsQuery = "SELECT COUNT(*) FROM student_course WHERE courseID = ?";
        try (PreparedStatement checkEnrolledStudentsStatement = connection.prepareStatement(checkEnrolledStudentsQuery)) {
            checkEnrolledStudentsStatement.setString(1, courseId);
            ResultSet resultSet = checkEnrolledStudentsStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        showErrorAlert("Error checking for enrolled students. See console for details.");
        return false;
    }
}

// Helper method to show a warning if there are enrolled students
private boolean showEnrolledStudentsWarning() {
    Alert warningAlert = new Alert(AlertType.WARNING);
    warningAlert.setTitle("Warning Message");
    warningAlert.setHeaderText(null);
    warningAlert.setContentText("There are enrolled students in this course. "
            + "Are you sure you want to DELETE this course?");

    Optional<ButtonType> option = warningAlert.showAndWait();
    return option.isPresent() && option.get() == ButtonType.OK;
}

// Helper method to confirm course deletion
private boolean confirmCourseDeletion(String courseId) {
    Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Confirmation Message");
    confirmationAlert.setHeaderText(null);
    confirmationAlert.setContentText("Are you sure you want to DELETE Course: " + courseId + "?");

    Optional<ButtonType> option = confirmationAlert.showAndWait();
    return option.isPresent() && option.get() == ButtonType.OK;
}

// Helper method to delete the course
private void deleteCourse(String courseId) {
    try (Connection connection = dataAccessLayer.connectDb()) {
        // Delete records from department_course table
        String deleteDeptCourseQuery = "DELETE FROM department_course WHERE courseID = ?";
        try (PreparedStatement deleteDeptCourseStatement = connection.prepareStatement(deleteDeptCourseQuery)) {
            deleteDeptCourseStatement.setString(1, courseId);
            deleteDeptCourseStatement.executeUpdate();
        }

        // Delete records from student_courses table
        String deleteStudentCourseQuery = "DELETE FROM student_course WHERE courseID = ?";
        try (PreparedStatement deleteStudentCourseStatement = connection.prepareStatement(deleteStudentCourseQuery)) {
            deleteStudentCourseStatement.setString(1, courseId);
            deleteStudentCourseStatement.executeUpdate();
        }

        // Delete the course from the courses table
        String deleteCourseQuery = "DELETE FROM courses WHERE courseID = ?";
        try (PreparedStatement deleteCourseStatement = connection.prepareStatement(deleteCourseQuery)) {
            deleteCourseStatement.setString(1, courseId);
            deleteCourseStatement.executeUpdate();

            // Display success message
            showSuccessAlert("Successfully Deleted!");

            // Update the table view and clear text fields
            availableCourseShowListData();
            availableCourseClear();
            addDepartmentCourseShowListData();
            addStudentCourseShowListData();
            getStudenteId();
            getCourseId();

        }
    } catch (SQLException e) {
        e.printStackTrace();
        showErrorAlert("Error deleting course. See console for details.");
    }
}

// Helper method to show success alert
private void showSuccessAlert(String message) {
    Alert successAlert = new Alert(AlertType.INFORMATION);
    successAlert.setTitle("Information Message");
    successAlert.setHeaderText(null);
    successAlert.setContentText(message);
    successAlert.showAndWait();
}

// Helper method to show error alert
private void showErrorAlert(String message) {
    Alert errorAlert = new Alert(AlertType.ERROR);
    errorAlert.setTitle("Error Message");
    errorAlert.setHeaderText(null);
    errorAlert.setContentText(message);
    errorAlert.showAndWait();
}


    

public void availableCourseClear() {
        availableCourse_course.setText("");
        availableCourse_Credits.setText("");
        availableCourse_Name.setText("");
        availableCourse_scale.setText("");

    }
 public void updateStudentCourse() {
    try {
        int studentId = (Integer)STUDENTID.getSelectionModel().getSelectedItem();
        int courseId = (Integer)COURSEID.getSelectionModel().getSelectedItem();
        LocalDate localDate = EnrolmentDate.getValue();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate); // Assuming ENROLMENTDATE is a DatePicker
        int semester = (Integer) SEMESTER.getSelectionModel().getSelectedItem();
        int grade = Integer.parseInt(GRADE.getText());
        int gradeLevel = (Integer)GRADELEVEL.getSelectionModel().getSelectedItem();
        String status = (String) STATUS.getSelectionModel().getSelectedItem();

        // Update query with PreparedStatement
        String updateQuery = "UPDATE admin.student_course SET " +
                "enrolmentDate = ?, " +
                "semester = ?, " +
                "grade = ?, " +
                "gradeLevel = ?, " +
                "status = ? " +
                "WHERE studentID = ? AND courseID = ?";

        // Execute the update query with PreparedStatement
        try (Connection connection = dataAccessLayer.connectDb();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2, semester);
            preparedStatement.setInt(3, grade);
            preparedStatement.setInt(4, gradeLevel);
            preparedStatement.setString(5, status);
            preparedStatement.setInt(6, studentId);
            preparedStatement.setInt(7, courseId);

            preparedStatement.executeUpdate();

            // Display success message or handle success as needed
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Information Message");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Successfully Updated!");
            successAlert.showAndWait();

            // TO UPDATE THE TABLEVIEW
            addStudentCourseShowListData();
            // TO CLEAR THE FIELDS
            clearStudentCourseFields();

        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();

            // Display error message or handle error as needed
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error updating student course information. See console for details.");
            errorAlert.showAndWait();
        }
    } catch (NullPointerException e) {
        // Handle if any ComboBox selection is not made
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error Message");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("Please select values for all fields.");
        errorAlert.showAndWait();
    }
}

public void deleteStudentCourse() {
    try {
        // Assuming these are the ComboBox components in your FXML file
        Integer studentId = (Integer) STUDENTID.getValue();
        Integer courseId = (Integer) COURSEID.getValue();

        if (studentId != null && courseId != null) {
            // Confirmation dialog to confirm the deletion
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmation");
            confirmationAlert.setHeaderText(null);
            confirmationAlert.setContentText("Are you sure you want to delete this student course?");
            Optional<ButtonType> result = confirmationAlert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Delete query to delete the student course
                String deleteQuery = "DELETE FROM admin.student_course WHERE studentID = " + studentId + " AND courseID = " + courseId;

                try (Connection connection = dataAccessLayer.connectDb();
                     Statement statement = connection.createStatement()) {

                    statement.executeUpdate(deleteQuery);

                    // Display success message or handle success as needed
                    Alert successAlert = new Alert(AlertType.INFORMATION);
                    successAlert.setTitle("Information Message");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Successfully Deleted!");
                    successAlert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentCourseShowListData();
                    // TO CLEAR THE FIELDS
                    clearStudentCourseFields();

                } catch (SQLException e) {
                    // Handle SQL exception
                    e.printStackTrace();

                    // Display error message or handle error as needed
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setTitle("Error Message");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Error deleting student course. See console for details.");
                    errorAlert.showAndWait();
                }
            }
        } else {
            // Handle the case when no student or course is selected
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error Message");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please select a student and a course before deleting.");
            errorAlert.showAndWait();
        }
    } catch (NullPointerException e) {
        // Handle if any ComboBox selection is not made
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error Message");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("Please select values for all fields.");
        errorAlert.showAndWait();
    }
}

   
public void clearStudentCourseFields() {
    // Assuming these are the ComboBox components in your FXML file
    STUDENTID.getSelectionModel().clearSelection();
    COURSEID.getSelectionModel().clearSelection();
    EnrolmentDate.setValue(null);
    SEMESTER.getSelectionModel().clearSelection();
    GRADE.setText("");
    GRADELEVEL.getSelectionModel().clearSelection();
    STATUS.getSelectionModel().clearSelection();
    // Clear other fields as needed
}

    
public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                //HIDE YOUR DASHBOARD FORM
                logOut.getScene().getWindow().hide();

                //LINK YOUR LOGIN FORM 
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    public void addDepartment() {
    String insertData = "INSERT INTO departments VALUES(?,?,?)";

    try (Connection connection = dataAccessLayer.connectDb();
         PreparedStatement preparedStatement = connection.prepareStatement(insertData)) {

        Alert alert;

        if (deptId.getText().isEmpty()
                || deptName.getText().isEmpty()
                || HOF.getText().isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            // CHECK IF THE DEPARTMENT YOU WANT TO INSERT IS ALREADY EXIST!
            String checkData = "SELECT departmentID FROM departments WHERE departmentID = ?";

            try (PreparedStatement checkStatement = connection.prepareStatement(checkData)) {
                checkStatement.setString(1, deptId.getText());
                ResultSet result = checkStatement.executeQuery();

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Department: " + deptId.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    // Prepare and execute the insert statement
                    preparedStatement.setString(1, deptId.getText());
                    preparedStatement.setString(2, deptName.getText());
                    preparedStatement.setString(3, HOF.getText());
                    preparedStatement.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableDeptShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    addDeptClear();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void updateDepartment() {
    String updateData = "UPDATE departments SET DepartmentName = ?, HeadOfDepartment = ? WHERE departmentID = ?";

    try (Connection connection = dataAccessLayer.connectDb();
         PreparedStatement preparedStatement = connection.prepareStatement(updateData)) {

        Alert alert;

        if (deptId.getText().isEmpty()
                || deptName.getText().isEmpty()
                || HOF.getText().isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Department: " + deptId.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                // Prepare and execute the update statement
                preparedStatement.setString(1, deptName.getText());
                preparedStatement.setString(2, HOF.getText());
                preparedStatement.setString(3, deptId.getText());
                preparedStatement.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                availableDeptShowListData();
                // TO CLEAR THE TEXT FIELDS
                addDeptClear();
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void deleteDepartment() {
    String deleteDepartmentQuery = "DELETE FROM departments WHERE departmentID = ?";
    String deleteStudentsQuery = "DELETE FROM students WHERE departmentID = ?";
    String deleteStudentHistoryQuery = "DELETE FROM student_history WHERE studentID = ?";
    String deleteDepartmentCourseQuery = "DELETE FROM department_course WHERE departmentID = ?";
    
    connect = dataAccessLayer.connectDb();

    try {
        // Check if there are students associated with the department
        String checkStudentsQuery = "SELECT * FROM students WHERE departmentID = ?";
        PreparedStatement checkStudentsStatement = connect.prepareStatement(checkStudentsQuery);
        checkStudentsStatement.setInt(1, Integer.parseInt(deptId.getText()));
        ResultSet resultSet = checkStudentsStatement.executeQuery();

        if (resultSet.next()) {
            // Display a confirmation dialog with information about associated students
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmation Message");
            confirmationAlert.setHeaderText(null);
            confirmationAlert.setContentText("There are students associated with this department. Deleting the department will also delete associated students and their history. Are you sure you want to proceed?");

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Proceed with deleting the department, associated students, and their history

                // Get the studentID associated with the department
                int studentIDToDelete = getStudentIDToDelete(Integer.parseInt(deptId.getText()));

                // Use the studentID to delete records in the student_history table
                PreparedStatement deleteStudentHistoryStatement = connect.prepareStatement(deleteStudentHistoryQuery);
                deleteStudentHistoryStatement.setInt(1, studentIDToDelete);
                deleteStudentHistoryStatement.executeUpdate();

                // Delete records in the students table
                PreparedStatement deleteStudentsStatement = connect.prepareStatement(deleteStudentsQuery);
                deleteStudentsStatement.setInt(1, Integer.parseInt(deptId.getText()));
                deleteStudentsStatement.executeUpdate();
                
                // Delete records in the department_course table
                PreparedStatement deleteDepartmentCourseStatement = connect.prepareStatement(deleteDepartmentCourseQuery);
                deleteDepartmentCourseStatement.setInt(1, Integer.parseInt(deptId.getText()));
                deleteDepartmentCourseStatement.executeUpdate();
                
                // Delete the department
                PreparedStatement deleteDepartmentStatement = connect.prepareStatement(deleteDepartmentQuery);
                deleteDepartmentStatement.setInt(1, Integer.parseInt(deptId.getText()));
                deleteDepartmentStatement.executeUpdate();

                // Display success message
                Alert successAlert = new Alert(AlertType.INFORMATION);
                successAlert.setTitle("Information Message");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Department, associated students, and their history successfully deleted!");
                successAlert.showAndWait();
                availableDeptShowListData();
                    // TO CLEAR THE FIELDS
                addDeptClear();
                addDeptList();
            }
        } else {
            // No associated students, proceed with deleting only the department
            // Delete records in the department_course table
            PreparedStatement deleteDepartmentCourseStatement = connect.prepareStatement(deleteDepartmentCourseQuery);
            deleteDepartmentCourseStatement.setInt(1, Integer.parseInt(deptId.getText()));
            deleteDepartmentCourseStatement.executeUpdate();
            
            PreparedStatement deleteDepartmentStatement = connect.prepareStatement(deleteDepartmentQuery);
            deleteDepartmentStatement.setInt(1, Integer.parseInt(deptId.getText()));
            deleteDepartmentStatement.executeUpdate();

            // Display success message
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Information Message");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Department successfully deleted!");
            successAlert.showAndWait();
            // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
            availableDeptShowListData();
                    // TO CLEAR THE FIELDS
            addDeptClear();
            addDepartmentCourseShowListData();
            addStudentCourseShowListData();
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public ObservableList<DepartmentCourse> addDepartmentCourseListData() {
    ObservableList<DepartmentCourse> listDepartmentCourse = FXCollections.observableArrayList();

    String sql = "SELECT * FROM department_course";

    connect = dataAccessLayer.connectDb();

    try {
        DepartmentCourse departmentCourse;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()) {
            departmentCourse = new DepartmentCourse(
                    result.getInt("DEPARTMENTID"),
                    result.getInt("COURSEID")
            );

            listDepartmentCourse.add(departmentCourse);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return listDepartmentCourse;
}


private int getStudentIDToDelete(int departmentID) {
    int studentIDToDelete = 0; // Default value

    // Implement your logic to get the studentID associated with the departmentID
    String getStudentIDQuery = "SELECT s.studentID " +
    "FROM admin.students s " +
    "JOIN admin.student_history sh ON s.studentID = sh.studentID " +
    "WHERE s.departmentID = ?";
    
    try {
        PreparedStatement getStudentIDStatement = connect.prepareStatement(getStudentIDQuery);
        getStudentIDStatement.setInt(1, departmentID);

        ResultSet resultSet = getStudentIDStatement.executeQuery();

        if (resultSet.next()) {
            studentIDToDelete = resultSet.getInt("studentID");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    System.out.print(studentIDToDelete);
    return studentIDToDelete;
}
private void clearStudentGrades() {
    clearStudentGradesTable();
    clearStudentIdComboBox();
}

private void clearStudentGradesTable() {
    STUDENT_GRADE_TABLE.getItems().clear();
}

private void clearStudentIdComboBox() {
    StudentIdGrade.getSelectionModel().clearSelection();
}
public void clearDepartmentCourseFields() {
    // Assuming DEPTID and COURSEID1 are ComboBox controls
    DEPTID.getSelectionModel().clearSelection(); // Clear the selected department
    COURSEID1.getSelectionModel().clearSelection(); // Clear the selected course

    // You can also set default values if needed
    // DEPTID.setValue(defaultDepartmentValue);
    // COURSEID1.setValue(defaultCourseValue);
}

/*public void addDepartmentCourseSelect() {
    DepartmentCourse departmentCourse = DEPTCOURSET.getSelectionModel().getSelectedItem();

    if (departmentCourse != null) {
        DEPTID.setValue(departmentCourse.getDepartmentId());
        COURSEID1.setValue(departmentCourse.getCourseId());
    }
}
*/






//department_course part


 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setLabels();
        availableCourseShowListData();
        addStudentsShowListData();
        defaultNav();
        availableDeptShowListData();
        addgadelevel();
        addsemester();
        addDeptList();
        addGovernmentList();
        addStudentCourseShowListData();
        getStudenteId();
        addstatus();
        addDepartmentCourseListData();
        addDepartmentCourseShowListData();
        getCourseId();
        homeDisplayTotalEnrolledChart();
        displayAvgGPAChart();
    }    
    
}

