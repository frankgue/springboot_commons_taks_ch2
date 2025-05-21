package com.gkfcsolution.springboot_commons_taks_ch2.repository;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    //     Finds all courses by category. A find query returns an Iterable type
    Iterable<Course> findAllByCategory(String category);

    //Finds all courses by category and order the entities by name
    Iterable<Course> findAllByCategoryOrderByName(String category);

    //    Checks if a course with the supplied name exists. Returns true if course exists,false otherwise. Exists queries return the boolean type
    boolean existsByName(String name);

    //    Returns the count of courses for the supplied category. Count queries can return an integer or long type
    long countByCategory(String category);

    //    Finds all courses that match the supplied course name OR the course category
    Iterable<Course> findByNameOrCategory(String name, String category);

    //    Finds all courses that start with the supplied course name string
    Iterable<Course> findByNameStartsWith(String name);

    //    Finds all courses that containt the supplied course name string
    Iterable<Course> findByNameContains(String name);

    //    Finds all courses by category and returns a Java 8 Stream
    Stream<Course> streamAllByCategory(String category);

}
