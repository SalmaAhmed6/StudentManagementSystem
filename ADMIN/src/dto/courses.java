/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author salma
 */
public class courses {
    
    private int courseId;
    private String courseName;
    private int credits;
    private int gradingScale;

    // Constructors
    public courses(int courseId, String courseName, int credits, int gradingScale) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.gradingScale = gradingScale;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getGradingScale() {
        return gradingScale;
    }

    public void setGradingScale(int gradingScale) {
        this.gradingScale = gradingScale;
    }

}


