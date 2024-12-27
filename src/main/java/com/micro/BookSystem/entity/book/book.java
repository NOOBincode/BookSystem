package com.micro.BookSystem.entity.book;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class book {

    private int book_id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    private String title;

    @NotNull(message = "Author cannot be null")
    @Size(min = 1, max = 100, message = "Author must be between 1 and 100 characters")
    private String author;

    @Size(max = 13, message = "ISBN must be up to 13 characters")
    private String isbn;

    private Date published_date;

    @NotNull(message = "Available copies cannot be null")
    private int available_copies;

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public void setAvailable_copies(Integer available_copies) {
        this.available_copies = available_copies;
    }

    public int getAvailable_copies() {
        return available_copies;
    }
}
