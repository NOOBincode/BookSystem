package com.micro.BookSystem.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.micro.BookSystem.entity.user.user;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private com.micro.BookSystem.dao.user.userDAO userDAO;
    public boolean insertUser(user user) {
        return userDAO.insertUser(user);
    }
    public boolean deleteUser(int user_id) {
        return userDAO.deleteUser(user_id);
    }
    public user selectUserById(int user_id) {
        return userDAO.selectUserById(user_id);
    }
    public user selectUserByUsername(String username) {
        return userDAO.selectUserByUsername(username);
    }
    public boolean updateUser(user user) {
        return userDAO.updateUser(user);
    }
    public List<user> checkUserList() {
        return userDAO.checkUserList();
    }
    public boolean changePassword(String username, String password) {
        return userDAO.changePassword(username, password);
    }
    public boolean checkPassword(String username, String password) {
        return userDAO.checkPassword(username, password);
    }

}
