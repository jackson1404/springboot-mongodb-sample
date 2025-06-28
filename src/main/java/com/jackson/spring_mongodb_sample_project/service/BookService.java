package com.jackson.spring_mongodb_sample_project.service;

import com.jackson.spring_mongodb_sample_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
}
