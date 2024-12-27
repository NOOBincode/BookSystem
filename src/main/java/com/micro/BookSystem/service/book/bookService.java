package com.micro.BookSystem.service.book;

import com.micro.BookSystem.entity.book.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class bookService {
    @Autowired
    private com.micro.BookSystem.dao.book.bookDAO bookDAO;

    public boolean insertBook(@Valid book book) {
        return bookDAO.insertBook(book);
    }
    public boolean deleteBook(int book_id) {
        return bookDAO.deleteBook(book_id);
    }
    public boolean updateBook(book book) {
        return bookDAO.updateBook(book);
    }
    public book selectBookById(int book_id) {
        return bookDAO.selectBookById(book_id);
    }
    public book selectBookByTitle(String book_name) {
        return bookDAO.selectBookByTitle(book_name);
    }
    public List<book> checkBookList() {
        return bookDAO.checkBookList();
    }
    public List<book> selectBooksByConditions(String author, String publishDate) {
        return bookDAO.selectBooksByConditions(author, publishDate);
    }
    public boolean deleteBooksByIds(List<Integer> bookIds) {
        return bookDAO.deleteBooksByIds(bookIds);
    }
    public int countBooks() {
        return bookDAO.countBooks();
    }
}
