package com.markmaster.backend.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.markmaster.backend.models.Course;

public class CourseDepartmentDTO {
    @JsonProperty("course")
    private Course course;
//    @JsonProperty("department")
//    private Department department;


    public CourseDepartmentDTO(Course course) {
        this.course = course;
//        this.department = department;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

//    public Department getDepartment() {
//        return department;
//    }

//    public void setDepartment(Department department) {
//        this.department = department;
//    }

//    @Override
//    public String toString() {
//        return "CourseDepartmentDTO{" + "course=" + course.getCourseName() + ", department=" + department.getDepartmentName() + '}';
//    }
}
