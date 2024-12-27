package com.micro.BookSystem.dao.book;

import com.micro.BookSystem.entity.book.book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookMapper {
    boolean deleteBook(int book_id);
    boolean insertBook(book book);
    book selectBookById(int book_id);
    book selectBookByTitle(String book_name);
    boolean updateBook(book book);
    List<book> checkBookList();
    List<book> selectBooksByConditions(String author, String publishDate);
    boolean deleteBooksByIds(List<Integer> bookIds);
    int countBooks();
    boolean lockBookById(int bookId);
}
