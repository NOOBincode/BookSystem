package com.micro.BookSystem.entity.user;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class user {
    @NotNull
    private int user_id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String email;
    private LocalDateTime create_at;

    public int getUser_id()
    {
        return user_id;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getEmail()
    {
        return email;
    }
    public LocalDateTime getCreate_at()
    {
        return create_at;
    }
    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setCreate_at(LocalDateTime create_at)
    {
        this.create_at = create_at;
    }
    @Override
    public String toString()
    {
        return "user_id:"+user_id+" username:"+username+" password:"+password+" email:"+email+" create_at:"+create_at;
    }
}
