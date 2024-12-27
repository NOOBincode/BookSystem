package com.micro.BookSystem.entity.reservation;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class reservation {
    @NotNull
    private int reservation_id;
    @NotNull
    private int user_id;
    @NotNull
    private int book_id;
    @NotNull
    private Date reservation_date;
    @NotNull
    private Date return_date;

    public int getReservation_id() {
        return reservation_id;
    }
    public void setReservation_id(){
        this.reservation_id = reservation_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public Date getReservation_date() {
        return reservation_date;
    }
    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }
    public Date getReturn_date() {
        return return_date;
    }
    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
    @Override
    public String toString(){
        return "reservation{" +
                "reservation_id=" + reservation_id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", reservation_date=" + reservation_date +
                ", return_date=" + return_date +
                '}';
    }
}
