package com.nickprincy.vegassoccer.services;

import com.nickprincy.util.BasicLogger;
import com.nickprincy.vegassoccer.model.Group;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class GroupService {
    private final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Group getGroupById(int groupId){
        Group group = new Group();

        try{
            ResponseEntity<Group> response = restTemplate.exchange(API_BASE_URL + "groups/" + groupId, HttpMethod.GET, makeAuthEntity(), Group.class);
            group = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return group;
    }

    public Group[] getGroups(){
        Group[] groups = new Group[0];

        try{
            ResponseEntity<Group[]> response = restTemplate.exchange(API_BASE_URL + "groups/", HttpMethod.GET, makeAuthEntity(), Group[].class);
            groups = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return groups;
    }

    public Group getGroupsByUserId(int userId){
        Group group = new Group();

        try{
            ResponseEntity<Group> response = restTemplate.exchange(API_BASE_URL + "groups/" + "users/" + userId, HttpMethod.GET, makeAuthEntity(), Group.class);
            group = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return group;
    }
    public Group ceateGroup(){
        Group newGroup = new Group();

        try{
            ResponseEntity<Group> response = restTemplate.exchange(API_BASE_URL + "groups/", HttpMethod.POST, makeAuthEntity(), Group.class);
            newGroup = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return newGroup;
    }

    public Group[] getGroupsByGameDay(String gameDay){
        Group[] groups = new Group[0];

        try{
            ResponseEntity<Group[]> response = restTemplate.exchange(API_BASE_URL + "groups/" + "day/" + gameDay, HttpMethod.GET, makeAuthEntity(), Group[].class);
            groups = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return groups;

    }



    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }
}
