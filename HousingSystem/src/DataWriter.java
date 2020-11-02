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
		studentDetails.put(FAVORITES, student.getFavoriteIDs());
		studentDetails.put(RATINGS, student.getRatings());
		studentDetails.put(REVIEWS, student.getReviewIDs());
		studentDetails.put(LEASES, student.getSignedLeaseIDs());

		return studentDetails;
	}
	public static JSONObject getPropertyJSON(Property property) {
		JSONObject propertyDetails = new JSONObject();
		propertyDetails.put(PROPERTY_ID, property.getPropertyId());
		propertyDetails.put(PROPERTY_MANAGER_ID, property.getPropertyManagerId());
		propertyDetails.put(AMENITIES, property.getAmenities());
		propertyDetails.put(UTILITIES, property.getUtilities());
		propertyDetails.put(LOCATION, property.getLocation());
		//propertyDetails.put(PICTURES, property.getPictures());
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
		reviewDetails.put(TYPE, review.getType());
		reviewDetails.put(RATING, review.getRating());
		reviewDetails.put(USER_NAME, review.getUsername());

		return reviewDetails;
	}
	public static JSONObject getLeaseJSON(Lease lease) {
		JSONObject leaseDetails = new JSONObject();
		leaseDetails.put(ID, lease.getId());
		leaseDetails.put(PROPERTY_ID, lease.getPropertyID());
		leaseDetails.put(FEES, lease.getFees());
		leaseDetails.put(REPAIRS, lease.getRepairs());
		leaseDetails.put(TERMINATION, lease.getTermination());
		leaseDetails.put(INFO, lease.getInfo());
		leaseDetails.put(SIGNED, lease.getSigned());
		leaseDetails.put(SIGNED_BY_STUDENT_IDS, lease.getSignedByStudentIds());
		leaseDetails.put(SIGNED_BY_PROPERTY_MANAGER_IDS, lease.getSignedByPropertyManagerIds());

		return leaseDetails;
	}
	
	public static void savePropertyManager() {
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
		ArrayList<Property> propertyList = properties.getProperties();
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
		JSONArray jsonReview = new JSONArray();

		//creating all the json objects
		for(int i = 0; i < reviewList.size(); i++) {
			jsonReview.add(getReviewJSON(reviewList.get(i)));
		}

		//Write JSON file
		try (FileWriter file = new FileWriter(PROPERTY_FILE_NAME)) {
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

		//creating all the json objects
		for(int i = 0; i < leaseList.size(); i++) {
			jsonLease.add(getLeaseJSON(leaseList.get(i)));
		}

		//Write JSON file
		try (FileWriter file = new FileWriter(PROPERTY_FILE_NAME)) {
			file.write(jsonLease.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void generateLeaseText(Lease in) {
//		String landlord = in.getManager();
	// TODO add landlord/propertyManager id to json
	/**
	 * This method is to grab String landloard which is the propertyManager associated to the properties
	 * first+last name.
	 * Grab tenant, student signing first/last name.
	 * Int RENT, Int Damage, Int Cost are all equal to the properties price.
	 * Then output to txt file:
	 */
		String landlord = in.getProperty().getPropertyManager();
		String tenant = "TENANT";
		String date = java.time.LocalDate.now().toString();
		int rent = in.getProperty().getPrice();
		int damage = rent; 
		int cost = rent;
		int beds = in.getProperty().getBeds();
		int baths = in.getProperty().getBaths();
		String address = in.getProperty().getLocation();
		String startDate = in.getStartDate();
		String endDate = in.getEndDate();
		
		
		String output = "";
		output += "This Lease Agreement is made and entered on <DATE> by and between <LANDLOARD> and <TENANT(s)>\n\n";
		output += "Subject to the terms and conditions stated below the parties agree as follows:\n\n";
		output += "1. Landloard Tenant Act. This Rental Agreement is governed by the South Carolina Residential Landlord and Tenant Act.\n\n";
		
		output += "2. Property. Landloard, in consideration of the lease payments provided in this agreement, leases to Tenant a house with "+beds+" bedrooms and " +baths+
				" bathrooms, located at " +address+". No other portion of the building wherein the Property is located is included unless expressly provided for in this agreement.\n\n";
		output += "3. Term. The Tenant will coninue to pay rent from "+ startDate +" to "+endDate+".\n\n";
		output += "4. Rent. The Tenant will pay "+rent+" each month on the first of the month.\n\n";
		output += "5. Payment should be sent to:<PAYMENT ADDRESS>\n\n";
		output += "6. Damages. Charges will be billed to the client for damaged property, up to <DAMAGE COST>\n\n";
		
		//Write txt file
		try (FileWriter file = new FileWriter(LEASE_TEXT_FILE_NAME)) {
			file.write(output);
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}