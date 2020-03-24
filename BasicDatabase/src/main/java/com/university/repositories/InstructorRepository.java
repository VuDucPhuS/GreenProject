package com.university.repositories;

import org.springframework.data.repository.CrudRepository;

import com.university.entities.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {

}
