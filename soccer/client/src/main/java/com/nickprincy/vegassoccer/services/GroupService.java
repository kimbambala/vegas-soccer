package com.nickprincy.vegassoccer.services;

import com.nickprincy.util.BasicLogger;
import com.nickprincy.vegassoccer.model.Group;
import org.springframework.http.*;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class GroupService {
    private final String API_BASE_URL = "http://localhost:9000/";
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
    public Group createGroup(Group newGroup){
        HttpEntity<Group> entity = makeGroupEntity(newGroup);

        Group returnedGroup = null;

        try{
            returnedGroup = restTemplate.exchange(API_BASE_URL + "groups", HttpMethod.POST, entity, Group.class).getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return returnedGroup;
    }

    public Group[] getGroupsByMonday(){
        Group[] groups = new Group[0];

        try{
            ResponseEntity<Group[]> response = restTemplate.exchange(API_BASE_URL + "groups/monday" , HttpMethod.GET, makeAuthEntity(), Group[].class);
            groups = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return groups;

    }

    public Group[] getGroupsByTuesday(){
        Group[] groups = new Group[0];

        try{
            ResponseEntity<Group[]> response = restTemplate.exchange(API_BASE_URL + "groups/tuesday" , HttpMethod.GET, makeAuthEntity(), Group[].class);
            groups = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return groups;

    }

    public Group[] getGroupsByWednesday(){
        Group[] groups = new Group[0];

        try{
            ResponseEntity<Group[]> response = restTemplate.exchange(API_BASE_URL + "groups/wednesday" , HttpMethod.GET, makeAuthEntity(), Group[].class);
            groups = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return groups;

    }

    public Group[] getGroupsByThursday(){
        Group[] groups = new Group[0];

        try{
            ResponseEntity<Group[]> response = restTemplate.exchange(API_BASE_URL + "groups/thursday" , HttpMethod.GET, makeAuthEntity(), Group[].class);
            groups = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return groups;

    }

    public Group[] getGroupsByFriday(){
        Group[] groups = new Group[0];

        try{
            ResponseEntity<Group[]> response = restTemplate.exchange(API_BASE_URL + "groups/friday" , HttpMethod.GET, makeAuthEntity(), Group[].class);
            groups = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return groups;

    }

    public Group[] getGroupsBySaturday(){
        Group[] groups = new Group[0];

        try{
            ResponseEntity<Group[]> response = restTemplate.exchange(API_BASE_URL + "groups/saturday" , HttpMethod.GET, makeAuthEntity(), Group[].class);
            groups = response.getBody();
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return groups;

    }

    public Group[] getGroupsBySunday(){
        Group[] groups = new Group[0];

        try{
            ResponseEntity<Group[]> response = restTemplate.exchange(API_BASE_URL + "groups/sunday" , HttpMethod.GET, makeAuthEntity(), Group[].class);
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

    private HttpEntity<Group> makeGroupEntity(Group group) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(group, headers);
    }


}
