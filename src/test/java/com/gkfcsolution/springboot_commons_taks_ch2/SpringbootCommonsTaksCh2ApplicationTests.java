package com.gkfcsolution.springboot_commons_taks_ch2;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import com.gkfcsolution.springboot_commons_taks_ch2.repository.AuthorRepository;
import com.gkfcsolution.springboot_commons_taks_ch2.repository.CourseRepository;
import com.gkfcsolution.springboot_commons_taks_ch2.repository.CustomizedCourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
@DataJpaTest
class SpringbootCommonsTaksCh2ApplicationTests {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CustomizedCourseRepository customizedCourseRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void whenCountAllCoursesThenExpectFiveCourses(){
        assertThat(authorRepository.getAuthorCourseInfo(2)).hasSize(3);
    }

    @Test
    public void givenCreateCourseWhenLoadTheCourseThenExpectSameCourse() {
        Course course = new Course("Rapid Spring Boot Application Development", "Spring", 4, "Spring Boot gives all the power of the Spring Framework without all of the complexities");
        Course savedCourse = courseRepository.save(course);
        assertThat(courseRepository.findById(savedCourse.getId()).get().getName()).isEqualTo(course.getName());
    }
//
//    @Test
//    public void givenUpdateCourseWhenLoadTheCourseThenExpectUpdatedCourse() {
//        Course course = new Course("Rapid Spring Boot Application Development", "Spring",
//                4, "Spring Boot gives all the power of the Spring Framework without all of the complexities");
//        courseRepository.save(course);
//        course.setRating(5);
//        Course savedCourse = courseRepository.save(course);
//        assertThat(courseRepository.findById(savedCourse.getId()).get().getRating()).isEqualTo(5);
//    }
//
//    @Test
//    public void givenDeleteCourseWhenLoadTheCourseThenExpectNoCourse(){
//        Course course = new Course("Rapid Spring Boot Application Development", "Spring",
//                4, "'Spring Boot gives all the power of the Spring Framework without all of the complexities");
//        Course savedCourse = courseRepository.save(course);
//        assertThat(courseRepository.findById(savedCourse.getId()).get().getName()).isEqualTo(course.getName());
//        courseRepository.delete(savedCourse);
//        assertThat(courseRepository.findById(savedCourse.getId()).isPresent()).isFalse();
//    }
//
//    @Test
//    public void givenCreateCourseWhenFindAllCoursesThenExpectOneCourse() {
//        Course course = new Course("Rapid Spring Boot Application Development", "Spring",
//                4, "'Spring Boot gives all the power of the Spring Framework without all of the complexities");
//        Course savedCourse = customizedCourseRepository.save(course);
//        assertThat(Arrays.asList(customizedCourseRepository.findAll()).size()).isEqualTo(1);
//    }

}
