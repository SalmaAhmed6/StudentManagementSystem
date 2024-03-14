/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

public class CourseAvgGPA {
    private String courseName;
    private double avgGPA;

    public CourseAvgGPA(String courseName, double avgGPA) {
        this.courseName = courseName;
        this.avgGPA = avgGPA;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getAvgGPA() {
        return avgGPA;
    }
}
