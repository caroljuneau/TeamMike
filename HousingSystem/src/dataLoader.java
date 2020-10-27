import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class dataLoader extends DataConstants{
	
	public static int[] parseString(Object obj) {
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
				
				student.setFavoriteIDs(parseString(studentJSON.get(FAVORITES)));
				student.setRating(parseString(studentJSON.get(RATINGS)));
				student.setReviewIDs(parseString(studentJSON.get(REVIEWS)));
				student.setSignedLeaseIDs(parseString(studentJSON.get(LEASES)));

/** 
 * Passing data to be replaced by student.toString();
 */
//				System.out.println("Username: " + username);
//				System.out.println("Password: " + password);
//				System.out.println("First: " + firstName);
//				System.out.println("Last: " + lastName);
//				System.out.println("Rating: " + student.getAvgRating());
//				System.out.println("Favorite IDs: ");
//				int[] a;
//				a = student.getFavoriteIDs();
//				for(int j: a) {
//					System.out.print(j + ", ");
//				}
//				System.out.println();
//				System.out.println("Review IDs: ");
//				a = student.getReviewIDs();
//				for(int j: a) {
//					System.out.print(j + ", ");
//				}
//				System.out.println();
//				System.out.println("Signed Lease IDs: ");
//				a = student.getSignedLeaseIDs();
//				for(int j: a) {
//					System.out.print(j + ", ");
//				}
//				System.out.println();
//				System.out.println();
	
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
