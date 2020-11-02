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
			"View property manager reviews", //7
			"Log out" //8
		};
	private String[] propertyManagerOptions = 
		{
			"Property Manager Menu: ",
			"Manage my properties", //1
			"View my properties", //2
			"Sign lease", //3
			"View my signed leases", //4
			"Rate/review a student", //5
			"View student reviews", //6
			"Log out" //7
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
			"Sort by price", //3
			"Sort by number of reviews", //4
			"Filter by amenities", //5
			"Filter by price range", //6
			"View property reviews", //7
			"View leases", //8
			"Go back", //9
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
			user = null;
			displayMenu(mainMenuOptions);
			int userCommand = getUserCommand(mainMenuOptions.length);
			switch(userCommand) {
			case 1:
				createAccount();
				break;
			case 2:
				logIn();
				break;
			case 3:
				guestLoop();
				break;
			case 4:
				System.out.println(GOODBYE);
				return;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}
	
	// prints the menu, where element 0 is the title and elements 1-menu.length are the items
	private void displayMenu(String[] menu) {
		System.out.println("\n" + menu[0]);
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
	
	private void createAccount() {
		displayMenu(createAccountOptions);
		int userCommand = getUserCommand(createAccountOptions.length);
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
		return;
	}
	
	private void createAccount(AccountType type) {
		while(true) {
			System.out.println("Please enter a username.");
			String username = keyboard.nextLine();
			if(application.usernameInList(type, username)) {
				System.out.println("Username is already taken.");
				displayMenu(tryAgainOptions);
				int userCommand = getUserCommand(tryAgainOptions.length);
				switch(userCommand) {
				case 1:
					break;
				case 2:
					return;
				default:
					System.out.println(INVALID);
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
			user = application.logIn(username, password);
			return;
		}
	}
	
	private void studentLoop() {
		if(user.getAccountType() != AccountType.STUDENT) return;
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
				signLease();
				break;
			case 4:
				viewSignedLeases();
				break;
			case 5:
				reviewProperty();
				break;
			case 6:
				reviewPropertyManager();
				break;
			case 7:
				viewPropertyManagerReviews();
				break;
			case 8:
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
		if(user.getAccountType() != AccountType.PROPERTYMANAGER) return;
		boolean logOut = false;
		while(!logOut) {
			displayMenu(propertyManagerOptions);
			int userCommand = getUserCommand(propertyManagerOptions.length);
			switch(userCommand) {
			case 1:
				managePropertiesLoop();
				break;
			case 2:
				viewMyProperties();
				break;
			case 3:
				signLease();
				break;
			case 4:
				viewSignedLeases();
				break;
			case 5:
				reviewStudent();
				break;
			case 6:
				viewStudentReviews();
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
				viewAllProperties();
				break;
			case 2:
				searchByKeyword();
				break;
			case 3:
				sortByPrice();
				break;
			case 4:
				sortByNumReviews();
				break;
			case 5:
				filterByAmenities();
				break;
			case 6:
				filterByPriceRange();
				break;
			case 7:
				viewPropertyReviews();
			case 8:
				viewLeases();
			case 9:
				goBack = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}

	public void managePropertiesLoop() {
		//TODO
	}
	
	public void viewAllProperties() {
		System.out.println("Viewing All Properties:");
		System.out.println(application.viewAllProperties());
	}
	
	public void searchByKeyword() {
		System.out.println("Please enter a keyword.");
		String keyword = keyboard.nextLine();
		System.out.println("Searching by keyword:" + keyword);
		System.out.println(application.searchByKeyword(keyword));
	}
	
	public void sortByPrice() {
		displayMenu(incOrDec);
		int userCommand = getUserCommand(incOrDec.length);
		switch(userCommand) {
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
	}
	
	public void sortByNumReviews() {
		displayMenu(incOrDec);
		int userCommand = getUserCommand(incOrDec.length);
		switch(userCommand) {
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
	}
	
	public void filterByAmenities() {
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
		System.out.println(application.filterByAmenities(choices));
	}
	
	public void filterByPriceRange() {
		System.out.println("Please enter a minimum price (as an integer).");
		int min = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("Please enter a maximum price (as an integer).");
		int max = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("Properties between $" + min + " and $" + max + ":");
		System.out.println(application.filterByPriceRange(min, max));
	}
	
	public void viewFavProperties() {
		System.out.println("Favorite Properties:");
		System.out.println(application.viewFavProperties(user));
	}
	
	public void viewSignedLeases() {
		System.out.println("Signed Leases:");
		System.out.println(application.viewSignedLeases(user));
	}
	
	public void viewMyProperties() {
		System.out.println("My Properties:");
		System.out.println(application.viewMyProperties(user));
	}
	
	public void reviewProperty() {
		System.out.println("Please enter the ID of the property you wish to review.");
		System.out.println(application.viewAllPropertiesShort());
		int id = getUserCommand(PropertyList.getInstance().getSize() + 1);
		if(id == -1) {
			System.out.println(INVALID);
			return;
		}
		Property property = PropertyList.getInstance().getProperty(id);
		System.out.println("Reviewing property " + property.shortToString() + ":");
		System.out.println("Please enter a rating of the property as an integer between 1 and 5.");
		int rating = getUserCommand(6);
		if(rating == -1) {
			System.out.println(INVALID);
			return;
		}
		System.out.println("Please type your review.");
		String review = keyboard.nextLine();
		application.reviewProperty(user, property, rating, review);
	}
	
	public void reviewPropertyManager() {
		System.out.println("Please enter the ID of the property manager you wish to review.");
		System.out.println(application.listPropertyManagersShort());
		int id = getUserCommand(PropertyManagerList.getInstance().getSize() + 1);
		if(id == -1) {
			System.out.println(INVALID);
			return;
		}
		PropertyManager propertyManager = PropertyManagerList.getInstance().getPropertyManager(id);
		System.out.println("Reviewing property manager " + propertyManager.shortToString() + ":");
		System.out.println("Please enter a rating of the property manager as an integer between 1 and 5.");
		int rating = getUserCommand(6);
		if(rating == -1) {
			System.out.println(INVALID);
			return;
		}
		System.out.println("Please type your review.");
		String review = keyboard.nextLine();
		application.reviewPropertyManager(user, propertyManager, rating, review);
	}
	
	public void reviewStudent() {
		System.out.println("Please enter the ID of the student you wish to review.");
		System.out.println(application.listStudentsShort());
		int id = getUserCommand(StudentList.getInstance().getSize() + 1);
		if(id == -1) {
			System.out.println(INVALID);
			return;
		}
		Student student = StudentList.getInstance().getStudent(id);
		System.out.println("Reviewing student " + student.shortToString() + ":");
		System.out.println("Please enter a rating of the student as an integer between 1 and 5.");
		int rating = getUserCommand(6);
		if(rating == -1) {
			System.out.println(INVALID);
			return;
		}
		System.out.println("Please type your review.");
		String review = keyboard.nextLine();
		application.reviewStudent(user, student, rating, review);
	}
	
	public void signLease() {
		System.out.println("Please enter the ID of the property you wish to sign the lease for.");
		System.out.println(application.viewPropertiesWithLeases());
		int id = getUserCommand(application.getNumOfPropertiesWithLeases() + 1);
		if(id == -1) {
			System.out.println(INVALID);
			return;
		}
		Property property = PropertyList.getInstance().getProperty(id);
		Lease lease = property.getLease();
		System.out.println("Signing lease for Property " + property.shortToString() + ":");
		application.signLease(user, lease);
	}
	
	public void viewPropertyReviews() {
		System.out.println("Property Reviews:");
		System.out.println(application.viewPropertyReviews());
	}
	
	public void viewPropertyManagerReviews() {
		System.out.println("Property Manager Reviews:");
		System.out.println(application.viewPropertyManagerReviews());
	}
	
	public void viewStudentReviews() {
		System.out.println("Student Reviews:");
		System.out.println(application.viewStudentReviews());
	}
	
	public void viewLeases() {
		//TODO
	}
	
	public static void main(String[] args) {
		HousingUI driver = new HousingUI();
		driver.run();
	}
}
