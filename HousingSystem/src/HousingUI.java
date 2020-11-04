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
			"Add a favorite property", //2
			"View my favorite properties", //3
			"Sign lease", //4
			"View my signed leases", //5
			"Rate/review a property", //6
			"Rate/review a property manager", //7
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
			"Sort by price", //3
			"Sort by number of reviews", //4
			"Filter by amenities", //5
			"Filter by price range", //6
			"View lease and generate txt", //7
			"View property reviews", //8
			"View property manager reviews", //9
			"View student reviews", //10
			"Go back", //11
		};
	private String[] managePropertiesOptions = 
		{
			"Manage Properties Menu: ",
			"Add a new property", //1
			"Delete an existing property", //2
			"Create a lease", //3
			"Go back" //4
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
			"Pet Friendly",
			"Laundry",
			"Shuttle"
		};

	public HousingUI() {
		keyboard = new Scanner(System.in);
		application = new HousingApplication();
	}

	public void run() {
		System.out.println(WELCOME);
//		// Test for Student DataLoader
//		ArrayList<Student> students = DataLoader.loadStudent();
//		for (Student s : students) {
//			System.out
//					.println(s.getUsername() + " " + s.getPassword() + " " + s.getFirstName() + " " + s.getLastName());
//		}
//		// Test for Property DataLoader
//		ArrayList<Property> properties = DataLoader.loadProperties();
//		for (Property p : properties) {
//			System.out.println(p.toString() + "\n");
//		}
//		// Test for PropertyManager DataLoader
//		ArrayList<PropertyManager> manager = DataLoader.loadPropertyManager();
//		for (PropertyManager p : manager) {
//			System.out
//					.println(p.getUsername() + " " + p.getPassword() + " " + p.getFirstName() + " " + p.getLastName());
//		}
//		// Test for Lease DataLoader
//		ArrayList<Lease> lease = DataLoader.loadLeases();
//		for (Lease l : lease) {
//			System.out.println(l.toString() + "\n");
//		}
		while (true) {
			user = null;
			displayMenu(mainMenuOptions);
			int userCommand = getUserCommand(mainMenuOptions.length);
			switch (userCommand) {
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
			updateJSON();
		}
	}

	// Options for guest users
	private void guestLoop() {
		boolean goBack = false;
		while (!goBack) {
			displayMenu(guestOptions);
			int userCommand = getUserCommand(guestOptions.length);
			switch (userCommand) {
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

	// Options for registered student users
	private void studentLoop() {
		if (user.getAccountType() != AccountType.STUDENT)
			return;
		boolean logOut = false;
		while (!logOut) {
			displayMenu(studentOptions);
			int userCommand = getUserCommand(studentOptions.length);
			switch (userCommand) {
			case 1:
				browsePropertiesLoop();
				break;
			case 2:
				addFavProperty();
				break;
			case 3:
				viewFavProperties();
				break;
			case 4:
				signLease();
				break;
			case 5:
				viewSignedLeases();
				break;
			case 6:
				reviewProperty();
				break;
			case 7:
				reviewPropertyManager();
				break;
			case 8:
				System.out.println(LOGOUT);
				logOut = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
			updateJSON();
		}
	}

	// Options for registered property manager users
	private void propertyManagerLoop() {
		if (user.getAccountType() != AccountType.PROPERTYMANAGER)
			return;
		boolean logOut = false;
		while (!logOut) {
			displayMenu(propertyManagerOptions);
			int userCommand = getUserCommand(propertyManagerOptions.length);
			switch (userCommand) {
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
				System.out.println(LOGOUT);
				logOut = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
			updateJSON();
		}
	}

	// Prints a menu, where element 0 is the title and elements 1-menu.length are
	// the items
	private void displayMenu(String[] menu) {
		System.out.println("\n" + menu[0]);
		for (int i = 1; i < menu.length; i++) {
			System.out.println(i + ". " + menu[i]);
		}
	}

	// Parses the user input into an integer, returns that int if its between 1 and
	// numCommands-1, else returns -1
	private int getUserCommand(int numCommands) {
		System.out.println("What would you like to do?");
		String input = keyboard.nextLine();
		int command = parseInt(input);
		if (command >= 1 && command <= numCommands - 1) {
			return command;
		}
		return -1;
	}

	private int parseInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	// Options for creating an account
	private void createAccount() {
		displayMenu(createAccountOptions);
		int userCommand = getUserCommand(createAccountOptions.length);
		switch (userCommand) {
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

	// Creates an account of a given type, and logs into that account
	private void createAccount(AccountType type) {
		while (true) {
			System.out.println("Please enter a username.");
			String username = keyboard.nextLine();
			if (application.usernameInList(username)) {
				System.out.println("Username is already taken.");
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
			System.out.println("Please enter your phone number.");
			String phone = keyboard.nextLine();
			if (type == AccountType.STUDENT) {
				System.out.println("Please enter your student id.");
				String studentID = keyboard.nextLine();
				user = application.createStudentAccount(username, password, firstname, lastname, emailAddress, phone, studentID);
			} else if (type == AccountType.PROPERTYMANAGER) {
				user = application.createPropertyManagerAccount(username, password, firstname, lastname, emailAddress, phone);
			}
			return;
		}
	}

	// Checks account info. If an account matches, log in.
	private void logIn() {
		user = null;
		while (user == null) {
			System.out.println("Please enter your username.");
			String username = keyboard.nextLine();
			System.out.println("Please enter your password.");
			String password = keyboard.nextLine();
			user = application.logIn(username, password);
			if (user == null) {
				System.out.println("Incorrect username or password.");
				return;
			}
		}
		System.out.println(WELCOME + " " + user.getName());
		switch (user.getAccountType()) {
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

	// Options for browsing properties.
	private void browsePropertiesLoop() {
		boolean goBack = false;
		while (!goBack) {
			displayMenu(browsePropertiesOptions);
			int userCommand = getUserCommand(browsePropertiesOptions.length);
			switch (userCommand) {
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
				viewLeases();
				break;
			case 8:
				viewPropertyReviews();
				break;
			case 9:
				viewPropertyManagerReviews();
				break;
			case 10:
				viewStudentReviews();
				break;
			case 11:
				goBack = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}

	// Options for managing properties.
	public void managePropertiesLoop() {
		boolean goBack = false;
		while (!goBack) {
			displayMenu(managePropertiesOptions);
			int userCommand = getUserCommand(managePropertiesOptions.length);
			switch (userCommand) {
			case 1:
				addNewProperty();
				break;
			case 2:
				deleteExistingProperty();
				break;
			case 3:
				createLease();
				break;
			case 4:
				goBack = true;
				break;
			default:
				System.out.println(INVALID);
				break;
			}
		}
	}

	// Prints out all properties.
	public void viewAllProperties() {
		System.out.println("Viewing All Properties:");
		System.out.println(application.viewAllProperties());
	}

	// Searches for a keyword within each property.
	public void searchByKeyword() {
		System.out.println("Please enter a keyword.");
		String keyword = keyboard.nextLine();
		System.out.println("Searching by keyword:" + keyword);
		System.out.println(application.searchByKeyword(keyword));
	}

	// Sorts properties by price, increasing or decreasing.
	public void sortByPrice() {
		displayMenu(incOrDec);
		int userCommand = getUserCommand(incOrDec.length);
		switch (userCommand) {
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

	// Sorts properties by number of reviews, increasing or decreasing.
	public void sortByNumReviews() {
		displayMenu(incOrDec);
		int userCommand = getUserCommand(incOrDec.length);
		switch (userCommand) {
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

	// Filters properties by amenities.
	// Note that the filter only matches "true" for amenities.
	public void filterByAmenities() {
		System.out.println("Which amenities do you want?");
		boolean[] choices = new boolean[amenities.length];
		for (int i = 0; i < amenities.length; i++) {
			while (true) {
				System.out.println(amenities[i] + "? Enter 1 for yes or 2 for no.");
				int choice = parseInt(keyboard.nextLine());
				if (choice == 1) {
					choices[i] = true;
					break;
				}
				if (choice == 2) {
					choices[i] = false;
					break;
				}
				System.out.println(INVALID);
			}
		}
		System.out.println(application.filterByAmenities(choices));
	}

	// Filters properties for price within a range.
	public void filterByPriceRange() {
		System.out.println("Please enter a minimum price (as an integer).");
		int min = parseInt(keyboard.nextLine());
		System.out.println("Please enter a maximum price (as an integer).");
		int max = parseInt(keyboard.nextLine());
		System.out.println("Properties between $" + min + " and $" + max + ":");
		System.out.println(application.filterByPriceRange(min, max));
	}

	// Prints a student's favorite properties.
	public void viewFavProperties() {
		System.out.println("Favorite Properties:");
		System.out.println(application.viewFavProperties(user));
	}

	// Prints a user's signed leases.
	public void viewSignedLeases() {
		System.out.println("Signed Leases:");
		System.out.println(application.viewSignedLeases(user));
	}

	// Prints a property manager's properties.
	public void viewMyProperties() {
		System.out.println("My Properties:");
		System.out.println(application.viewMyProperties(user));
	}

	// Reviews a property.
	public void reviewProperty() {
		System.out.println("Please enter the ID of the property you wish to review.");
		System.out.println(application.viewAllPropertiesShort());
		int id = getUserCommand(application.getPropertiesSize() + 1);
		if (id == -1) {
			System.out.println(INVALID);
			return;
		}
		Property property = application.getProperty(id);
		System.out.println("Reviewing property " + property.shortToString() + ":");
		System.out.println("Please enter a rating of the property as an integer between 1 and 5.");
		int rating = parseInt(keyboard.nextLine());
		if (rating < 1 || rating > 5) {
			System.out.println(INVALID);
			return;
		}
		System.out.println("Please type your review.");
		String review = keyboard.nextLine();
		System.out.println(application.reviewProperty(user, property, rating, review));
	}

	// Reviews a property manager.
	public void reviewPropertyManager() {
		System.out.println("Please enter the ID of the property manager you wish to review.");
		System.out.println(application.listPropertyManagersShort());
		int id = getUserCommand(application.getPropertyManagersSize() + 1);
		if (id == -1) {
			System.out.println(INVALID);
			return;
		}
		PropertyManager propertyManager = application.getPropertyManager(id);
		System.out.println("Reviewing property manager " + propertyManager.getName() + ":");
		System.out.println("Please enter a rating of the property manager as an integer between 1 and 5.");
		int rating = parseInt(keyboard.nextLine());
		if (rating < 1 || rating > 5) {
			System.out.println(INVALID);
			return;
		}
		System.out.println("Please type your review.");
		String review = keyboard.nextLine();
		System.out.println(application.reviewPropertyManager(user, propertyManager, rating, review));
	}

	// Reviews a student.
	public void reviewStudent() {
		System.out.println("Please enter the ID of the student you wish to review.");
		System.out.println(application.listStudentsShort());
		int id = getUserCommand(application.getStudentsSize() + 1);
		if (id == -1) {
			System.out.println(INVALID);
			return;
		}
		Student student = application.getStudent(id);
		System.out.println("Reviewing student " + student.getName() + ":");
		System.out.println("Please enter a rating of the student as an integer between 1 and 5.");
		int rating = parseInt(keyboard.nextLine());
		if (rating < 1 || rating > 5) {
			System.out.println(INVALID);
			return;
		}
		System.out.println("Please type your review.");
		String review = keyboard.nextLine();
		System.out.println(application.reviewStudent(user, student, rating, review));
	}

	// Signs a lease.
	public void signLease() {
		System.out.println("Please enter the ID of the property you wish to sign the lease for.");
		System.out.println(application.viewAllProperties());
		int id = getUserCommand(application.getPropertiesSize() + 1);
		if (id == -1) {
			System.out.println(INVALID);
			return;
		}
		Property property = application.getProperty(id);
		if (property.getLease() == null) {
			System.out.println("Property " + property + " does not have a lease.");
			return;
		}
		Lease lease = property.getLease();
		System.out.println("Signing lease for Property " + property.shortToString() + ":");
		System.out.println(application.signLease(user, lease));
	}

	// Prints reviews of all properties.
	public void viewPropertyReviews() {
		System.out.println("Property Reviews:");
		System.out.println(application.viewPropertyReviews());
	}

	// Prints reviews of all property managers.
	public void viewPropertyManagerReviews() {
		System.out.println("Property Manager Reviews:");
		System.out.println(application.viewPropertyManagerReviews());
	}

	// Prints reviews of all students.
	public void viewStudentReviews() {
		System.out.println("Student Reviews:");
		System.out.println(application.viewStudentReviews());
	}

	// Prints a lease of a property.
	public void viewLeases() {
		System.out.println("Please enter the ID of the property you wish to view the lease for.");
		System.out.println(application.viewAllPropertiesShort());
		int id = getUserCommand(application.getPropertiesSize() + 1);
		if (id == -1) {
			System.out.println(INVALID);
			return;
		}
		Property property = application.getProperty(id);
		Lease lease = property.getLease();
		if (lease == null) {
			System.out.println("Property " + property.getPropertyId() + " does not have a lease.");
			return;
		}
		System.out.println("Lease for Property " + property.getPropertyId() + ": ");
		System.out.println(lease);
		lease.generateTxt();
		System.out.println("See generated lease in \"" + DataConstants.LEASE_TEXT_FILE_NAME + "\"");
	}

	// Adds a favorite property, for a student.
	public void addFavProperty() {
		System.out.println("Please enter the ID of the property you wish to add to your favorites.");
		System.out.println(application.viewAllProperties());
		int id = getUserCommand(application.getPropertiesSize() + 1);
		if (id == -1) {
			System.out.println(INVALID);
			return;
		}
		Property property = application.getProperty(id);
		System.out.println("Adding property " + property.shortToString() + " to favorites:");
		application.addFavProperty(user, property);
		System.out.println("Added to favorites.");
	}

	// Adds a new property to the system, as a property manager.
	public void addNewProperty() {
		System.out.println("Enter the location of the property.");
		String location = keyboard.nextLine();
		System.out.println("Enter the amenities you want; 1 for yes, 2 for no.");
		boolean[] amenitiesBool = enterAmenities();
		System.out.println("Enter utilities.");
		String utilities = keyboard.nextLine();
		System.out.println("Enter price as an integer.");
		int price = parseInt(keyboard.nextLine());
		System.out.println("Enter the number of beds as an integer.");
		int beds = parseInt(keyboard.nextLine());
		System.out.println("Enter the number of baths as an integer.");
		int baths = parseInt(keyboard.nextLine());
		System.out.println("Enter a description for the property.");
		String description = keyboard.nextLine();
		System.out.println("Enter a contact for the property.");
		String contact = keyboard.nextLine();
		System.out.println(application.addNewProperty(user, location, amenitiesBool, utilities, price, beds, baths, description, contact));
	}

	// Creates a boolean array from user input.
	public boolean[] enterAmenities() {
		boolean[] ret = new boolean[amenities.length];
		for (int i = 0; i < amenities.length; i++) {
			while (true) {
				System.out.println(amenities[i] + "?");
				int command = parseInt(keyboard.nextLine());
				if (command == 1) {
					ret[i] = true;
					break;
				} else if (command == 2) {
					ret[i] = false;
					break;
				} else {
					System.out.println(INVALID);
				}
			}
		}
		return ret;
	}

	// Flags a property so that it is not visible in any lists.
	// Note that the property remains in the system, but is not accessible.
	public void deleteExistingProperty() {
		System.out.println("Please enter the ID of the property you wish to delete.");
		if (user.getAccountType() == AccountType.PROPERTYMANAGER) {
			if (((PropertyManager) user).getMyProperties().size() == 0) {
				System.out.println("You do not have any properties to delete.");
				return;
			}
		}
		System.out.println(application.viewMyPropertiesShort(user));
		int id = getUserCommand(application.getPropertiesSize() + 1);
		if (id == -1) {
			System.out.println(INVALID);
			return;
		}
		Property property = application.getProperty(id);
		System.out.println(application.removeProperty(property));
	}

	// Creates a lease and adds it to a property.
	public void createLease() {
		System.out.println("Please enter the ID of the property you wish to create a lease for.");
		System.out.println(application.viewMyProperties(user));
		int id = getUserCommand(application.getPropertiesSize() + 1);
		if (id == -1) {
			System.out.println(INVALID);
			return;
		}
		Property property = application.getProperty(id);
		if (property.getLease() != null) {
			System.out.println("Property already has a lease.");
			return;
		}
		System.out.println("Enter information about fees.");
		String fees = keyboard.nextLine();
		System.out.println("Enter information about repairs.");
		String repairs = keyboard.nextLine();
		System.out.println("Enter information about termination.");
		String termination = keyboard.nextLine();
		System.out.println("Enter any additional information.");
		String info = keyboard.nextLine();
		System.out.println(application.addLease(property, fees, repairs, termination, info));
	}
	
	public void updateJSON() {
		DataWriter.saveLease();
		DataWriter.saveProperty();
		DataWriter.savePropertyManager();
		DataWriter.saveReview();
		DataWriter.saveStudent();
	}

	public static void main(String[] args) {
		HousingUI driver = new HousingUI();
		driver.run();
	}
}
