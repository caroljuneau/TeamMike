import java.util.Scanner;
import java.util.ArrayList;

public class HousingUI {

	private Scanner keyboard;
	private HousingApplication application;
	private Account user;
	
	private static final String WELCOME = "Welcome!";
	private static final String GOODBYE = "Goodbye!";
	private static final String LOGOUT = "Logging out...";
	private static final String INVALID = "Invalid command";
	
	private String[] mainMenuOptions = 
		{
			"Main Menu: ", 
			"Create account", //1
			"Log in with account", //2
			"Continue as guest", //3
			"Exit" //4
		};
	private String[] createAccountOptions = 
		{
			"Create Account Menu: ",
			"Create student account", //1
			"Create property manager account", //2
			"Go back" //3
		};
	private String[] studentOptions = 
		{
			"Student Menu: ",
			"Browse properties", //1
			"View my favorite properties", //2
			"View my signed leases", //3
			"Rate/review a property", //4
			"Rate/review a property manager", //5
			"Manage account", //6
			"Log out" //7
		};
	private String[] propertyManagerOptions = 
		{
			"Property Manager Menu: ",
			"Manage my properties", //1
			"View my properties", //2
			"View my signed leases", //3
			"Rate/review a student", //4
			"Manage account", //5
			"Log out" //6
		};
	private String[] guestOptions = 
		{
			"Guest Menu: ",
			"Browse properties", //1
			"Go back" //2
		};
	private String[] browsePropertiesOptions = 
		{
			"Browse Properties Menu: ",
			"View all properties", //1
			"Search by keyword", //2
			"Sort by distance", //3
			"Sort by price", //4
			"Sort by number of reviews", //5
			"Filter by amenities", //6
			"Filter by price range", //7
			"Go back", //8
		};
	private String[] managePropertiesOptions = 
		{
			"Manage Properties Menu: ",
			"Add a new property", //1
			"Edit an existing property", //2
			"Delete an existing property", //3
			"Create a lease", //4
			"Go back" //5
		};
	private String[] tryAgainOptions = 
		{
			"Would you like to try again?",
			"Yes", //1
			"No, go back" //2
		};
	
	public HousingUI() {
		keyboard = new Scanner(System.in);
		application = new HousingApplication();
	}
	
