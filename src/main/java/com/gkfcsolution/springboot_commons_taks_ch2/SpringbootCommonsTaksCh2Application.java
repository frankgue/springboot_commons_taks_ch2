package com.gkfcsolution.springboot_commons_taks_ch2;

import com.gkfcsolution.springboot_commons_taks_ch2.model.Course;
import com.gkfcsolution.springboot_commons_taks_ch2.model.User;
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

//        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//        Set<ConstraintViolation<Course>> violations = validator.validate(course);
//        violations.forEach(courseConstraintViolation -> logger.error("A constraint violation has occurred. Violation details: [{}].", courseConstraintViolation));

        User user1 = new User("frank", "frank");
        Validator validatorPassword = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> violationsP = validatorPassword.validate(user1);
        logger.error("Password for user1 do not adhere to the password policy");
        violationsP.forEach(userConstraintViolation -> logger.error("Violation details: [{}].",
                userConstraintViolation.getMessage()));

        User user2 = new User("frank2", "Frank@724");
        violationsP = validatorPassword.validate(user2);
        if (violationsP.isEmpty()) {
            logger.info("Password for user2 adhere to the password policy");
        }

        User user3 = new User("frank3", "Frank@724kkk");
        violationsP = validatorPassword.validate(user3);
        logger.error("Password for user3 violates maximum repetitive rule");
        violationsP.forEach(userConstraintViolation -> logger.error("Violation details: [{}].",
                userConstraintViolation.getMessage()));

        User user4 = new User("franko", "Frank7245");
        violationsP = validatorPassword.validate(user4);
        violationsP.forEach(userConstraintViolation -> logger.error("Violation details: [{}].",
                userConstraintViolation.getMessage()));

    }
}
