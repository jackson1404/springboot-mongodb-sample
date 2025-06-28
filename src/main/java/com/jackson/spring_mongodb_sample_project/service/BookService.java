package com.jackson.spring_mongodb_sample_project.service;

import com.jackson.spring_mongodb_sample_project.dto.BookRequestDto;
import com.jackson.spring_mongodb_sample_project.model.BookEntity;
import com.jackson.spring_mongodb_sample_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getAllBooks(){
        return bookRepository.findAll();
    }

    public void createBook(BookRequestDto bookRequestDto) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(bookRequestDto.getBookName());
        bookEntity.setBookTitle(bookRequestDto.getBookTitle());
        bookEntity.setBookDescription(bookRequestDto.getBookDescription());
        bookEntity.setIsPublished(bookRequestDto.getIsPublished());

        bookRepository.save(bookEntity);
    }
}
