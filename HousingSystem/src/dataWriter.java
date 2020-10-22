import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class dataWriter extends DataConstants{

	public static void saveUser() 
	{
		User user = User.getInstance();
		ArrayList<Property> property = property.getProperty();
		JSONArray jsonProperty = new JSONArray();
		
		for(int i = 0; i < property.size(); i++)
		{
			jsonProperty.add(getUsersJSON(property.get(i)));
		}
		
		try (FileWriter file = new FileWriter(STUDENT_FILE_NAME))
		{
			
			file.write(jsonProperty.toJSONString());
			file.flush();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static JSONObject getUsersJSON(User user)
	{
		JSONObject UsersDetails = new JSONObject();
		usersDetails.put(USER_FIRST_NAME, users.getFirstName());
		usersDetails.put(USER_LAST_NAME, users.getLastName());
		usersDetails.put(USER_PHONE_NUMBER, users.getPhoneNumber());
		
		return usersDetails;
	}
}
