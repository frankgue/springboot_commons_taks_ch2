package com.gkfcsolution.springboot_commons_taks_ch2;

import com.gkfcsolution.springboot_commons_taks_ch2.config.AppProperties;
import com.gkfcsolution.springboot_commons_taks_ch2.config.DbConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Properties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringbootCommonsTaksCh2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootCommonsTaksCh2Application.class, args);
		AppService appService = applicationContext.getBean(AppService.class);
		System.out.println(appService.getAppProperties());
		/*Environment env = applicationContext.getBean(Environment.class);
		System.out.println("Database \n Username: " + env.getProperty("spring.datasource.username"));
		System.out.println("Database \n Password: " + env.getProperty("spring.datasource.password"));*/

	}

}
