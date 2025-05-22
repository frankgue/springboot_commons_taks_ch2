package com.gkfcsolution.springboot_commons_taks_ch2;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import com.gkfcsolution.springboot_commons_taks_ch2.projection.DescriptionOnly;
import com.gkfcsolution.springboot_commons_taks_ch2.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class InterfaceBaseProjectionTests {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void givenACourseAvailableWhenGetCourseByNameThenGetCourseDescription(){
//        courseRepository.saveAll(getCourseList());
        Iterable<DescriptionOnly> result = courseRepository.getCourseByName("Rapid Spring Boot Application Development");
        assertThat(result).hasSize(1);
        assertThat(result).extracting("description").containsExactly("Spring Boot gives all the power of the Spring Framework without all of the complexity");
    }


    private List<Course> getCourseList() {
        Course rapidSpringBootCourse = new Course("Rapid Spring Boot Application Development", "Spring", 4, "Spring Boot gives all the power of the Spring Framework without all of the complexity");
        Course springSecurityDslCourse = new Course("Getting Started with Spring Security DSL", "Spring", 5, "Learn Spring Security DSL in easy steps");
        Course springCloudKubernetesCourse = new Course("Getting Started with Spring Cloud Kubernetes", "Spring", 3, "Master Spring Boot application deployment with Kubernetes");
        Course rapidPythonCourse = new Course("Getting Started with Python", "Python", 5, "Learn Python concepts in easy steps");
        Course gameDevelopmentWithPython = new Course("Game Development with Python", "Python", 3, "Learn Python by developing 10 wonderful games");
        Course javaScriptForAll = new Course("JavaScript for All", "JavaScript", 4, "Learn basic JavaScript syntax that can apply to anywhere");
        Course javaScriptCompleteGuide = new Course("JavaScript Complete Guide", "JavaScript", 5, "Master JavaScript with Core Concepts and Web Development");

        return Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse, rapidPythonCourse, gameDevelopmentWithPython, javaScriptForAll, javaScriptCompleteGuide);
    }
}
