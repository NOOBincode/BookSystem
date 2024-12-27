package com.micro.BookSystem.dao.reservation;

import com.micro.BookSystem.entity.reservation.reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface reservationMapper {
    boolean insertReservation(reservation reservation);
    boolean deleteReservation(int reservationId);
    reservation selectReservationById(int reservationId);
    List<reservation> selectReservationsByUserId(int userId);
    List<reservation> selectReservationsByBookId(int bookId);
    List<reservation> selectAllReservations();
    boolean lockBookById(int bookId);
    boolean updateReservations(reservation reservation);
}
