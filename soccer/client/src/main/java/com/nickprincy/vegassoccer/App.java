package com.nickprincy.vegassoccer;


import com.nickprincy.vegassoccer.model.Group;
import com.nickprincy.vegassoccer.model.UserCredentials;
import com.nickprincy.vegassoccer.services.AuthenticationService;
import com.nickprincy.vegassoccer.services.ConsoleService;
import com.nickprincy.vegassoccer.model.AuthenticatedUser;
import com.nickprincy.vegassoccer.services.GroupService;
import com.nickprincy.vegassoccer.services.UserService;

import java.util.Arrays;
import java.util.List;

public class App {

	private static final String API_BASE_URL = "http://localhost:8080/";

	private final ConsoleService consoleService = new ConsoleService();
	private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
	private final GroupService groupService = new GroupService();
	private final UserService userService = new UserService();

	private AuthenticatedUser currentUser;




	public static void main(String[] args) {
		App app = new App();
		app.run();
	}

	private void run() {
		consoleService.printGreeting();
		homePage();
		if (currentUser != null) {
			mainMenu();
		}
	}

	private void loginMenu(){
		int menuSelection = -1;
		while (menuSelection != 0 && currentUser == null) {
			consoleService.printLoginMenu();
			menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
			if (menuSelection == 1) {
				handleRegister();
			} else if (menuSelection == 2) {
				handleLogin();
			} else if (menuSelection != 0) {
				System.out.println("Invalid Selection");
				consoleService.pause();
			}
		}
	}

	private void homePage() {
		int menuSelection = -1;
		while (menuSelection != 0 && currentUser == null) {
			consoleService.printHomePage();
			menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
			if (menuSelection == 1) {
				viewAllGroups();
			}else if (menuSelection == 2) {
				mondayGroups();
			}else if (menuSelection == 3) {
				tuesdayGroups();
			}else if (menuSelection == 4) {
				wednesdayGroups();
			}else if (menuSelection == 5) {
				thursdayGroups();
			}else if (menuSelection == 6) {
				fridayGroups();
			}else if (menuSelection == 7) {
				saturdayGroups();
			}else if (menuSelection == 8) {
				sundayGroups();
			}else if (menuSelection == 9) {
				loginMenu();
			}else if (menuSelection != 0) {
				System.out.println("Invalid Selection");
				consoleService.pause();
			}
		}
	}

	private void handleRegister() {
		System.out.println("Please register a new user account");
		UserCredentials credentials = consoleService.promptForCredentials();
		if (authenticationService.register(credentials)) {
			System.out.println("Registration successful. You can now login.");
		} else {
			consoleService.printErrorMessage();
		}
	}

	/*private void handleLogin() {
		UserCredentials credentials = consoleService.promptForCredentials();
		currentUser = authenticationService.login(credentials);
		if (currentUser == null) {
			consoleService.printErrorMessage();
		}
	}*/

	private void handleLogin() {
		System.out.println("Enter your login information");
		UserCredentials credentials = consoleService.promptForCredentials();
		currentUser = authenticationService.login(credentials);
		if (currentUser != null) {
			groupService.setAuthToken(currentUser.getToken());
			userService.setAuthToken(currentUser.getToken());
			System.out.println("You are now logged in!");

		}else{
			consoleService.printErrorMessage();
		}
	}

	private void viewAllGroups(){
		List<Group> groupList = Arrays.asList(groupService.getGroups());
		//String groupName = groupList.get(0).getGroupName();
		System.out.println("*******************************************************");
		System.out.println("*                      All Groups                     *");
		for (Group group: groupList) {
			System.out.println("-------------------------------------------------------");
			System.out.println("Group Name: " + group.getGroupName());
			System.out.println("Day: " + group.getGameDay());
			System.out.println("Start Time: " + group.getStartTime());
			System.out.println("Game Type: " + group.getGameType());
			System.out.println("Location: " + group.getLocation());
			System.out.println("Address: " + group.getAddress());
			System.out.println("Additional info: " + group.getAdditionalInfo());
			System.out.println("-------------------------------------------------------");
		}
		System.out.println("********************************************************");



	}

	private void mondayGroups(){
		List<Group> groupList = Arrays.asList(groupService.getGroupsByMonday());

		System.out.println("*******************************************************");
		System.out.println("*                      Monday                         *");

		for (Group group : groupList) {

			System.out.println("-------------------------------------------------------");
			System.out.println("Group Name: " + group.getGroupName());
			System.out.println("Day: " + group.getGameDay());
			System.out.println("Start Time: " + group.getStartTime());
			System.out.println("Game Type: " + group.getGameType());
			System.out.println("Location: " + group.getLocation());
			System.out.println("Address: " + group.getAddress());
			System.out.println("Additional info: " + group.getAdditionalInfo());
			System.out.println("-------------------------------------------------------");
		}
		System.out.println("********************************************************");


	}

	private void tuesdayGroups(){
		List<Group> groupList = Arrays.asList(groupService.getGroupsByTuesday());

		System.out.println("*******************************************************");
		System.out.println("*                      Tuesday                        *");

		for (Group group : groupList) {

			System.out.println("-------------------------------------------------------");
			System.out.println("Group Name: " + group.getGroupName());
			System.out.println("Day: " + group.getGameDay());
			System.out.println("Start Time: " + group.getStartTime());
			System.out.println("Game Type: " + group.getGameType());
			System.out.println("Location: " + group.getLocation());
			System.out.println("Address: " + group.getAddress());
			System.out.println("Additional info: " + group.getAdditionalInfo());
			System.out.println("-------------------------------------------------------");
		}
		System.out.println("********************************************************");
	}

