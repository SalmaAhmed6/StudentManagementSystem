/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author salma
 */
public class Student_Course {
   
    private int studentID;
    private int courseID;
    private Date enrolmentDate;
    private String semester;
    private int grade;
    private int gradeLevel;
    private String status;

    // Constructors
    public Student_Course(int studentID, int courseID, Date enrolmentDate, String semester,
                      int grade, int gradeLevel, String status) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.enrolmentDate = enrolmentDate;
        this.semester = semester;
        this.grade = grade;
        this.gradeLevel = gradeLevel;
        this.status = status;
    }

    // Getters and Setters
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public Date getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(Date enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
    

