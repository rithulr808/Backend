package com.markmaster.backend.service.Course;

import com.markmaster.backend.models.Course;
import com.markmaster.backend.repository.CourseRepo;
import com.markmaster.backend.service.Crud.AbstractBaseRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CourseServiceImplementation extends AbstractBaseRepositoryImpl<Course, Long> implements CourseService {
    private final CourseRepo courseRepo;
    private CourseRepo batchRepo;

    public CourseServiceImplementation(CourseRepo courseRepo) {
        super(courseRepo);
        this.courseRepo = courseRepo;
    }
    @Override
    public void updateParentDepartment(long id ) {
        Optional<Course> courseOptional = courseRepo.findById(id);
//        if (courseOptional.isPresent()) {
//            Course course = courseOptional.get();
//            course.setDepartment(department);
//            courseRepo.save(course);
//        }

    }
}