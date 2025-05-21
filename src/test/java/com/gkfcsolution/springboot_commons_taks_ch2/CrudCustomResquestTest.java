package com.gkfcsolution.springboot_commons_taks_ch2;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import com.gkfcsolution.springboot_commons_taks_ch2.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CrudCustomResquestTest {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void givenCoursesCreatedWhenLoadCoursesWithQueryThenExpectCorrectCourseDetails(){
        courseRepository.saveAll(getCourseList());

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<Course> courseCriteriaQuery = criteriaBuilder.createQuery(Course.class);

        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);

        Predicate courseCategoryPredicate = criteriaBuilder.equal(courseRoot.get("category"), "Spring");

        courseCriteriaQuery.where(courseCategoryPredicate);

        TypedQuery<Course> query = entityManager.createQuery(courseCriteriaQuery);

        assertThat(query.getResultList().size()).isEqualTo(3);
    }

    @Test
    public void givenCreateCourseWhenLoadTheCourseThenExpectSameCourse(){
        courseRepository.saveAll(getCourseList());
        assertThat(courseRepository.findAllByCategory("Spring")).hasSize(3);
        assertThat(courseRepository.existsByName("JavaScript for All")).isTrue();
        assertThat(courseRepository.existsByName("Mastering JavaScript")).isFalse();
        assertThat(courseRepository.countByCategory("Python")).isEqualTo(2);
        assertThat(courseRepository.findByNameStartsWith("Getting Started")).hasSize(3);
        assertThat(courseRepository.findByNameContains("Rapid")).hasSize(1);
    }

    @Test
    public void givenCoursesCreatedWhenLoadCoursesBySpringCategoryThenExpectThreeCourses(){
        courseRepository.saveAll(getCourseList());
        assertThat(courseRepository.findAllByCategoryAndRating("Spring", 4)).hasSize(1);
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
