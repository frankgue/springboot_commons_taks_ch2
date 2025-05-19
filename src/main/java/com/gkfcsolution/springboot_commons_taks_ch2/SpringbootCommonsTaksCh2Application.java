package com.gkfcsolution.springboot_commons_taks_ch2;

import com.gkfcsolution.springboot_commons_taks_ch2.config.AppProperties;
import com.gkfcsolution.springboot_commons_taks_ch2.config.DbConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Properties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringbootCommonsTaksCh2Application {

    protected final Log logger = LogFactory.getLog(getClass());

    public static void main(String[] args) {

        SpringApplication.run(SpringbootCommonsTaksCh2Application.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            logger.info("CommandLineRunner executed as a bean definition with " + args.length + " arguments");
			for (int i = 0; i < args.length; i++) {
				logger.info("Argument: " + args[i]);
			}
        };
    }

}
