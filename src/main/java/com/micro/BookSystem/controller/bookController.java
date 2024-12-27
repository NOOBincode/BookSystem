package com.micro.BookSystem.controller;

import com.micro.BookSystem.entity.book.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@Validated
public class bookController {

    @Autowired
    private com.micro.BookSystem.service.book.bookService bookService;

    @PostMapping
    public ResponseEntity<Boolean> insertBook(@Valid @RequestBody book book) {
        boolean result = bookService.insertBook(book);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable int book_id) {
        boolean result = bookService.deleteBook(book_id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<book> selectBookById(@PathVariable int book_id) {
        book result = bookService.selectBookById(book_id);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/title/{book_name}")
    public ResponseEntity<book> selectBookByTitle(@PathVariable String book_name) {
        book result = bookService.selectBookByTitle(book_name);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Boolean> updateBook(@Valid @RequestBody book book) {
        boolean result = bookService.updateBook(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<book>> checkBookList() {
        List<book> result = bookService.checkBookList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<book>> selectBooksByConditions(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String publishDate) {
        List<book> result = bookService.selectBooksByConditions(author, publishDate);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/ids")
    public ResponseEntity<Boolean> deleteBooksByIds(@RequestBody List<Integer> bookIds) {
        boolean result = bookService.deleteBooksByIds(bookIds);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> countBooks() {
        int result = bookService.countBooks();
        return ResponseEntity.ok(result);
    }
}