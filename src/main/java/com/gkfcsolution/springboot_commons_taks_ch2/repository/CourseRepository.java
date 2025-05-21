package com.gkfcsolution.springboot_commons_taks_ch2.repository;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    //     Finds all courses by category. A find query returns an Iterable type
        /*The repository method that finds all the courses belongs to the supplied category.
    The @Query annotation lets you specify the JPQL Query. You have used a positional
    argument with ?1 which is replaced by the supplied category in this example*/
    @Query("select c from Course c where c.category=?1")
    Iterable<Course> findAllByCategory(String category);

    /*
    # The repository method finds all the courses that belong to the supplied
category and has a rating value greater than the one supplied in the rating
parameter. You have used named parameters in this example. These named parameters
are replaced by the supplied category and rating values in this example.
     */
    @Query("select c from Course c where c.category=:category and c.rating > :rating")
    Iterable<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);

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

    /**
     * Named Query
     */

    Iterable<Course> findAllByCategoryAndRating(String category, int rating);

    /*
    The repository method that finds all the courses for a given rating. This is not a
    JPQL query and we’ve set the nativeQuery to true to indicate this query is a native
    SQL database query
     */
    @Query(value = "select * from COURSES where rating=?1", nativeQuery = true)
    Iterable<Course> findAllByRating(int rating);

    /*     The repository method that lets you update a course rating. The @Modifying annotation
    indicates that the query specified in the @Query annotation is a modifying query.
    The @Transactional annotation bounds the method execution in a transaction context
    as it is performing a database update
     */
    @Modifying
    @Transactional
    @Query("update Course c set c.rating = :rating where c.name = :name")
    int updateCourseRatingByName(@Param("rating") int rating, @Param("name") String name);

}
