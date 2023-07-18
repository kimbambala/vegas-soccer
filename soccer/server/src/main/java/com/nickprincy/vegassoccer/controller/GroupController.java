package com.nickprincy.vegassoccer.controller;

import com.nickprincy.vegassoccer.dao.GroupDao;
import com.nickprincy.vegassoccer.exception.DaoException;
import com.nickprincy.vegassoccer.model.Group;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/groups")
public class GroupController{


    private final GroupDao groupDao;


    public GroupController(GroupDao groupDao) {
        this.groupDao = groupDao;
    }



    @GetMapping("/{groupId}")
    public Group getGroupById(@PathVariable int groupId) {
        Group group = groupDao.getGroupById(groupId);

        if(group == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No group matches this group Id");
        }else{
            return group;
        }

    }

   @GetMapping
    public List<Group> getGroups( ){
        List<Group> groupList = groupDao.getGroups();

        if (groupList == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No groups");
        }else{
            return groupList;
        }

    }

    @GetMapping("/users/{userId}")
    public Group getGroupByUserId(@PathVariable int userId){
        Group group = groupDao.getGroupByUserId(userId);
        if (group == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No group matches this user Id");
        }else{
            return group;
        }

    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroup(@RequestBody Group newGroup){
        try {
            Group group = groupDao.createGroup(newGroup);
            if (group == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Group registration failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Group registration failed.");
        }

    }


    @GetMapping("/day/{gameDay}")
    public List<Group> getGroupsByGameDay(@PathVariable String gameDay){
            List<Group> groupGameDay = groupDao.getGroupsByGameDay(gameDay);
            if (groupGameDay == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no pickup games for this day.");
            }else {
                return groupGameDay;
            }


    }


}