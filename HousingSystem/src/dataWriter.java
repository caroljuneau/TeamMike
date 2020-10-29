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
	//TODO getReviewJSON
	//TODO getLeaseJSON

	public static void savePropertyManager() {
		PropertyManagerList managers = PropertyManagerList.getInstance();
		ArrayList<PropertyManager> propertyManagers = managers.getPropertyManagers();
		JSONArray jsonPropertyManagers = new JSONArray();

		//creating all the json objects
		for(int i = 0; i < propertyManagers.size(); i++) {
			jsonPropertyManagers.add(getPropertyManagerJSON(propertyManagers.get(i)));
		}

		//Write JSON file
		try (FileWriter file = new FileWriter(MANAGER_FILE_NAME)) {
			file.write(jsonPropertyManagers.toJSONString());
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
		Review review = Review.getInstance();
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
		Lease lease = Lease.getInstance();
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
