package com.nickprincy.vegassoccer.dao;


import com.nickprincy.vegassoccer.model.RegisterUserDto;
import com.nickprincy.vegassoccer.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
