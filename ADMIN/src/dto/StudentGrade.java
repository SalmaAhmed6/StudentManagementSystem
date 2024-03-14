package dto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentGrade {
    private final SimpleIntegerProperty course;
    private final SimpleIntegerProperty grade;

    public StudentGrade(int course, int grade) {
        this.course = new SimpleIntegerProperty(course);
        this.grade = new SimpleIntegerProperty(grade);
    }

    public int getCourse() {
        return course.get();
    }

    public void setCourse(int course) {
        this.course.set(course);
    }

    public SimpleIntegerProperty courseProperty() {
        return course;
    }

    public int getGrade() {
        return grade.get();
    }

    public void setGrade(int grade) {
        this.grade.set(grade);
    }

    public SimpleIntegerProperty gradeProperty() {
        return grade;
    }
}
