package com.gkfcsolution.springboot_commons_taks_ch2.service;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import com.gkfcsolution.springboot_commons_taks_ch2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Iterable<Course> getAvailableCourses(){
        return courseRepository.findAll();
    }
}