	private void wednesdayGroups(){
		List<Group> groupList = Arrays.asList(groupService.getGroupsByWednesday());

		System.out.println("*******************************************************");
		System.out.println("*                      Wednesday                      *");

		for (Group group : groupList) {

			System.out.println("-------------------------------------------------------");
			System.out.println("Group Name: " + group.getGroupName());
			System.out.println("Day: " + group.getGameDay());
			System.out.println("Start Time: " + group.getStartTime());
			System.out.println("Game Type: " + group.getGameType());
			System.out.println("Location: " + group.getLocation());
			System.out.println("Address: " + group.getAddress());
			System.out.println("Additional info: " + group.getAdditionalInfo());
			System.out.println("-------------------------------------------------------");
		}
		System.out.println("********************************************************");

	}

	private void thursdayGroups(){
		List<Group> groupList = Arrays.asList(groupService.getGroupsByThursday());

		System.out.println("*******************************************************");
		System.out.println("*                      Thursday                       *");

		for (Group group : groupList) {

			System.out.println("-------------------------------------------------------");
			System.out.println("Group Name: " + group.getGroupName());
			System.out.println("Day: " + group.getGameDay());
			System.out.println("Start Time: " + group.getStartTime());
			System.out.println("Game Type: " + group.getGameType());
			System.out.println("Location: " + group.getLocation());
			System.out.println("Address: " + group.getAddress());
			System.out.println("Additional info: " + group.getAdditionalInfo());
			System.out.println("-------------------------------------------------------");
		}
		System.out.println("********************************************************");
	}

	private void fridayGroups(){
		List<Group> groupList = Arrays.asList(groupService.getGroupsByFriday());

		System.out.println("*******************************************************");
		System.out.println("*                      Friday                         *");

		for (Group group : groupList) {

			System.out.println("-------------------------------------------------------");
			System.out.println("Group Name: " + group.getGroupName());
			System.out.println("Day: " + group.getGameDay());
			System.out.println("Start Time: " + group.getStartTime());
			System.out.println("Game Type: " + group.getGameType());
			System.out.println("Location: " + group.getLocation());
			System.out.println("Address: " + group.getAddress());
			System.out.println("Additional info: " + group.getAdditionalInfo());
			System.out.println("-------------------------------------------------------");
		}
		System.out.println("********************************************************");
	}

	private void saturdayGroups(){
		List<Group> groupList = Arrays.asList(groupService.getGroupsBySaturday());

		System.out.println("*******************************************************");
		System.out.println("*                      Saturday                       *");

		for (Group group : groupList) {

			System.out.println("-------------------------------------------------------");
			System.out.println("Group Name: " + group.getGroupName());
			System.out.println("Day: " + group.getGameDay());
			System.out.println("Start Time: " + group.getStartTime());
			System.out.println("Game Type: " + group.getGameType());
			System.out.println("Location: " + group.getLocation());
			System.out.println("Address: " + group.getAddress());
			System.out.println("Additional info: " + group.getAdditionalInfo());
			System.out.println("-------------------------------------------------------");
		}
		System.out.println("********************************************************");
	}

	private void sundayGroups(){
		List<Group> groupList = Arrays.asList(groupService.getGroupsBySunday());

		System.out.println("*******************************************************");
		System.out.println("*                      Sunday                         *");

		for (Group group : groupList) {

			System.out.println("-------------------------------------------------------");
			System.out.println("Group Name: " + group.getGroupName());
			System.out.println("Day: " + group.getGameDay());
			System.out.println("Start Time: " + group.getStartTime());
			System.out.println("Game Type: " + group.getGameType());
			System.out.println("Location: " + group.getLocation());
			System.out.println("Address: " + group.getAddress());
			System.out.println("Additional info: " + group.getAdditionalInfo());
			System.out.println("-------------------------------------------------------");
		}
		System.out.println("********************************************************");
	}


	private void createGroup() {

		Group newgroup = new Group();

		int userId = currentUser.getUser().getId();
		int groupId = newgroup.getGroupId();

		System.out.println("Please register your pickup group");

		String groupName = "";
		while (groupName.isBlank()) {
			groupName = consoleService.promptForString("What is your group name?: ");
		}
		newgroup.setGroupName(groupName);

		String gameDay = "";
		while (gameDay.isBlank()) {
			gameDay= consoleService.promptForString("On which day of the week you play?: ");
		}
		newgroup.setGameDay(gameDay);

		String startTime = "";
		while (startTime.isBlank()) {
			startTime = consoleService.promptForString("What time do you start playing?:  ");
		}
		newgroup.setStartTime(startTime);

		String gameType = "";
		while (gameType.isBlank()) {
			gameType = consoleService.promptForString("Does your group play Indoor or Outdoor?:  ");
		}
		newgroup.setGameType(gameType);


		String location = "";
		while (location.isBlank()) {
			location = consoleService.promptForString("Where does your group play:  ");
		}
		newgroup.setLocation(location);

		String address = "";
		while (address.isBlank()) {
			address = consoleService.promptForString("What is the address of the location you play?:  ");
		}
		newgroup.setAddress(address);

		String additionalInfo = "";
		additionalInfo = consoleService.promptForString("Any additional information?:  ");

		newgroup.setAdditionalInfo(additionalInfo);


		Group group = new Group(groupId, userId, groupName, gameDay, startTime, gameType, location, address, additionalInfo);
		groupService.createGroup(group);

	}



	private void mainMenu() {
		int menuSelection = -1;
		while (menuSelection != 0) {
			consoleService.printMainMenu();
			menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
			if (menuSelection == 1) {
				createGroup();
			} else if (menuSelection == 0) {
				continue;
			} else {
				System.out.println("Invalid Selection");
			}
			consoleService.pause();
		}
	}




}
