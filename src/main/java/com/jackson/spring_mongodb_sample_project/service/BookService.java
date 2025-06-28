package com.jackson.spring_mongodb_sample_project.service;

import com.jackson.spring_mongodb_sample_project.dto.BookRequestDto;
import com.jackson.spring_mongodb_sample_project.model.BookEntity;
import com.jackson.spring_mongodb_sample_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

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

        System.out.println("Book entity" + bookEntity.getBookName());
        bookRepository.save(bookEntity);
    }

    public void updateBook(String bookId, BookRequestDto bookRequestDto) throws ClassNotFoundException {

        Optional<BookEntity> book = bookRepository.findById(bookId);

        if (book.isPresent()){
            BookEntity bookEntity = book.get();
            bookEntity.setBookName(bookRequestDto.getBookName());
            bookEntity.setBookTitle(bookRequestDto.getBookTitle());
            bookEntity.setBookDescription(bookRequestDto.getBookDescription());
            bookEntity.setIsPublished(bookRequestDto.getIsPublished());
            bookRepository.save(bookEntity);
        } else {
            throw new ClassNotFoundException("Book is not found with this id: " + bookId);
        }
    }

    public void deleteBook(String bookId) throws ClassNotFoundException {

        Optional<BookEntity> book = bookRepository.findById(bookId);

        if (book.isPresent()){
            bookRepository.deleteById(bookId);
        } else {
            throw new ClassNotFoundException("Book is not found with this id: " + bookId);
        }

    }
}