	public void run() {
		System.out.println(WELCOME);
      //Data Loading test for students, delete whenever
// 		ArrayList<Student> students = dataLoader.loadStudent();
//		for(Student s: students) {
//			System.out.println(s.getUsername()+" " +s.getPassword()+" "+s.getFirstName()+ " "+s.getLastName());
//		}

		
		while(true) {
			displayMenu(mainMenuOptions);
			int userCommand = getUserCommand(mainMenuOptions.length);
			switch(userCommand) {
			case 1:
				displayMenu(createAccountOptions);
				userCommand = getUserCommand(createAccountOptions.length);
				switch(userCommand) {
				case 1:
					createAccount(AccountType.STUDENT);
					studentLoop();
					break;
				case 2:
					createAccount(AccountType.PROPERTYMANAGER);
					propertyManagerLoop();
					break;
				case 3:
					break;
				default:
					System.out.println(INVALID);
					break;
				}
				break;
			case 2:
				logIn();
				switch(user.getAccountType()) {
				case STUDENT:
					studentLoop();
					break;
				case PROPERTYMANAGER:
					propertyManagerLoop();
					break;
				default:
					break;
				}
				break;
			case 3:
				guestLoop();
				break;
			case 4:
				System.out.println(GOODBYE);
				break;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}
	
	// prints the menu, where element 0 is the title and elements 1-menu.length are the items
	private void displayMenu(String[] menu) {
		System.out.println(menu[0]);
		for(int i = 1; i < menu.length; i++) {
			System.out.println(i + ". " + menu[i]);
		}
	}
	
	// parses the user input into an integer, returns that int if its valid, returns -1 if its not valid
	private int getUserCommand(int numCommands) {
		System.out.println("What would you like to do?");
		String input = keyboard.nextLine();
		int command = Integer.parseInt(input);
		if(command >= 1 && command <= numCommands - 1) {
			return command;
		}
		return -1;
	}
	
	private void logIn() {
		user = null;
		while(user == null)
		{
			System.out.println("Please enter your username.");
			String username = keyboard.nextLine();
			System.out.println("Please enter your password.");
			String password = keyboard.nextLine();
			user = application.logIn(username, password);
			if(user == null) {
				System.out.println("Incorrect username or password.");
				int userCommand = getUserCommand(tryAgainOptions.length);
				switch(userCommand) {
				case 1:
					break;
				case 2:
					return;
				default:
					System.out.println("INVALID");
					break;
				}
			}
		}
	}
	
	private void createAccount(AccountType type) {
		boolean goBack = false;
		while(!goBack) {
			System.out.println("Please enter a username.");
			String username = keyboard.nextLine();
			if(application.usernameInList(type, username)) {
				System.out.println("Username is already taken.");
				int userCommand = getUserCommand(tryAgainOptions.length);
				switch(userCommand) {
				case 1:
					break;
				case 2:
					return;
				default:
					System.out.println("INVALID");
					break;
				}
				continue;
			}
			System.out.println("Please enter a password.");
			String password = keyboard.nextLine();
			System.out.println("Please enter your first name.");
			String firstname = keyboard.nextLine();
			System.out.println("Please enter your last name.");
			String lastname = keyboard.nextLine();
			System.out.println("Please enter your email address.");
			String emailAddress = keyboard.nextLine();
			System.out.println("pleae enter your phone number.");
			String phone = keyboard.nextLine();
			if(type == AccountType.STUDENT) {
				System.out.println("Please enter your student id.");
				String studentID = keyboard.nextLine();
				application.createStudentAccount(username, password, firstname, lastname, emailAddress, phone, studentID);
			}
			else if(type == AccountType.PROPERTYMANAGER) {
				application.createPropertyManagerAccount(username, password, firstname, lastname, emailAddress, phone);
			}
			return;
		}
	}
	
	private void studentLoop() {
		boolean logOut = false;
		while(!logOut) {
			displayMenu(studentOptions);
			int userCommand = getUserCommand(studentOptions.length);
			switch(userCommand) {
			case 1:
				browsePropertiesLoop();
				break;
			case 2:
				viewFavProperties();
				break;
			case 3:
				viewSignedLeases();
				break;
			case 4:
				reviewProperty();
				break;
			case 5:
				reviewPropertyManager();
				break;
			case 6:
				manageAccount();
				break;
			case 7:
				System.out.println(LOGOUT);
				logOut = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}

	private void propertyManagerLoop() {
		boolean logOut = false;
		while(!logOut) {
			displayMenu(propertyManagerOptions);
			int userCommand = getUserCommand(propertyManagerOptions.length);
			switch(userCommand) {
			case 1:
				manageProperties();
				break;
			case 2:
				viewMyProperties();
				break;
			case 3:
				viewSignedLeases();
				break;
			case 4:
				reviewStudent();
				break;
			case 5:
				manageAccount();
				break;
			case 6:
				System.out.println(LOGOUT);
				logOut = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}
	
	private void guestLoop() {
		boolean goBack = false;
		while(!goBack) {
			displayMenu(guestOptions);
			int userCommand = getUserCommand(guestOptions.length);
			switch(userCommand) {
			case 1:
				browsePropertiesLoop();
				break;
			case 2:
				goBack = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}
	
	private void browsePropertiesLoop() {
		boolean goBack = false;
		while(!goBack) {
			displayMenu(browsePropertiesOptions);
			int userCommand = getUserCommand(browsePropertiesOptions.length);
			switch(userCommand) {
			//TODO rest of cases
			case 8:
				goBack = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}
	
	private void viewFavProperties() {
		
	}
	
	private void viewSignedLeases() {
		
	}
	
	private void reviewProperty() {
		
	}
	
	private void reviewPropertyManager() {
		
	}
	
	private void manageAccount() {
		
	}
	
	private void manageProperties() {
		
	}
	
	private void viewMyProperties() {
		
	}
	
	private void reviewStudent() {
		
	}
	
	public static void main(String[] args) {
		HousingUI driver = new HousingUI();
		driver.run();
	}
}
