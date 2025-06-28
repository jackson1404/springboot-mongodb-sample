package com.jackson.spring_mongodb_sample_project.controller;

import com.jackson.spring_mongodb_sample_project.dto.BookRequestDto;
import com.jackson.spring_mongodb_sample_project.model.BookEntity;
import com.jackson.spring_mongodb_sample_project.service.BookService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getAllBooks")
    public ResponseEntity<?> getAllBooks(){

        List<BookEntity> books = bookService.getAllBooks();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/addBooks")
    public ResponseEntity<String> createBook(@RequestBody BookRequestDto bookRequestDto){

        try {
            bookService.createBook(bookRequestDto);

            return ResponseEntity.status(HttpStatus.OK).body("Book Added Successfully");
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred when creating the book");
        }

    }

    @PutMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestParam("bookId") String bookId, @RequestBody BookRequestDto bookRequestDto){

        try {
            bookService.updateBook(bookId, bookRequestDto);

            return ResponseEntity.status(HttpStatus.OK).body("Book Updated Successfully");
        } catch (ClassNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam("bookId") String bookId){

        try {
            bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
        } catch (ClassNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }


}
