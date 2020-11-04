import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	//used for amenities
	public static JSONArray parseBool(boolean[] arr) {
		JSONArray ret = new JSONArray();
		for (int i = 0; i < arr.length; i++) {
			ret.add(arr[i]);
		}
		return ret;
	}

	public static JSONObject getPropertyManagerJSON(PropertyManager manager) {
		JSONObject propertyManagerDetails = new JSONObject();
		propertyManagerDetails.put(ID, manager.getID());
		propertyManagerDetails.put(USER_NAME, manager.getUsername());
		propertyManagerDetails.put(PASSWORD, manager.getPassword());
		propertyManagerDetails.put(FIRST_NAME, manager.getFirstName());
		propertyManagerDetails.put(LAST_NAME, manager.getLastName());
		propertyManagerDetails.put(EMAIL, manager.getEmailAddress());
		propertyManagerDetails.put(PHONE, manager.getPhone());
		propertyManagerDetails.put(MANAGER_PROPERTY, manager.getMyProperties());
		propertyManagerDetails.put(RATINGS, manager.getRatings());
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
		studentDetails.put(FAVORITES, student.getFavProperties());
		studentDetails.put(RATINGS, student.getRatings());
		studentDetails.put(REVIEWS, student.getReviewIDs());
		studentDetails.put(LEASES, student.getSignedLeaseIDs());

		return studentDetails;
	}

	public static JSONObject getPropertyJSON(Property property) {
		JSONObject propertyDetails = new JSONObject();
		propertyDetails.put(PROPERTY_ID, property.getPropertyId());
		propertyDetails.put(AMENITIES, parseBool(property.getAmenities()));
		propertyDetails.put(UTILITIES, property.getUtilities());
		propertyDetails.put(LOCATION, property.getLocation());
		propertyDetails.put(PRICE, property.getPrice());
		propertyDetails.put(RATINGS, property.getRatings());
		propertyDetails.put(REVIEWS, property.getReviewIDs());
		propertyDetails.put(BEDS, property.getBeds());
		propertyDetails.put(BATHS, property.getBaths());
		propertyDetails.put(LEASES, property.getLeaseID());
		propertyDetails.put(DESCRIPTION, property.getDescription());
		propertyDetails.put(CONTACT, property.getContact());
		propertyDetails.put(VISIBLE, property.isVisible());

		return propertyDetails;
	}

	public static JSONObject getReviewJSON(Review review) {
		JSONObject reviewDetails = new JSONObject();
		reviewDetails.put(ID, review.getId());
		reviewDetails.put(REVIEWED, review.getReviewedId());
		reviewDetails.put(TYPE, review.getType().toString());
		reviewDetails.put(RATING, review.getRating());
		reviewDetails.put(USER_NAME, review.getUsername());
		reviewDetails.put(DESCRIPTION, review.getDescription());

		return reviewDetails;
	}

	public static JSONObject getLeaseJSON(Lease lease) {
		JSONObject leaseDetails = new JSONObject();
		leaseDetails.put(ID, lease.getId());
		leaseDetails.put(PROPERTY_ID, lease.getPropertyID());
		leaseDetails.put(REPAIRS, lease.getRepairs());
		leaseDetails.put(TERMINATION, lease.getTermination());
		leaseDetails.put(INFO, lease.getInfo());
		leaseDetails.put(SIGNED, lease.getSigned());
		leaseDetails.put(SIGNED_BY_STUDENT_IDS, lease.getSignedByStudents());
		leaseDetails.put(SIGNED_BY_PROPERTY_MANAGER_ID, lease.getSignedByPropertyManager());

		return leaseDetails;
	}

	public static void savePropertyManager() {
		PropertyManagerList managers = PropertyManagerList.getInstance();
		ArrayList<PropertyManager> managerList = managers.getPropertyManagers();
		JSONArray managerJson = new JSONArray();

		// creating all the json objects
		for (PropertyManager pm : managerList) {
			managerJson.add(getPropertyManagerJSON(pm));
		}
		// Write JSON file
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

		// creating all the json objects
		for (Student s : studentList) {
			jsonStudents.add(getStudentJSON(s));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {
			file.write(jsonStudents.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveProperty() {
		PropertyList properties = PropertyList.getInstance();
		ArrayList<Property> propertyList = properties.getProperties();
		JSONArray jsonProperty = new JSONArray();

		// creating all the json objects
		for (Property p : propertyList) {
			jsonProperty.add(getPropertyJSON(p));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(PROPERTY_FILE_NAME)) {
			file.write(jsonProperty.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveReview() {
		ReviewList review = ReviewList.getInstance();
		ArrayList<Review> reviewList = review.getReviews();
		JSONArray jsonReview = new JSONArray();

		// creating all the json objects
		for (Review r : reviewList) {
			jsonReview.add(getReviewJSON(r));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(REVIEW_FILE_NAME)) {
			file.write(jsonReview.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveLease() {
		LeaseList lease = LeaseList.getInstance();
		ArrayList<Lease> leaseList = lease.getLeases();
		JSONArray jsonLease = new JSONArray();

		// creating all the json objects
		for (Lease l : leaseList) {
			jsonLease.add(getLeaseJSON(l));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(LEASE_FILE_NAME)) {
			file.write(jsonLease.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void generateLeaseText(Lease in) {
		// get current date
		String date = java.time.LocalDate.now().toString();

		// get name of the property manager (landlord)
		PropertyManager pm = PropertyManagerList.getInstance().getPropertyManager(in.getSignedByPropertyManager());
		String landlord = "";
		if(pm != null) {
			landlord = pm.getName();
		}

		// get names of the students (tenants)
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i : in.getSignedByStudents()) {
			students.add(StudentList.getInstance().getStudent(i));
		}
		String tenant = "";
		boolean first = true;
		for (Student s : students) {
			if (!first) {
				tenant += ", ";
			}
			tenant += s.getName();
			first = false;
		}

		int rent = in.getProperty().getPrice();
		int damage = DAMAGE_COST;
		int beds = in.getProperty().getBeds();
		int baths = in.getProperty().getBaths();
		String address = in.getProperty().getLocation();
		String startDate = START_DATE;
		String endDate = END_DATE;
		String paymentAddress = PAYMENT_ADDRESS;

		String output = "";
		output += "This Lease Agreement is made and entered on " + date + " by and between " + landlord + " and "
				+ tenant + ".\n\n";
		output += "Subject to the terms and conditions stated below the parties agree as follows:\n\n";
		output += "1. Landloard Tenant Act. This Rental Agreement is governed by the South Carolina Residential Landlord and Tenant Act.\n\n";

		output += "2. Property. Landloard, in consideration of the lease payments provided in this agreement, leases to Tenant a house with "
				+ beds + " bedrooms and " + baths + " bathrooms, located at " + address
				+ ". No other portion of the building wherein the Property is located is included unless expressly provided for in this agreement.\n\n";
		output += "3. Term. The Tenant will coninue to pay rent from " + startDate + " to " + endDate + ".\n\n";
		output += "4. Rent. The Tenant will pay " + rent + " each month on the first of the month.\n\n";
		output += "5. Payment should be sent to: " + paymentAddress + ".\n\n";
		output += "6. Damages. Charges will be billed to the client for damaged property, up to $" + damage + ".\n\n";
		output += "7. Signatures\n\n";
		for (Student s : students) {
			output += "--------------\n";
			output += s.getName() + "\n\n";
		}
		output += "--------------\n";
		output += landlord;

		// Write txt file
		try (FileWriter file = new FileWriter(LEASE_TEXT_FILE_NAME)) {
			file.write(output);
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}