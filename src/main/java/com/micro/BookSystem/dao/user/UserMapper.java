package com.micro.BookSystem.dao.user;
import com.micro.BookSystem.entity.user.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    user selectUserById(int user_id);
    user selectUserByUsername(String username);
    boolean insertUser(user user);
    boolean updateUser(user user);
    boolean deleteUser(int user_id);
    List<user> getUserList();
    boolean changePassword(String username, String password);
    boolean checkPassword(String username, String password);
}

