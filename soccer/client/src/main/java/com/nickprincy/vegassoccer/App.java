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
			} else if (menuSelection == 2) {
				mondayGroups("Monday");
			}else if (menuSelection == 3) {
				tuesdayGroups("Tuesday");
			}else if (menuSelection == 4) {
				wednesdayGroups("Wednesday");
			}else if (menuSelection == 5) {
				thursdayGroups("Thursday");
			}else if (menuSelection == 6) {
				fridayGroups("Friday");
			}else if (menuSelection == 7) {
				saturdayGroups("Saturday");
			}else if (menuSelection == 8) {
				sundayGroups("Sunday");
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

	private List<Group> viewAllGroups(){
		List<Group> groupList = Arrays.asList(groupService.getGroups());
		return groupList;

	}

	private Group[] mondayGroups(String gameDay){
		Group[] groups = groupService.getGroupsByGameDay(gameDay);
		return groups;
	}

	private Group[] tuesdayGroups(String gameDay){
		Group[] groups = groupService.getGroupsByGameDay("Tuesday");
		return groups;
	}

	private Group[] wednesdayGroups(String gameDay){
		Group[] groups = groupService.getGroupsByGameDay("Wednesday");
		return groups;
	}

	private Group[] thursdayGroups(String gameDay){
		Group[] groups = groupService.getGroupsByGameDay("Thursday");
		return groups;
	}

	private Group[] fridayGroups(String gameDay){
		Group[] groups = groupService.getGroupsByGameDay("Friday");
		return groups;
	}

	private Group[] saturdayGroups(String gameDay){
		Group[] groups = groupService.getGroupsByGameDay("Saturday");
		return groups;
	}

	private Group[] sundayGroups(String gameDay){
		Group[] groups = groupService.getGroupsByGameDay("Sunday");
		return groups;
	}

	private void createGroup() {
		System.out.println("Please register your pickup group");
		//UserCredentials credentials = consoleService.promptForCredentials();
		Group group = consoleService.promptForGroupData();
		groupService.ceateGroup();
		System.out.println("Registration successful.");
			/*System.out.println("Registration successful. You can now login.");
		} else {
			consoleService.printErrorMessage();
		}*/

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
