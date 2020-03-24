package com.university.repositories;

import org.springframework.data.repository.CrudRepository;

import com.university.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
