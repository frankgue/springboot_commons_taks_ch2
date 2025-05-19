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
import org.springframework.core.env.Environment;

import java.util.Properties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringbootCommonsTaksCh2Application implements CommandLineRunner {

	protected final Log logger = LogFactory.getLog(getClass());
	public static void main(String[] args) {

		SpringApplication.run(SpringbootCommonsTaksCh2Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("CourseTrackerApplication CommandLineRunner has executed");
	}
}
