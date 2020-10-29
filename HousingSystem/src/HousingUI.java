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
			"Sign lease", //3
			"View my signed leases", //4
			"Rate/review a property", //5
			"Rate/review a property manager", //6
			"Log out" //7
		};
	private String[] propertyManagerOptions = 
		{
			"Property Manager Menu: ",
			"Manage my properties", //1
			"View my properties", //2
			"Sign lease", //3
			"View my signed leases", //4
			"Rate/review a student", //5
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
				// TODO check when we have finalized which methods are going to be implemented
			"Browse Properties Menu: ",
			"View all properties", //1
			"Search by keyword", //2
			"Sort by price", //3
			"Sort by number of reviews", //4
			"Filter by amenities", //5
			"Filter by price range", //7
			"Go back", //7
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
	private String[] incOrDec = 
		{
			"Sort increasing or decreasing?",
			"Increasing", //1
			"Decreasing", //2
		};
	private String[] amenities = 
		{
			"Pool",
			"Gym",
			"Pets",
			"Laundry",
			"Shuttle"
		};
	
	public HousingUI() {
		keyboard = new Scanner(System.in);
		application = new HousingApplication();
	}
	
	public void run() {
		System.out.println(WELCOME);
		// Test for Student DataLoader
// 		ArrayList<Student> students = dataLoader.loadStudent();
//		for(Student s: students) {
//			System.out.println(s.getUsername()+" " +s.getPassword()+" "+s.getFirstName()+ " "+s.getLastName());
//		}
		// Test for Property DataLoader
//		ArrayList<Property> properties = dataLoader.loadProperties();
//		for(Property p: properties) {
//			System.out.println(p.toString()+"\n");
//		}
		// Test for PropertyManager DataLoader
//		ArrayList<PropertyManager> manager = dataLoader.loadPropertyManager();
//		for(PropertyManager p: manager) {
//			System.out.println(p.getUsername()+" " +p.getPassword()+" "+p.getFirstName()+ " "+p.getLastName());
//		}
		// Test for Lease DataLoader
//		ArrayList<Lease> lease = dataLoader.loadLeases();
//		for(Lease l: lease) {
//			System.out.println(l.toString()+"\n");
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
				System.out.println(WELCOME + " " + user.getName());
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
				application.viewFavProperties(user);
				break;
			case 3:
				System.out.println("Please enter the ID of the property you wish to sign the lease for.");
				System.out.println(application.viewAllPropertiesShort());
				int userCommand2 = getUserCommand(application.getNumOfProperties());
				if(userCommand2 == -1)  {
					System.out.println(INVALID);
					break;
				}
				System.out.println("Signing lease for Property " + application.getProperty(userCommand2).shortToString() + ":");
				application.signLease(user, userCommand2);
				//TODO need to check
				break;
			case 4:
				application.viewSignedLeases(user);
				break;
			case 5:
				System.out.println("Please enter the ID of the property you wish to review.");
				System.out.println(application.viewAllPropertiesShort());
				int userCommand3 = getUserCommand(application.getNumOfProperties());
				if(userCommand3 == -1) {
					System.out.println(INVALID);
					break;
				}
				System.out.println("Reviewing property " + application.getProperty(userCommand3).shortToString() + ":");
				application.reviewProperty(user, userCommand3);
//				reviewProperty();//TODO
				break;
			case 6:
//				reviewPropertyManager();//TODO
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
//				manageProperties();//TODO
				break;
			case 2:
				application.viewMyProperties(user);//TODO
				break;
			case 3:
				//TODO sign lease
			case 4:
				application.viewSignedLeases(user);
				break;
			case 5:
//				reviewStudent();//TODO
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
			case 1:
				System.out.println("Viewing All Properties:");
				System.out.println(application.viewAllProperties());
				break;
			case 2:
				System.out.println("Please enter a keyword.");
				String keyword = keyboard.nextLine();
				System.out.println("Searching by keyword:" + keyword);
				System.out.println(application.searchByKeyword(keyword));
				break;
			case 3:
				displayMenu(incOrDec);
				int userCommand2 = getUserCommand(incOrDec.length);
				switch(userCommand2) {
				case 1:
					System.out.println("Sorting by price, increasing:");
					System.out.println(application.sortByPrice(true));
					break;
				case 2:
					System.out.println("Sorting by price, decreasing");
					System.out.println(application.sortByPrice(false));
					break;
				default:
					System.out.println(INVALID);
					break;
				}
				break;
			case 4:
				displayMenu(incOrDec);
				int userCommand3 = getUserCommand(incOrDec.length);
				switch(userCommand3) {
				case 1:
					System.out.println("Sorting by number of reviews, increasing");
					System.out.println(application.sortByNumReviews(true));
					break;
				case 2:
					System.out.println("Sorting by number of reviews, decreasing");
					System.out.println(application.sortByNumReviews(false));
					break;
				default:
					System.out.println(INVALID);
					break;
				}
				break;
			case 5:
				System.out.println("Which amenities do you want?");
				boolean[] choices = new boolean[amenities.length];
				for(int i = 0; i < amenities.length; i++) {
					while(true) {
						System.out.println(amenities[i] + "? Enter 1 for yes or 2 for no.");
						int choice = getUserCommand(3);
						if(choice == 1) {
							choices[i] = true;
							break;
						}
						if(choice == 2) {
							choices[i] = false;
							break;
						}
						System.out.println(INVALID);
					}	
				}
				application.filterByAmenities(choices);
				break;
			case 6:
				System.out.println("Please enter a minimum price (as an integer).");
				int min = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("Please enter a maximum price (as an integer).");
				int max = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("Properties between $" + min + " and $" + max + ":");
				System.out.println(application.filterByPriceRange(min, max));
				break;
			case 7:
				goBack = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		HousingUI driver = new HousingUI();
		driver.run();
	}
}
