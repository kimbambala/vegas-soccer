package com.nickprincy.vegassoccer.dao;


import com.nickprincy.vegassoccer.model.RegisterUserDto;
import com.nickprincy.vegassoccer.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);
}
