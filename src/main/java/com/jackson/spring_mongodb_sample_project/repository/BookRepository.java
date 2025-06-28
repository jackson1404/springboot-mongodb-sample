package com.jackson.spring_mongodb_sample_project.repository;

import com.jackson.spring_mongodb_sample_project.model.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookEntity, String> {
}