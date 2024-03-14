/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
public class DepartmentCourse {
    private int departmentId;
    private int courseId;

    public DepartmentCourse(int departmentId, int courseId) {
        this.departmentId = departmentId;
        this.courseId = courseId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "DepartmentCourse{" +
                "departmentId=" + departmentId +
                ", courseId=" + courseId +
                '}';
    }
}
