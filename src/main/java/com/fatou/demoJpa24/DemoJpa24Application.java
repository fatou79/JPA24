package com.fatou.demoJpa24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatou.demoJpa24.Repository.CourseRepository;
import com.fatou.demoJpa24.entity.Course;

@SpringBootApplication
public class DemoJpa24Application implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	public CourseRepository diagne;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpa24Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = diagne.findById(10001L);	
		
		logger.info("Course 10001 -> {}", course);
		diagne.deletedById(10001L);
		diagne.save(new Course("Microservice"));
	}

}
