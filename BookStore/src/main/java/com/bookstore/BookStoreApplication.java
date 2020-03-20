package com.bookstore;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bookstore.entities.Courses;
import com.bookstore.entities.Instructor;
import com.bookstore.entities.InstructorDetail;
import com.bookstore.repositories.CoursesRepository;
import com.bookstore.repositories.InstructorDetailRepository;
import com.bookstore.repositories.InstructorRepository;

@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.bookstore"})
@EnableJpaRepositories(basePackages="com.bookstore.repositories")
@EnableTransactionManagement
@EntityScan(basePackages="com.bookstore.entities")
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner mappingDemo(CoursesRepository coursesRepository, InstructorRepository instructorRepository,
			InstructorDetailRepository instructorDetailRepository) {
		return args -> {

			// create instructor
			Instructor instructor = new Instructor("Phu", "Vu", "vd.phu@gmail.com"); 
			// create instructor detail
			InstructorDetail instructorDetail = new InstructorDetail("green.com", "Java");

			// Mapping (OneToOne) - Between Instructor and Instructor Detail
			// associate the objects - Instructor
			instructorDetail.setInstructor(instructor); 
			// save instructor detail
			instructorDetailRepository.save(instructorDetail);

			// associate the objects - InstructorDetail
			instructor.setInstructorDetail(instructorDetail); 
			// save the instructor
			instructorRepository.save(instructor);

			// Mapping (OneToMany) - Between Instructor and Courses
			Optional<Instructor> result = instructorRepository.findById((long) 1);
			if (result.isPresent()) {
				Instructor tempInstructor = result.get();
				// create course
				Courses courses1 = new Courses("Java Class", tempInstructor);
				Courses courses2 = new Courses("JavaScript Class", tempInstructor);

				// add courses to instructor
				tempInstructor.add(courses1);
				tempInstructor.add(courses2);

				instructorRepository.save(tempInstructor);

			}

		};

	}

}


