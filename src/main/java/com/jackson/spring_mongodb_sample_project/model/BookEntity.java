package com.jackson.spring_mongodb_sample_project.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "books")
public class BookEntity {
}
