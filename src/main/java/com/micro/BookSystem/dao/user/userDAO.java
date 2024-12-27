package com.micro.BookSystem.dao.user;

import com.micro.BookSystem.entity.user.user;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userDAO {

    private static final Logger logger = LoggerFactory.getLogger(userDAO.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public boolean deleteUser(int user_id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            boolean result = mapper.deleteUser(user_id);
            session.commit();
            logger.info("Deleted user with ID: {}", user_id);
            return result;
        } catch (Exception e) {
            logger.error("Error deleting user with ID: {}", user_id, e);
            return false;
        }
    }

    public boolean insertUser(user User) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            boolean result = mapper.insertUser(User);
            session.commit();
            logger.info("Inserted user: {}", User);
            return result;
        } catch (Exception e) {
            logger.error("Error inserting user: {}", User, e);
            return false;
        }
    }

    public user selectUserById(int user_id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            user result = mapper.selectUserById(user_id);
            logger.info("Selected user with ID: {}", user_id);
            return result;
        } catch (Exception e) {
            logger.error("Error selecting user with ID: {}", user_id, e);
            return null;
        }
    }

    public user selectUserByUsername(String username) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            user result = mapper.selectUserByUsername(username);
            logger.info("Selected user by username: {}", username);
            return result;
        } catch (Exception e) {
            logger.error("Error selecting user by username: {}", username, e);
            return null;
        }
    }

    public boolean updateUser(user User) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            boolean result = mapper.updateUser(User);
            session.commit();
            logger.info("Updated user: {}", User);
            return result;
        } catch (Exception e) {
            logger.error("Error updating user: {}", User, e);
            return false;
        }
    }

    public List<user> checkUserList() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<user> result = mapper.getUserList();
            logger.info("Checked user list");
            return result;
        } catch (Exception e) {
            logger.error("Error checking user list", e);
            return null;
        }
    }

    public boolean changePassword(String username, String password) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            boolean result = mapper.changePassword(username, password);
            session.commit();
            logger.info("Changed password for user: {}", username);
            return result;
        } catch (Exception e) {
            logger.error("Error changing password for user: {}", username, e);
            return false;
        }
    }

    public boolean checkPassword(String username, String password) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            boolean result = mapper.checkPassword(username, password);
            logger.info("Checked password for user: {}", username);
            return result;
        } catch (Exception e) {
            logger.error("Error checking password for user: {}", username, e);
            return false;
        }
    }
}