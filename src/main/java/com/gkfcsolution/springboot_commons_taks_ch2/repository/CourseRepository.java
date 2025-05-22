package com.gkfcsolution.springboot_commons_taks_ch2.repository;

import com.gkfcsolution.springboot_commons_taks_ch2.dto.CourseDto;
import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import com.gkfcsolution.springboot_commons_taks_ch2.projection.DescriptionOnly;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Iterable<DescriptionOnly> getCourseByName(String name);


}
