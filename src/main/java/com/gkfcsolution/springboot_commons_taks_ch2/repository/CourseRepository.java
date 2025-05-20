package com.gkfcsolution.springboot_commons_taks_ch2.repository;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
