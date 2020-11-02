import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{

	public static JSONObject getPropertyManagerJSON(PropertyManager manager) {
		JSONObject propertyManagerDetails = new JSONObject();
		propertyManagerDetails.put(ID, manager.getID());
		propertyManagerDetails.put(USER_NAME, manager.getUsername());
		propertyManagerDetails.put(PASSWORD, manager.getPassword());
		propertyManagerDetails.put(FIRST_NAME, manager.getFirstName());
		propertyManagerDetails.put(LAST_NAME, manager.getLastName());
		propertyManagerDetails.put(EMAIL, manager.getEmailAddress());
		propertyManagerDetails.put(PHONE, manager.getPhone());
		propertyManagerDetails.put(MANAGER_PROPERTY, manager.getMyPropertyIDs());
		propertyManagerDetails.put(RATINGS, manager.getRating());
		propertyManagerDetails.put(REVIEWS, manager.getReviewIDs());
		propertyManagerDetails.put(LEASES, manager.getSignedLeaseIDs());

		return propertyManagerDetails;
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
		studentDetails.put(FAVORITES, student.getFavoriteIDs());
		studentDetails.put(RATINGS, student.getRating());
		studentDetails.put(REVIEWS, student.getReviewIDs());
		studentDetails.put(LEASES, student.getSignedLeaseIDs());

		return studentDetails;
	}
	public static JSONObject getPropertyJSON(Property property) {
		JSONObject propertyDetails = new JSONObject();
		propertyDetails.put(PROPERTY_ID, property.getPropertyId());
		propertyDetails.put(AMENITIES, property.getAmenities());
		propertyDetails.put(UTILITIES, property.getUtilities());
		propertyDetails.put(LOCATION, property.getLocation());
		//propertyDetails.put(PICTURES, property.getPictures());
		propertyDetails.put(PRICE, property.getPrice());
		propertyDetails.put(RATINGS, property.getRatings());
		propertyDetails.put(REVIEWS, property.getReviewIDs());
		propertyDetails.put(BEDS, property.getBeds());
		propertyDetails.put(BATHS, property.getBaths());
		propertyDetails.put(LEASES, property.getLeaseIDs());
		propertyDetails.put(DESCRIPTION, property.getDescription());
		propertyDetails.put(CONTACT, property.getContact());
		propertyDetails.put(VISIBLE, property.isVisible());

		return propertyDetails;
	}
	public static JSONObject getReviewJSON(Review review) {
		JSONObject reviewDetails = new JSONObject();
		reviewDetails.put(ID, review.getId());
		reviewDetails.put(REVIEWED, review.getReviewedId());
		reviewDetails.put(TYPE, review.getType());
		reviewDetails.put(RATING, review.getRating());
		reviewDetails.put(USER_NAME, review.getUsername());

		return reviewDetails;
	}
	public static JSONObject getLeaseJSON(Lease lease) {
		JSONObject leaseDetails = new JSONObject();
		leaseDetails.put(ID, lease.getId());
		leaseDetails.put(PROPERTY_ID, lease.getPropertyID());
		// fill out rest after redesign

		return leaseDetails;
	}
	
	public static void savePropertyManager(PropertyManager m) {
//		manager = getPropertyManagerJSON(m);
//		managerJson.add(manager);
		PropertyManagerList managers = PropertyManagerList.getInstance();
		ArrayList<PropertyManager> managerList = managers.getPropertyManagers();
		JSONArray managerJson = new JSONArray();

		//creating all the json objects
		for(int i = 0; i < managerList.size(); i++) {
			managerJson.add(getPropertyManagerJSON(managerList.get(i)));
		}
		//Write JSON file
		try (FileWriter file = new FileWriter(MANAGER_FILE_NAME)) {
			file.write(managerJson.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveStudent() {
		StudentList students = StudentList.getInstance();
		ArrayList<Student> studentList = students.getStudents();
		JSONArray jsonStudents = new JSONArray();

		//creating all the json objects
		for(int i = 0; i < studentList.size(); i++) {
			jsonStudents.add(getStudentJSON(studentList.get(i)));
		}

		//Write JSON file
		try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {
			file.write(jsonStudents.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveProperty() {
		PropertyList properties = PropertyList.getInstance();
		ArrayList<Property> propertyList = properties.getPropertyList();
		JSONArray jsonProperty = new JSONArray();

		//creating all the json objects
		for(int i = 0; i < propertyList.size(); i++) {
			jsonProperty.add(getPropertyJSON(propertyList.get(i)));
		}

		//Write JSON file
		try (FileWriter file = new FileWriter(PROPERTY_FILE_NAME)) {
			file.write(jsonProperty.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//TODO saveReview
	public static void saveReview() {
		ReviewList review = ReviewList.getInstance();
		ArrayList<Review> reviewList = review.getReviews();
		JSONArray jsonProperty = new JSONArray();

		//creating all the json objects
		for(int i = 0; i < reviewList.size(); i++) {
			jsonProperty.add(getPropertyJSON(reviewList.get(i)));
		}

		//Write JSON file
		try (FileWriter file = new FileWriter(PROPERTY_FILE_NAME)) {
			file.write(jsonProperty.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//TODO saveLease
	public static void saveLease() {
		LeaseList lease = LeaseList.getInstance();
		ArrayList<Lease> leaseList = lease.getLeases();
		JSONArray jsonProperty = new JSONArray();

		//creating all the json objects
		for(int i = 0; i < leaseList.size(); i++) {
			jsonProperty.add(getPropertyJSON(leaseList.get(i)));
		}

		//Write JSON file
		try (FileWriter file = new FileWriter(PROPERTY_FILE_NAME)) {
			file.write(jsonProperty.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void deleteProperty() {

	}
}