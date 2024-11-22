package com.markmaster.backend.repository;

import com.markmaster.backend.models.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends AbstractBaseRepository<Course, Long> {
}
