package com.jackson.spring_mongodb_sample_project.controller;

import com.jackson.spring_mongodb_sample_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

}
