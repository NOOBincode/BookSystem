package com.micro.BookSystem.dao.book;

import com.micro.BookSystem.entity.book.book;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class bookDAO {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public boolean deleteBook(int book_id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            boolean result = mapper.deleteBook(book_id);
            session.commit();
            return result;
        }
    }

    public boolean insertBook(book book) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            boolean result = mapper.insertBook(book);
            session.commit();
            return result;
        }
    }

    public book selectBookById(int book_id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.selectBookById(book_id);
        }
    }

    public book selectBookByTitle(String book_name) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.selectBookByTitle(book_name);
        }
    }

    public boolean updateBook(book book) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            boolean result = mapper.updateBook(book);
            session.commit();
            return result;
        }
    }

    public List<book> checkBookList() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.checkBookList();
        }
    }

    public List<book> selectBooksByConditions(String author, String publishDate) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.selectBooksByConditions(author, publishDate);
        }
    }

    public boolean deleteBooksByIds(List<Integer> bookIds) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            boolean result = mapper.deleteBooksByIds(bookIds);
            session.commit();
            return result;
        }
    }

    public int countBooks() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.countBooks();
        }
    }

    public boolean lockBookById(int bookId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            boolean result = mapper.lockBookById(bookId);
            session.commit();
            return result;
        }
    }

}
