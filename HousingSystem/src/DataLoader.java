import java.util.*;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class DataLoader extends DataConstants {

	public static ArrayList<Integer> getIDs(JSONArray arr) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		if (arr != null) {
			for (int i = 0; i < arr.size(); i++) {
				ids.add(((Long) arr.get(i)).intValue());
			}
		}
		return ids;
	}

	public static boolean[] parseBool(JSONArray arr) {
		boolean[] s = new boolean[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			s[i] = (boolean) arr.get(i);
		}
		return s;
	}

	public static ArrayList<Property> loadProperties() {
		ArrayList<Property> properties = new ArrayList<Property>();

		try {
			FileReader reader = new FileReader(PROPERTY_FILE_NAME);
			JSONArray propertiesJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < propertiesJSON.size(); i++) {
				JSONObject propertyJSON = (JSONObject) propertiesJSON.get(i);

				int id = ((Long) propertyJSON.get(PROPERTY_ID)).intValue();
				boolean[] amenities = parseBool((JSONArray) propertyJSON.get(AMENITIES));
				String utilities = (String) propertyJSON.get(UTILITIES);
				String location = (String) propertyJSON.get(LOCATION);
				int price = ((Long) propertyJSON.get(PRICE)).intValue();
				int beds = ((Long) propertyJSON.get(BEDS)).intValue();
				int baths = ((Long) propertyJSON.get(BATHS)).intValue();
				String description = (String) propertyJSON.get(DESCRIPTION);
				String contact = (String) propertyJSON.get(CONTACT);
				boolean vis = (boolean) propertyJSON.get(VISIBLE);

				Property property = new Property(id, amenities, utilities, location, price, beds, baths, description, contact, vis);
				properties.add(property);

				property.setRatings(getIDs((JSONArray) propertyJSON.get(RATINGS)));
				property.setReviews(getIDs((JSONArray) propertyJSON.get(REVIEWS)));
				property.setLease(((Long) propertyJSON.get(LEASES)).intValue());

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
			JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < studentsJSON.size(); i++) {
				JSONObject studentJSON = (JSONObject) studentsJSON.get(i);

				int id = ((Long) studentJSON.get(ID)).intValue();
				String username = (String) studentJSON.get(USER_NAME);
				String password = (String) studentJSON.get(PASSWORD);
				String firstName = (String) studentJSON.get(FIRST_NAME);
				String lastName = (String) studentJSON.get(LAST_NAME);
				String emailAddress = (String) studentJSON.get(EMAIL);
				String phone = (String) studentJSON.get(PHONE);
				String studentID = (String) studentJSON.get(STUDENT);

				Student student = new Student(id, username, password, firstName, lastName, emailAddress, phone,studentID);
				students.add(student);

				student.setFavProperties(getIDs((JSONArray) studentJSON.get(FAVORITES)));
				student.setRatings(getIDs((JSONArray) studentJSON.get(RATINGS)));
				student.setReviews(getIDs((JSONArray) studentJSON.get(REVIEWS)));
				student.setSignedLeases(getIDs((JSONArray) studentJSON.get(LEASES)));
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<PropertyManager> loadPropertyManager() {
		ArrayList<PropertyManager> managerList = new ArrayList<PropertyManager>();

		try {
			FileReader reader = new FileReader(MANAGER_FILE_NAME);
			JSONArray propertyManagerJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < propertyManagerJSON.size(); i++) {
				JSONObject managerJSON = (JSONObject) propertyManagerJSON.get(i);

				int id = ((Long) managerJSON.get(ID)).intValue();
				String username = (String) managerJSON.get(USER_NAME);
				String password = (String) managerJSON.get(PASSWORD);
				String firstName = (String) managerJSON.get(FIRST_NAME);
				String lastName = (String) managerJSON.get(LAST_NAME);
				String emailAddress = (String) managerJSON.get(EMAIL);
				String phone = (String) managerJSON.get(PHONE);

				PropertyManager manager = new PropertyManager(id, username, password, firstName, lastName, emailAddress,
						phone);
				managerList.add(manager);

				manager.setMyProperties(getIDs((JSONArray) managerJSON.get(MANAGER_PROPERTY)));
				manager.setRatings(getIDs((JSONArray) managerJSON.get(RATINGS)));
				manager.setReviews(getIDs((JSONArray) managerJSON.get(REVIEWS)));
				manager.setSignedLeases(getIDs((JSONArray) managerJSON.get(LEASES)));
			}
			return managerList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Lease> loadLeases() {
		ArrayList<Lease> leaseList = new ArrayList<Lease>();

		try {
			FileReader reader = new FileReader(LEASE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray leasesJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < leasesJSON.size(); i++) {
				JSONObject leaseObj = (JSONObject) leasesJSON.get(i);

				int id = ((Long) leaseObj.get(ID)).intValue();
				int propertyId = ((Long) leaseObj.get(PROPERTY_ID)).intValue();
				String fees = (String) leaseObj.get(FEES);
				String repairs = (String) leaseObj.get(REPAIRS);
				String termination = (String) leaseObj.get(TERMINATION);
				String info = (String) leaseObj.get(INFO);
				boolean signed = (boolean) leaseObj.get(SIGNED);

				Lease lease = new Lease(id, propertyId, fees, repairs, termination, info);
				leaseList.add(lease);

				lease.setSigned(signed);
				lease.setSignedByStudents(getIDs((JSONArray) leaseObj.get(SIGNED_BY_STUDENT_IDS)));
				lease.setSignedByPropertyManager(((Long) leaseObj.get(SIGNED_BY_PROPERTY_MANAGER_ID)).intValue());
			}
			return leaseList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Review> loadReviews() {
		ArrayList<Review> reviewList = new ArrayList<Review>();

		try {
			FileReader reader = new FileReader(REVIEW_FILE_NAME);
			JSONArray reviewJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < reviewJSON.size(); i++) {
				JSONObject reviewObj = (JSONObject) reviewJSON.get(i);

				int id = ((Long) reviewObj.get(ID)).intValue();
				int reviewedId = ((Long) reviewObj.get(REVIEWED)).intValue();
				ReviewType type = ReviewType.valueOf(((String) reviewObj.get(TYPE)).toUpperCase());
				int rating = ((Long) reviewObj.get(RATING)).intValue();
				String username = (String) reviewObj.get(USER_NAME);
				String description = (String) reviewObj.get(DESCRIPTION);

				Review review = new Review(id, reviewedId, type, rating, username, description);
				reviewList.add(review);
			}
			return reviewList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}