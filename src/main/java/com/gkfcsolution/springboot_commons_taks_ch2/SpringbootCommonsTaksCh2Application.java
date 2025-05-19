package com.gkfcsolution.springboot_commons_taks_ch2;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SpringbootCommonsTaksCh2Application implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(SpringbootCommonsTaksCh2Application.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringbootCommonsTaksCh2Application.class, args);
        logger.info("CourseTrackerApplication started successfully with Log4j2 configuration");

    }


    @Override
    public void run(String... args) throws Exception {
        Course course = new Course();
        course.setId(1);
        course.setRating(0);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Course>> violations = validator.validate(course);
        violations.forEach(courseConstraintViolation -> logger.error("A constraint violation has occurred. Violation details: [{}].", courseConstraintViolation));
        ;
    }
}
