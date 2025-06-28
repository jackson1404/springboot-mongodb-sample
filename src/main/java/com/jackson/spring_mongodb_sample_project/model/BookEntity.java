package com.jackson.spring_mongodb_sample_project.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookEntity {

    @Id
    private Long BookId;

    private String bookName;

    private String bookTitle;

    private String bookDescription;

    private Boolean isPublished;

}