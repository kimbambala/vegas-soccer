package com.nickprincy.vegassoccer.controller;

import com.nickprincy.vegassoccer.dao.UserDao;
import com.nickprincy.vegassoccer.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/users")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private final UserDao userDao;


    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> listUsers() {

        return userDao.getUsers();
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable int userId) {

        User user = userDao.getUserById(userId);
        if ( user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found");
        } else {
            return user;
        }

    }


}
