import java.util.*;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class dataLoader extends DataConstants{
	
	public static ArrayList<Property> loadProperties() {
		ArrayList<Property> property = new ArrayList<Property>();
		
		return property;
	}
	public static ArrayList<Student> loadStudent() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			FileReader reader = new FileReader(STUDENT_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray studentsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < studentsJSON.size(); i++) {
				JSONObject studentJSON = (JSONObject)studentsJSON.get(i);
				int id = Integer.parseInt((String)studentJSON.get(ID));
				String username = (String)studentJSON.get(USER_NAME);
				String password = (String)studentJSON.get(PASSWORD);
				String firstName = (String)studentJSON.get(FIRST_NAME);
				String lastName = (String)studentJSON.get(LAST_NAME);
				String emailAddress = (String)studentJSON.get(EMAIL);
				String phone = (String)studentJSON.get(PHONE);
				String studentID = (String)studentJSON.get(STUDENT);
				Student student = new Student(username, password, firstName, lastName, emailAddress, phone, studentID);
				students.add(student);
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
