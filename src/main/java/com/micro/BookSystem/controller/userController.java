package com.micro.BookSystem.controller;

import com.micro.BookSystem.entity.user.user;
import com.micro.BookSystem.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@Api(tags = "用户管理")
@RequestMapping("/user")
public class userController {

    private static final Logger logger = Logger.getLogger(userController.class.getName());

    @Autowired
    private UserService userService;

    @ApiOperation("删除用户")
    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable int user_id) {
        try {
            boolean isDeleted = userService.deleteUser(user_id);
            if (isDeleted) {
                return ResponseEntity.ok("用户删除成功");
            } else {
                return ResponseEntity.badRequest().body("用户删除失败");
            }
        } catch (PersistenceException e) {
            logger.log(Level.SEVERE, "Error deleting user with id: " + user_id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器错误");
        }
    }

    @ApiOperation("添加用户")
    @PostMapping("/add")
    public ResponseEntity<String> insertUser(@RequestBody user User) {
        try {
            boolean isInserted = userService.insertUser(User);
            if (isInserted) {
                return ResponseEntity.ok("用户添加成功");
            } else {
                return ResponseEntity.badRequest().body("用户添加失败");
            }
        } catch (PersistenceException e) {
            logger.log(Level.SEVERE, "Error inserting user: " + User, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器错误");
        }
    }

    @ApiOperation("根据用户ID查询用户")
    @GetMapping("/{user_id}")
    public ResponseEntity<user> selectUserById(@PathVariable int user_id) {
        try {
            user User = userService.selectUserById(user_id);
            if (User != null) {
                return ResponseEntity.ok(User);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (PersistenceException e) {
            logger.log(Level.SEVERE, "Error selecting user by id: " + user_id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ApiOperation("根据用户名查询用户")
    @GetMapping("/username/{username}")
    public ResponseEntity<user> selectUserByUsername(@PathVariable String username) {
        try {
            user foundUser = userService.selectUserByUsername(username);
            if (foundUser != null) {
                return ResponseEntity.ok(foundUser);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (PersistenceException e) {
            logger.log(Level.SEVERE, "Error selecting user by username: " + username, e);
            logger.info("Received username: " + username);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @ApiOperation("更新用户")
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody user User) {
        try {
            boolean isUpdated = userService.updateUser(User);
            if (isUpdated) {
                return ResponseEntity.ok("用户更新成功");
            } else {
                return ResponseEntity.badRequest().body("用户更新失败");
            }
        } catch (PersistenceException e) {
            logger.log(Level.SEVERE, "Error updating user: " + User, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器错误");
        }
    }

    @ApiOperation("修改密码")
    @PutMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestParam String username, @RequestParam String password) {
        try {
            boolean isChanged = userService.changePassword(username, password);
            if (isChanged) {
                return ResponseEntity.ok("密码修改成功");
            } else {
                return ResponseEntity.badRequest().body("密码修改失败");
            }
        } catch (PersistenceException e) {
            logger.log(Level.SEVERE, "Error changing password for user: " + username, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器错误");
        }
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        try {
            boolean isValidUser = userService.checkPassword(username, password);
            if (isValidUser) {
                return ResponseEntity.ok("登录成功");
            } else {
                logger.info("Invalid user credentials: " + username);
                logger.info("Received password: " + password);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during login for user: " + username, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器错误");
        }
    }

    @ApiOperation("检查用户列表")
    @GetMapping("/checkUserList")
    public ResponseEntity<List<user>> checkUserList() {
        try {
            List<user> userList = userService.checkUserList();
            return ResponseEntity.ok(userList);
        } catch (PersistenceException e) {
            logger.log(Level.SEVERE, "Error getting user list", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ApiOperation("登出")
    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("用户已登出");
    }
}