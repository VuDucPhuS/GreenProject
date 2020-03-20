package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.entities.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {

}
