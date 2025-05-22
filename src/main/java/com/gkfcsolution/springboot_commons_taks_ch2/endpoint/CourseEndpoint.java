package com.gkfcsolution.springboot_commons_taks_ch2.endpoint;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import com.gkfcsolution.springboot_commons_taks_ch2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Endpoint(id = "courses")
public class CourseEndpoint {
    @Autowired
    private CourseRepository courseRepository;

    @ReadOperation
//    @Transactional
    public Iterable<Course> courses() {
        return courseRepository.findAll();
    }

    @ReadOperation
    public Object selectCourse(@Selector Long courseId){
        Iterable<Course> courses = courseRepository.findAll();
        for (Course course: courses){
            if (course.getId() == courseId)
                return course;
        }
        return String.format("No course with course id %d available", courseId);
    }
    @WriteOperation
    public void updateCourseRating(@Selector Long courseId, int newRating){
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (!optionalCourse.isEmpty()){
            Course course = optionalCourse.get();
            course.setRating(newRating);
            courseRepository.save(course);
        }
    }

    @DeleteOperation
    public void deleteCourses(){
        courseRepository.deleteAll();
    }
    @DeleteOperation
    public void deleteCourseById(@Selector Long id){
        courseRepository.deleteById(id);
    }
}
