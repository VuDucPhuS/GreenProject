package com.university;

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

import com.university.entities.Course;
import com.university.entities.Instructor;
import com.university.entities.InstructorDetail;
import com.university.entities.Review;
import com.university.repositories.CourseRepository;
import com.university.repositories.InstructorDetailRepository;
import com.university.repositories.InstructorRepository;
import com.university.repositories.ReviewRepository;


@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.university"})
@EnableJpaRepositories(basePackages="com.university.repositories")
@EnableTransactionManagement
@EntityScan(basePackages="com.university.entities")
public class BasicDatabase {

	public static void main(String[] args) {
		SpringApplication.run(BasicDatabase.class, args);
	}
	
	@Bean
	public CommandLineRunner mappingDemo(InstructorRepository instructorRepository,
			InstructorDetailRepository instructorDetailRepository, CourseRepository courseRepository, ReviewRepository reviewRepository) {
		return args -> {

			/*-----------------------------------------------------------------------------------------------*/
			/*-------------------------OneToOne - Bi-Directional---------------------------------------------*/
			System.out.println("===== OneToOne - Bi-Directional =====");
			// create instructor
			Instructor instructor1 = new Instructor("Phu", "Vu", "phuvu@gmail.com");
			Instructor instructor2 = new Instructor("Trang", "Nguyen", "trangnguyen@gmail.com");
			
			// create instructor detail
			InstructorDetail instructorDetail1 = new InstructorDetail("JavaSpring.com", "Java");
			InstructorDetail instructorDetail2 = new InstructorDetail("BootStrap.com", "Bootstrap");

			// Mapping (OneToOne) - Between Instructor and Instructor Detail
			// associate the objects - InstructorDetail
			instructor1.setInstructorDetail(instructorDetail1); 
			instructor2.setInstructorDetail(instructorDetail2);
			
			// save to instructor to database
			System.out.println("\nSaving instructor: " + instructor1);
			instructorRepository.save(instructor1);
			System.out.println("\nSaving instructor: " + instructor2);
			instructorRepository.save(instructor2);
			
			
			//Delete instructor
			/*
			Optional<Instructor> theInstructorId = instructorRepository.findById((long) 1);
			if (theInstructorId.isPresent() ) {
				Instructor tempInstructor = theInstructorId.get();
				if (tempInstructor != null) {
					System.out.println("Deleting: " + tempInstructor);
					instructorRepository.delete(tempInstructor);
				}
			}
			*/
			
			/*-----------------------------------------------------------------------------------------------*/
			/*-------------------------OneToOne - Uni-Directional--------------------------------------------*/
			System.out.println("===== OneToOne - Uni-Directional =====");
			Optional<InstructorDetail> theInstructorDetailId = instructorDetailRepository.findById((long) 1);
			if (theInstructorDetailId.isPresent() ) {
				InstructorDetail tempInstructorDetail = theInstructorDetailId.get();
				if (tempInstructorDetail != null) {
					
					// print the instructor detail object
					System.out.println("\nPrinting tempInstructorDetail: " + tempInstructorDetail);
					
					// print the associated instructor
					System.out.println("\nPrinting the associated instructor: " + tempInstructorDetail.getInstructor());
					
					/*
					// Delete instructorDetail
					// remove the associated object reference
					// break bi-directional link
					tempInstructorDetail.getInstructor().setInstructorDetail(null);
					
					// delete the instructor detail
					System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
					instructorDetailRepository.delete(tempInstructorDetail);
					*/
				}
			}
			
			/*-----------------------------------------------------------------------------------------------*/
			/*-------------------------OneToMany - Bi-Directional---------------------------------------------*/
			/*
			System.out.println("===== OneToMany - Bi-Directional =====");
			
			Course course1 = new Course("Spring Java - Security");
			Course course2 = new Course("Spring Java - MVC");
			Optional<Instructor> theInstructorId = instructorRepository.findById((long) 1);
			if (theInstructorId.isPresent() ) {
				Instructor tempInstructor = theInstructorId.get();
				if (tempInstructor != null) {
					System.out.println("Adding Course to Instructor: " + tempInstructor);
					tempInstructor.add(course1);
					tempInstructor.add(course2);
					instructorRepository.save(tempInstructor);
				}
			}
			*/
			
			/*-----------------------------------------------------------------------------------------------*/
			/*-------------------------OneToMany - Uni-Directional---------------------------------------------*/
			// add some reviews
			
			Course course1 = new Course("Spring Java - Security");
			Course course2 = new Course("Spring Java - MVC");
			courseRepository.save(course1);
			courseRepository.save(course2);
			
			Review review1 = new Review("Great Course ... love so much");
			Review review2 = new Review("Cool course, well done");
			Review review3 = new Review("I hate this course");
			
			
			Optional<Course> theCourseId = courseRepository.findById((long) 1);
			if (theCourseId.isPresent() ) {
				Course tempCourse = theCourseId.get();
				if (tempCourse != null) {
					System.out.println("Adding Review to Course: " + tempCourse);
					tempCourse.addReview(review1);
					tempCourse.addReview(review2);
					tempCourse.addReview(review3);
					courseRepository.save(tempCourse);
					System.out.println("\nGetting Review Of Course: " + tempCourse.getReview());
					
				}
			}
			
			
			
		};

	}

}


