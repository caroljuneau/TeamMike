import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class dataLoader extends DataConstants{
	
	public static int[] parseStringToInt(Object obj) {
		String csv;
		String[] str;
		int[] ind;
		if(obj != null) {
			csv = obj.toString();
			str = csv.split(", ");
			ind = new int[str.length];
			for(int i = 0; i < str.length; i++) {
				ind[i] = Integer.parseInt(str[i]);
			}
			return ind;
		}
		return null;
	}
	public static String[] parseString(Object obj) {
		String csv;
		String[] str;
		if(obj != null) {
			csv = obj.toString();
			str = csv.split(", ");
			return str;
		}
		return null;
	}
	public static int[] getIDs(JSONArray arr)
	{
		int[] ids = new int[arr.size()];
		for(int i=0; i < arr.size(); i++) {
			ids[i] = ((Long)arr.get(i)).intValue();
		}
		return ids;
	}
	
	
	public static ArrayList<Property> loadProperties() {
		ArrayList<Property> properties = new ArrayList<Property>();
		
		try {
			FileReader reader = new FileReader(PROPERTY_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray propertiesJSON = (JSONArray)new JSONParser().parse(reader);
			Property property;
			
			for(int i=0; i < propertiesJSON.size(); i++) {
				JSONObject propertyJSON = (JSONObject)propertiesJSON.get(i);
				int id = Integer.parseInt((String)propertyJSON.get(PROPERTY_ID));
				String[] amenities = parseString(propertyJSON.get(AMENITIES));
				String utilities = (String)propertyJSON.get(UTILITIES);
				String location = (String)propertyJSON.get(LOCATION);
				//String pictures = (String)propertyJSON.get(PICTURES);
				int price = (Integer)propertyJSON.get(PRICE);
				int[] reviews = parseStringToInt((String)propertyJSON.get(PROPERTY_REVIEWS));
				int beds = (Integer)propertyJSON.get(BEDS);
				int baths = (Integer)propertyJSON.get(BATHS);
				int leaseId = Integer.parseInt((String)propertyJSON.get(LEASE));
				String description = (String)propertyJSON.get(DESCRIPTION);
				String contact = (String)propertyJSON.get(CONTACT);
				String vis = (String)propertyJSON.get(VISIBLE);
				boolean visible;
				if(vis.equalsIgnoreCase("false")) {
					visible = false;
				} else {
					visible = true;
				}
				property = new Property(amenities, utilities, location, price, beds, baths, description, contact, visible);
				properties.add(property);
			}
			return properties;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static ArrayList<Student> loadStudent() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			FileReader reader = new FileReader(STUDENT_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray studentsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < studentsJSON.size(); i++) {
				JSONObject studentJSON = (JSONObject)studentsJSON.get(i);
				int id = ((Long)studentJSON.get(ID)).intValue();
				String username = (String)studentJSON.get(USER_NAME);
				String password = (String)studentJSON.get(PASSWORD);
				String firstName = (String)studentJSON.get(FIRST_NAME);
				String lastName = (String)studentJSON.get(LAST_NAME);
				String emailAddress = (String)studentJSON.get(EMAIL);
				String phone = (String)studentJSON.get(PHONE);
				String studentID = (String)studentJSON.get(STUDENT);
				
				Student student = new Student(id, username, password, firstName, lastName, emailAddress, phone, studentID);
				students.add(student);
				
				student.setFavoriteIDs(getIDs((JSONArray)studentJSON.get(FAVORITES)));
				student.setRating(getIDs((JSONArray)studentJSON.get(FAVORITES)));
				student.setReviewIDs(getIDs((JSONArray)studentJSON.get(FAVORITES)));
				student.setSignedLeaseIDs(getIDs((JSONArray)studentJSON.get(FAVORITES)));

//				student.setFavoriteIDs(parseStringToInt(studentJSON.get(FAVORITES)));
//				student.setRating(parseStringToInt(studentJSON.get(RATINGS)));
//				student.setReviewIDs(parseStringToInt(studentJSON.get(REVIEWS)));
//				student.setSignedLeaseIDs(parseStringToInt(studentJSON.get(LEASES)));
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static PropertyManager loadPropertyManager() {
		PropertyManager manager = new PropertyManager();
		
		return manager;
	}

	
}
