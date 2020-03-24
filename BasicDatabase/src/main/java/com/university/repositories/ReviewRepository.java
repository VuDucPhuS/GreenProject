package com.university.repositories;

import org.springframework.data.repository.CrudRepository;

import com.university.entities.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
