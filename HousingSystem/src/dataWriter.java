import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class dataWriter extends DataConstants{
	/**
	 * chris' train of thought
	 * 
	 * propertymanager: CREATE PROPERTY, EDIT PROPERTY, DELETE PROPERTY,
	 * 					CREATE LEASE and append to property,  
	 * 					REVIEW student
	 * STUDENT: 		ADD FAVORITE, REMOVE FAVORITE,
	 * 					REVIEW PROPERTY, REVIEW PROPERTYMANAGER
	 * 
	 */
	
	public static JSONObject getPropertyManagerJSON(PropertyManager manager) {
		JSONObject propertyManagerDetails = new JSONObject();
		propertyManagerDetails.put(ID, manager.getID());
		propertyManagerDetails.put(USER_NAME, manager.getUsername());
		propertyManagerDetails.put(PASSWORD, manager.getPassword());
		propertyManagerDetails.put(FIRST_NAME, manager.getFirstName());
		propertyManagerDetails.put(LAST_NAME, manager.getLastName());
		propertyManagerDetails.put(EMAIL, manager.getEmailAddress());
		propertyManagerDetails.put(PHONE, manager.getPhone());
		
//		JSONArray ids = new JSONArray();
//		ids.

		return propertyManagerDetails;
	}
	public static JSONObject getPropertyJSON(Property property) {
		JSONObject propertyDetails = new JSONObject();
		propertyDetails.put(PROPERTY_ID, property.getPropertyId());
		//propertyDetails.put(AMENITIES, property.getAmenities());
		propertyDetails.put(UTILITIES, property.getUtilities());
		propertyDetails.put(LOCATION, property.getLocation());
		//propertyDetails.put(PICTURES, property.getPictures());
		propertyDetails.put(PRICE, property.getPrice());
		//propertyDetails.put(RATINGS, property.getRatings());
		//propertyDetails.put(REVIEWS, property.getReviews());
		propertyDetails.put(BEDS, property.getBeds());
		propertyDetails.put(BATHS, property.getBaths());
		//propertyDetails.put(LEASES, property.getLease());
		propertyDetails.put(DESCRIPTION, property.getDescription());
		propertyDetails.put(CONTACT, property.getContact());
		propertyDetails.put(VISIBLE, property.isVisible());
		
		return propertyDetails;
	}
	public static JSONObject getStudentJSON(Student student) {
		JSONObject studentDetails = new JSONObject();
		studentDetails.put(ID, student.getID());
		studentDetails.put(STUDENT, student.getStudentId());
		studentDetails.put(USER_NAME, student.getUsername());
		studentDetails.put(PASSWORD, student.getPassword());
		studentDetails.put(FIRST_NAME, student.getFirstName());
		studentDetails.put(LAST_NAME, student.getLastName());
		studentDetails.put(EMAIL, student.getEmailAddress());
		studentDetails.put(PHONE, student.getPhone());
		
		return studentDetails;
	}
	
	public static void savePropertyManager(int id) {
		PropertyManagerList managers = PropertyManagerList.getInstance();
		ArrayList<PropertyManager> propertyManagers = managers.getPropertyManagers();
		JSONArray jsonPropertyManagers = new JSONArray();
		
		//creating all the json objects
		for(int i = 0; i < propertyManagers.size(); i++) {
			jsonPropertyManagers.add(getPropertyManagerJSON(propertyManagers.get(i)));
		}
	}
	
	public static void saveProperty() {
		PropertyList properties = PropertyList.getInstance();
		
	}
	public static void deleteProperty() {
		
	}
	public static void saveReview(Review review, Object obj) {
		
	}
	
	public static void saveStudent() {
		StudentList students = StudentList.getInstance();
		
	}
//	//need separate methods for student and propertymanager; no more user class
//	public static void saveUser() 
//	{
//		User user = User.getInstance();
//		ArrayList<Property> property = property.getProperty();
//		JSONArray jsonProperty = new JSONArray();
//		
//		for(int i = 0; i < property.size(); i++)
//		{
//			jsonProperty.add(getUsersJSON(property.get(i)));
//		}
//		
//		try (FileWriter file = new FileWriter(STUDENT_FILE_NAME))
//		{
//			
//			file.write(jsonProperty.toJSONString());
//			file.flush();
//		}
//		
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//	}
//	
//	public static JSONObject getUsersJSON(User user)
//	{
//		JSONObject UsersDetails = new JSONObject();
//		usersDetails.put(USER_FIRST_NAME, users.getFirstName());
//		usersDetails.put(USER_LAST_NAME, users.getLastName());
//		usersDetails.put(USER_PHONE_NUMBER, users.getPhoneNumber());
//		
//		return usersDetails;
//	}
	
}
