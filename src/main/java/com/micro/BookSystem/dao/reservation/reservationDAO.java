package com.micro.BookSystem.dao.reservation;

import com.micro.BookSystem.entity.reservation.reservation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class reservationDAO {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public boolean insertReservation(reservation reservation) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            reservationMapper mapper = session.getMapper(reservationMapper.class);
            boolean result = mapper.insertReservation(reservation);
            session.commit();
            return result;
        }
    }

    public boolean deleteReservation(int reservationId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            reservationMapper mapper = session.getMapper(reservationMapper.class);
            boolean result = mapper.deleteReservation(reservationId);
            session.commit();
            return result;
        }
    }

    public reservation selectReservationById(int reservationId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            reservationMapper mapper = session.getMapper(reservationMapper.class);
            return mapper.selectReservationById(reservationId);
        }
    }

    public List<reservation> selectReservationsByUserId(int userId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            reservationMapper mapper = session.getMapper(reservationMapper.class);
            return mapper.selectReservationsByUserId(userId);
        }
    }

    public List<reservation> selectReservationsByBookId(int bookId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            reservationMapper mapper = session.getMapper(reservationMapper.class);
            return mapper.selectReservationsByBookId(bookId);
        }
    }

    public List<reservation> selectAllReservations() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            reservationMapper mapper = session.getMapper(reservationMapper.class);
            return mapper.selectAllReservations();
        }
    }
    public boolean lockBookById(int bookId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            reservationMapper mapper = session.getMapper(reservationMapper.class);
            boolean result = mapper.lockBookById(bookId);
            session.commit();
            return result;
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean updateReservations(reservation reservation) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            reservationMapper mapper = session.getMapper(reservationMapper.class);
            boolean result = mapper.updateReservations(reservation);
            session.commit();
            return result;
        }
        catch (Exception e) {
            return false;
        }
    }
}
