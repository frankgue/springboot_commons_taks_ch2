package com.gkfcsolution.springboot_commons_taks_ch2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCommonsTaksCh2Application {

    private static Logger logger = LoggerFactory.getLogger(SpringbootCommonsTaksCh2Application.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringbootCommonsTaksCh2Application.class, args);
        logger.info("CourseTrackerApplication started successfully with Log4j2 configuration");

    }


}
