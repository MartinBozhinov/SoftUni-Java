package exThree;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends User {
    private Float avgGrade;
    private Integer attendance;
    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "average_grade")
    public Float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Float avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Column(name = "attendance")
    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    @ManyToMany
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
