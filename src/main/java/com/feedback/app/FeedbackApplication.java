package com.feedback.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FeedbackApplication extends SpringBootServletInitializer implements CommandLineRunner{

//	@Autowired
//    DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(FeedbackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("DATASOURCE = " + dataSource);
	}

}
