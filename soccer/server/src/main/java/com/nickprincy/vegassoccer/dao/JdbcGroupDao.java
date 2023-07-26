package com.nickprincy.vegassoccer.dao;

import com.nickprincy.vegassoccer.exception.DaoException;
import com.nickprincy.vegassoccer.model.Group;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcGroupDao implements GroupDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcGroupDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public Group getGroupById(int groupId) {
        Group group = null;
        String sql = "SELECT group_id, user_id, group_name, game_day, start_time, game_type, location, address, additional_info FROM groups WHERE group_id = ?";

        try{
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, groupId);
            if(result.next()){
                group = mapRowToGroup(result);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or Database", e);
        }

        return group;
    }

    @Override
    public List<Group> getGroups() {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT group_id, user_id, group_name, game_day, start_time, game_type, location, address, additional_info FROM groups";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()){
            Group group = mapRowToGroup(result);
            groupList.add(group);
        }

        return groupList;
    }

    @Override
    public Group getGroupByUserId(int userId) {
        Group group = null;

        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if(results.next()){
                group = mapRowToGroup(results);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server / database");
        }
        return  group;
    }


    @Override
    public Group createGroup(Group group) {
        Group newGroup = null;
        String sql = "INSERT INTO groups(user_id, group_name, game_day, start_time, game_type, location, address, additional_info) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?) RETURNING group_id";

        try{

            int newGroupId = jdbcTemplate.queryForObject(sql, int.class, group.getUserId(), group.getGroupName(), group.getGameDay(), group.getStartTime(),
                    group.getGameType(), group.getLocation(), group.getAddress(), group.getAdditionalInfo());
            newGroup = getGroupById(newGroupId);
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or Database", e);
        } catch (DataIntegrityViolationException e){
            throw  new DaoException("Data integrity violation", e);
        }

        return newGroup;
    }

    @Override
    public List<Group> getGroupsByMonday() {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT group_id, user_id, group_name, game_day, start_time, game_type, location, address, additional_info FROM groups WHERE game_day = 'Monday' ";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while (result.next()){
                Group group = mapRowToGroup(result);
                groupList.add(group);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or Database", e);
        } catch (DataIntegrityViolationException e){
            throw  new DaoException("Data integrity violation", e);
        }

        return groupList;
    }
    @Override
    public List<Group> getGroupsByTuesday() {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT group_id, user_id, group_name, game_day, start_time, game_type, location, address, additional_info FROM groups WHERE game_day = 'Tuesday' ";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while (result.next()){
                Group group = mapRowToGroup(result);
                groupList.add(group);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or Database", e);
        } catch (DataIntegrityViolationException e){
            throw  new DaoException("Data integrity violation", e);
        }

        return groupList;
    }

    @Override
    public List<Group> getGroupsByWednesday() {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT group_id, user_id, group_name, game_day, start_time, game_type, location, address, additional_info FROM groups WHERE game_day = 'Wednesday' ";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while (result.next()){
                Group group = mapRowToGroup(result);
                groupList.add(group);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or Database", e);
        } catch (DataIntegrityViolationException e){
            throw  new DaoException("Data integrity violation", e);
        }

        return groupList;
    }

    @Override
    public List<Group> getGroupsByThursday() {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT group_id, user_id, group_name, game_day, start_time, game_type, location, address, additional_info FROM groups WHERE game_day = 'Thursday' ";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while (result.next()){
                Group group = mapRowToGroup(result);
                groupList.add(group);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or Database", e);
        } catch (DataIntegrityViolationException e){
            throw  new DaoException("Data integrity violation", e);
        }

        return groupList;
    }

    @Override
    public List<Group> getGroupsByFriday() {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT group_id, user_id, group_name, game_day, start_time, game_type, location, address, additional_info FROM groups WHERE game_day = 'Friday' ";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while (result.next()){
                Group group = mapRowToGroup(result);
                groupList.add(group);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or Database", e);
        } catch (DataIntegrityViolationException e){
            throw  new DaoException("Data integrity violation", e);
        }

        return groupList;
    }

    @Override
    public List<Group> getGroupsBySaturday() {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT group_id, user_id, group_name, game_day, start_time, game_type, location, address, additional_info FROM groups WHERE game_day = 'Saturday' ";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while (result.next()){
                Group group = mapRowToGroup(result);
                groupList.add(group);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or Database", e);
        } catch (DataIntegrityViolationException e){
            throw  new DaoException("Data integrity violation", e);
        }

        return groupList;
    }

    @Override
    public List<Group> getGroupsBySunday() {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT group_id, user_id, group_name, game_day, start_time, game_type, location, address, additional_info FROM groups WHERE game_day = 'Sunday' ";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while (result.next()){
                Group group = mapRowToGroup(result);
                groupList.add(group);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or Database", e);
        } catch (DataIntegrityViolationException e){
            throw  new DaoException("Data integrity violation", e);
        }

        return groupList;
    }

    private Group mapRowToGroup(SqlRowSet rowSet){
        Group group = new Group();

        group.setGroupId(rowSet.getInt("group_id"));
        group.setUserId(rowSet.getInt("user_id"));
        group.setGroupName(rowSet.getString("group_name"));
        group.setGameDay(rowSet.getString("game_day"));
        group.setStartTime(rowSet.getString("start_time"));
        group.setGameType(rowSet.getString("game_type"));
        group.setLocation(rowSet.getString("location"));
        group.setAddress(rowSet.getString("address"));
        group.setAdditionalInfo(rowSet.getString("additional_info"));


        return  group;

    }
}
