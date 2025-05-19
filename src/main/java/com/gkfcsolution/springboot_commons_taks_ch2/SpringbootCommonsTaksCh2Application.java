package com.gkfcsolution.springboot_commons_taks_ch2;

import com.gkfcsolution.springboot_commons_taks_ch2.config.DbConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

@SpringBootApplication
public class SpringbootCommonsTaksCh2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootCommonsTaksCh2Application.class, args);
		DbConfiguration dbConfiguration = applicationContext.getBean(DbConfiguration.class);
		System.out.println(dbConfiguration);

		/*Properties properties = new Properties();
		properties.setProperty("spring.config.on-not-found", "ignore");

		SpringApplication application = new SpringApplication(SpringbootCommonsTaksCh2Application.class);
		application.setDefaultProperties(properties);
		application.run(args);*/

//		SpringApplication.run(SpringbootCommonsTaksCh2Application.class, args);
	}

}
