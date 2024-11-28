package com.markmaster.backend.service.Course;

import com.markmaster.backend.models.Course;
import com.markmaster.backend.service.Crud.AbstractBaseService;

public interface CourseService extends AbstractBaseService<Course, Long> {
    public void updateParentDepartment(long id);

}
