import java.util.ArrayList;

public class User 
{
	
	private static User users;
	private ArrayList<User> userList;
	
	private User() 
	{
		//userList = Database.getUsers();
	}
	
	public static User getInstance() 
	{
		if(users == null) 
		{
			users = new User();
		}
		return users;
	}
}