import java.util.Scanner;

public class HousingUI {

	private Scanner keyboard;
	private HousingApplication application;
	//private User user;
	
	private String[] mainMenuOptions = 
		{
			"Main Menu: ",
			"Create account", 
			"Log in with account",
			"Continue as guest",
			"Exit"
		};
	private String[] createAccountOptions = 
		{
			"Create Account Menu: ",
			"Create student account",
			"Create property manager account",
			"Create hybrid account",
			"Go back",
			"Exit"
		};
	private String[] studentOptions = 
		{
			"Student Menu: ",
			"Browse properties",
			"View my favorite properties",
			"View my signed leases",
			"Rate/review a property",
			"Rate/review a property manager",
			"Manage account",
			"Log out"
		};
	private String[] propertyManagerOptions = 
		{
			"Property Manager Menu: ",
			"Manage my properties",
			"View my properties",
			"View my signed leases",
			"Rate/review a student",
			"Manage account",
			"Log out"
		};
	private String[] guestOptions = 
		{
			"Guest Menu: ",
			"Browse properties",
			"Create account",
			"Exit"
		};
	private String[] browseProperties = 
		{
			"Browse Properties Menu: ",
			"View all properties",
			"Search by keyword",
			"Sort by distance",
			"Sort by price",
			"Sort by number of reviews",
			"Filter by amenities",
			"Filter by price range",
			"Go back",
			"Exit"
		};
	
	private String[] manageProperties = 
		{
			"Manage Properties Menu: ",
			"Add a new property",
			"Edit an existing property",
			"Delete an existing property",
			"Create a lease"
		};
	
	public HousingUI() {
		keyboard = new Scanner(System.in);
		//application = new HousingApplication();
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
	
	private void displayMenu(String[] menu) {
		System.out.println(menu[0]);
		for(int i = 1; i < menu.length; i++) {
			System.out.println(i + ". " + menu[i]);
		}
	}
	
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
