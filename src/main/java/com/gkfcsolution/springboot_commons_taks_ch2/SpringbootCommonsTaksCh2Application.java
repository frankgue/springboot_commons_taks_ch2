package com.gkfcsolution.springboot_commons_taks_ch2;

import com.gkfcsolution.springboot_commons_taks_ch2.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringbootCommonsTaksCh2Application {


    public static void main(String[] args) {

        SpringApplication.run(SpringbootCommonsTaksCh2Application.class, args);

    }


}
