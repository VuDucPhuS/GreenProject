package com.bookstore.repositories;

import com.bookstore.entities.Courses;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRepository extends CrudRepository<Courses, Long> {
	
}
