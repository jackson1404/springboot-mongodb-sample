package com.jackson.spring_mongodb_sample_project.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookRequestDto {

    private String bookName;

    private String bookTitle;

    private String bookDescription;

    private Boolean isPublished;
}
