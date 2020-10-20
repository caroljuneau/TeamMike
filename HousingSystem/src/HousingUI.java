import java.util.Scanner;

public class HousingUI {

	private Scanner keyboard;
	private HousingApplication application;
	//private User user;
	
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
			"Create hybrid account", //3
			"Go back", //4
			"Exit" //5
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
			"Create account", //2
			"Exit" //3
		};
	private String[] browseProperties = 
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
			"Exit" //9
		};
	private String[] manageProperties = 
		{
			"Manage Properties Menu: ",
			"Add a new property", //1
			"Edit an existing property", //2
			"Delete an existing property", //3
			"Create a lease" //4
		};
	
	public HousingUI() {
		keyboard = new Scanner(System.in);
		application = new HousingApplication();
	}
	
	public void run() {
		System.out.println("Welcome");
		while(true) {
			displayMenu(mainMenuOptions);
			int userCommand = getUserCommand(mainMenuOptions.length);
			if(userCommand == -1) {
				System.out.println("Invalid command");
				continue;
			}
			switch(userCommand) {
			case 1:
				displayMenu(createAccountOptions);
				break;
			case 2: 
				logIn();
				break;
			case 3:
				displayMenu(guestOptions);
				break;
			default:
				logOut();
				System.exit(1);
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
		
	}
	
	private void logOut() {
		System.out.println("Goodbye");
	}
	
	public static void main(String[] args) {
		HousingUI driver = new HousingUI();
		driver.run();
	}

}
