package com.markmaster.backend.controllers;

import com.markmaster.backend.helpers.HttpResponseMessageHandler;
import com.markmaster.backend.models.Course;
import com.markmaster.backend.models.DTO.CourseDepartmentDTO;
import com.markmaster.backend.service.Course.CourseService;
//import com.markmaster.backend.service.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;
//    private final DepartmentService departmentService;
    private final HttpResponseMessageHandler httpResponseUpdater;

    @Autowired
    public CourseController(CourseService courseService, HttpResponseMessageHandler httpResponseUpdater) {
        this.courseService = courseService;
        this.httpResponseUpdater = httpResponseUpdater;
//        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    ResponseEntity<Map<String, Object>> all() {
        return httpResponseUpdater.updateHttpResponse("Success", HttpStatus.OK, courseService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Map<String, Object>> getById(@PathVariable Long id) {
        Optional<Course> courseOptional = Optional.ofNullable(courseService.findById(id));
        if (courseOptional.isPresent()) {
            return httpResponseUpdater.updateHttpResponse("Success", HttpStatus.OK, courseOptional);
        }
        return httpResponseUpdater.updateHttpResponse("Course with the given id not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    ResponseEntity<Map<String, Object>> create(@RequestBody CourseDepartmentDTO dto) throws HttpMessageNotReadableException {
        System.out.println(dto.toString());
        Course course = dto.getCourse();
////        Department department = dto.getDepartment();
//        if (department == null) {
//            return httpResponseUpdater.updateHttpResponse("Department not found", HttpStatus.NOT_FOUND);
//        }
        if (course == null) {
            return httpResponseUpdater.updateHttpResponse("Course not found", HttpStatus.NOT_FOUND);
        }
//        Optional<Department> departmentOptional = Optional.ofNullable(departmentService.findById(department.getId()));
//        if (departmentOptional.isPresent()) {
//            course.setDepartment(department);
//            courseService.save(course);
//            System.out.println(department.getDepartmentName());
//            return httpResponseUpdater.updateHttpResponse("Course with has been created successfully", HttpStatus.OK);
//        }
        return httpResponseUpdater.updateHttpResponse("Department not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody CourseDepartmentDTO dto) {
        Optional<Course> courseOptional = Optional.ofNullable(courseService.findById(id));

        if (courseOptional.isPresent()) {
            Course course = dto.getCourse();
//            Department department = dto.getDepartment();

            courseService.updateById(course, id);

//            if (department != null) {
//                courseService.updateParentDepartment(course.getId());
//            }

            return httpResponseUpdater.updateHttpResponse("Course with id: " + id + " has been updated successfully", HttpStatus.OK);
        }

        return httpResponseUpdater.updateHttpResponse("Course with id: " + id + " not found", HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Optional<Course> courseOptional = Optional.ofNullable(courseService.findById(id));
        if (courseOptional.isPresent()) {
            courseService.deleteById(id);
            return httpResponseUpdater.updateHttpResponse("Course with id:" + id + " has been deleted successfully", HttpStatus.OK);
        }
        return httpResponseUpdater.updateHttpResponse("Course with id:" + id + " not found", HttpStatus.NOT_FOUND);
    }

}
