import java.util.Scanner;

public class HousingUI {

	private Scanner keyboard;
	private HousingApplication application;
	private Account account;
	
	private static final String WELCOME = "Welcome!";
	private static final String GOODBYE = "Goodbye!";
	private static final String INVALID = "Invalid command";
	private static final String STUDENT = "Student";
	private static final String PM = "Property Manager";
	
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
	
	public HousingUI() {
		keyboard = new Scanner(System.in);
		application = new HousingApplication();
	}
	
	public void run() {
		System.out.println(WELCOME);
		while(true) {
			displayMenu(mainMenuOptions);
			int userCommand = getUserCommand(mainMenuOptions.length);
			switch(userCommand) {
			case -1:
				System.out.println(INVALID);
				break;
			case 1:
				displayMenu(createAccountOptions);
				userCommand = getUserCommand(createAccountOptions.length);
				switch(userCommand) {
				case -1:
					System.out.println(INVALID);
					break;
				case 1:
					createStudentAccount();
					studentLoop();
					break;
				case 2:
					createPropertyManagerAccount();
					propertyManagerLoop();
					break;
				default:
					break;
				}
			case 2:
				String type = logIn();
				switch(type) {
				case STUDENT:
					studentLoop();
					break;
				case PM:
					propertyManagerLoop();
					break;
				default:
					break;
				}
			case 3:
				guestLoop();
				break;
			default:
				System.out.println(GOODBYE);
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
	
	// should return the type of account, either student or pm. maybe make an enum intead of using string
	private String logIn() {
		return "";
	}
	
	private void createStudentAccount() {
		
	}
	
	private void createPropertyManagerAccount() {
		
	}
	
	private void studentLoop() {
		
	}
	
	private void propertyManagerLoop() {
		
	}
	
	private void guestLoop() {
		
	}
	
	public static void main(String[] args) {
		HousingUI driver = new HousingUI();
		driver.run();
	}
}
