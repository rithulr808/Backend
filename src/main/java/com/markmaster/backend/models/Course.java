//package com.markmaster.backend.models;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "Course")
//public class Course extends AbstractBaseEntity {
//
//    @Column(name = "course_name")
//    private String courseName;
//    @ManyToOne(targetEntity = Department.class, cascade = CascadeType.REMOVE, optional = true)
//    private Department department;
//    @Column(name = "course_full_name")
//    private String courseFullName;
//
//
//    public String getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(String courseName) {
//        this.courseName = courseName;
//    }
//
//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
//
//
//    public String getCourseFullName() {
//        return courseFullName;
//    }
//
//    public void setCourseFullName(String courseFullName) {
//        this.courseFullName = courseFullName;
//    }
//}
package com.markmaster.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Course")
public class Course extends AbstractBaseEntity {

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_full_name", nullable = false)
    private String courseFullName;

    @Column(name = "course_credit", nullable = false)
    private Integer courseCredit;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "course_img")
    private String courseImg;

    // Removed department field and relationship

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseFullName() {
        return courseFullName;
    }

    public void setCourseFullName(String courseFullName) {
        this.courseFullName = courseFullName;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }
}

