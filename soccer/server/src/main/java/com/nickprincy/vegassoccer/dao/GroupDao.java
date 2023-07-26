package com.nickprincy.vegassoccer.dao;

import com.nickprincy.vegassoccer.model.Group;

import java.util.List;

public interface GroupDao {
    Group createGroup(Group newGroup);

    Group getGroupById(int groupId);

    List<Group> getGroups();

    Group getGroupByUserId (int userId);

    List<Group> getGroupsByMonday();
    List<Group> getGroupsByTuesday();
    List<Group> getGroupsByWednesday();
    List<Group> getGroupsByThursday();
    List<Group> getGroupsByFriday();
    List<Group> getGroupsBySaturday();
    List<Group> getGroupsBySunday();
}
