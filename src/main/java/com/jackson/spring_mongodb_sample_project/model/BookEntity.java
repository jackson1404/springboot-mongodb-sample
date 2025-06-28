package com.jackson.spring_mongodb_sample_project.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookEntity {

    @Id
    private String bookId;

    private String bookName;

    private String bookTitle;

    private String bookDescription;

    private Boolean isPublished;

}