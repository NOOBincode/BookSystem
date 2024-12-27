package com.micro.BookSystem.service.reservation;

import com.micro.BookSystem.dao.book.BookMapper;
import com.micro.BookSystem.dao.reservation.reservationDAO;
import com.micro.BookSystem.entity.book.book;
import com.micro.BookSystem.entity.reservation.reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private reservationDAO reservationDAO;

    @Autowired
    private BookMapper bookMapper;

    @Transactional
    public boolean insertReservation(reservation reservation) {
        // 检查是否已经存在预约记录
        List<reservation> existingReservations = reservationDAO.selectReservationsByBookId(reservation.getBook_id());
        if (existingReservations != null && !existingReservations.isEmpty()) {
            System.out.println("Book is already reserved");
            return false;
        }

        // 插入预约记录
        return reservationDAO.insertReservation(reservation);
    }

    public boolean deleteReservation(int reservationId) {
        return reservationDAO.deleteReservation(reservationId);
    }

    public reservation selectReservationById(int reservationId) {
        return reservationDAO.selectReservationById(reservationId);
    }

    public List<reservation> selectReservationsByUserId(int userId) {
        return reservationDAO.selectReservationsByUserId(userId);
    }

    public List<reservation> selectReservationsByBookId(int bookId) {
        return reservationDAO.selectReservationsByBookId(bookId);
    }

    public List<reservation> selectAllReservations() {
        return reservationDAO.selectAllReservations();
    }

    public boolean lockBookById(int bookId) {
        return reservationDAO.lockBookById(bookId);
    }

    public boolean updateReservation(reservation reservation) {
        return reservationDAO.updateReservations(reservation);
    }

    public List<reservation> selectReservationsByUserIdAndBookId(int userId, int bookId) {
        // 同时根据用户ID和书籍ID筛选预约记录
        return reservationDAO.selectReservationsByUserId(userId).stream()
                .filter(reservation -> reservation.getBook_id() == bookId)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean returnBook(int reservationId) {
        // 获取预约信息
        reservation reservation = reservationDAO.selectReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reservation not found for ID: " + reservationId);
            return false;
        }

        // 获取书籍信息
        book book = bookMapper.selectBookById(reservation.getBook_id());
        if (book == null) {
            System.out.println("Book not found for ID: " + reservation.getBook_id());
            return false;
        }

        // 增加书籍库存
        book.setAvailable_copies(book.getAvailable_copies() + 1);
        bookMapper.updateBook(book);

        // 删除预约记录
        return reservationDAO.deleteReservation(reservationId);
    }
}
