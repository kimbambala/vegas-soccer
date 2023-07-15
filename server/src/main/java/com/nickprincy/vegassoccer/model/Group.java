package com.nickprincy.vegassoccer.model;

public class Group {
    private int groupId;
    private int userId;
    private String groupName;
    private String gameDay;
    private String startTime;
    private String gameType;
    private String location;
    private String address;
    private String additionalInfo;

    public Group(int groupId, int userId, String groupName, String gameDay, String startTime, String gameType, String location, String address, String additionalInfo) {
        this.groupId = groupId;
        this.userId = userId;
        this.groupName = groupName;
        this.gameDay = gameDay;
        this.startTime = startTime;
        this.gameType = gameType;
        this.location = location;
        this.address = address;
        this.additionalInfo = additionalInfo;
    }

    public Group() {

    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGameDay() {
        return gameDay;
    }

    public void setGameDay(String gameDay) {
        this.gameDay = gameDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", userId=" + userId +
                ", groupName='" + groupName + '\'' +
                ", gameDay='" + gameDay + '\'' +
                ", startTime='" + startTime + '\'' +
                ", gameType='" + gameType + '\'' +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
