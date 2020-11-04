import java.util.ArrayList;
import java.util.Collections;

public class HousingApplication {
	private PropertyList properties;
	private StudentList students;
	private PropertyManagerList propertyManagers;
	private LeaseList leases;
	private ReviewList reviews;

	public HousingApplication() {
		leases = LeaseList.getInstance();
		reviews = ReviewList.getInstance();
		properties = PropertyList.getInstance();
		students = StudentList.getInstance();
		propertyManagers = PropertyManagerList.getInstance();
	}
	
	public int getPropertiesSize() {
		return properties.getSize();
	}
	
	public int getStudentsSize() {
		return students.getSize();
	}
	
	public int getPropertyManagersSize() {
		return propertyManagers.getSize();
	}
	
	public Student getStudent(int id) {
		return students.getStudent(id);
	}

	public PropertyManager getPropertyManager(int id) {
		return propertyManagers.getPropertyManager(id);
	}

	public Property getProperty(int id) {
		return properties.getProperty(id);
	}

	public ArrayList<Property> getProperties() {
		return properties.getProperties();
	}

	public ArrayList<PropertyManager> getPropertyManagers() {
		return propertyManagers.getPropertyManagers();
	}

	public ArrayList<Student> getStudents() {
		return students.getStudents();
	}

	// Returns user with a matching username and password, else null
	public Account logIn(String username, String password)
	{
		Account user = null;
		user = students.getStudent(username, password);
		if(user != null) {
			return user;
		}
		user = propertyManagers.getPropertyManager(username, password);
		if(user != null) {
			return user;
		}
		return null;
	}

	// Returns a string with all the properties in a list
	public String listProperties(ArrayList<Property> list) {
		String ret = "";
		for(Property p : list) {
			ret += p + "\n";
		}
		return ret;
	}
	
	// Returns a string with the short version of the properties in a list
	public String listPropertiesShort(ArrayList<Property> list) {
		String ret = "";
		for(Property p : list) {
			ret += p.shortToString() + "\n";
		}
		return ret;
	}

	// Returns a string with all (viewable) properties. 
	public String viewAllProperties() {
		return listProperties(getProperties());
	}

	// Returns a string with all (viewable) properties' short strings. 
	public String viewAllPropertiesShort() {
		return listPropertiesShort(getProperties());
	}

	// Returns a string with all properties that contain a keyword. 
	public String searchByKeyword(String key) {
		ArrayList<Property> list = new ArrayList<>();
		for(Property p : getProperties()) {
			if(p.toString().contains(key)) {
				list.add(p);
			}
		}
		return listProperties(list);
	}

	// Returns a string with all properties, sorted by price. 
	public String sortByPrice(boolean increasing) {
		ArrayList<Property> list = getProperties();
		if(increasing == true) {
			Collections.sort(list, new SortByPrice());
		} else {
			Collections.sort(list, new SortByPrice().reversed());
		}
		return listProperties(list);
	}

	// Returns a string with all properties, sorted by number of reviews. 
	public String sortByNumReviews(boolean increasing) {
		ArrayList<Property> list = getProperties();
		if(increasing == true) {
			Collections.sort(list, new SortByReviews());
		} else {
			Collections.sort(list, new SortByReviews().reversed());
		}
		return listProperties(list);
	}

	// Returns a string with all properties that have, at least, all the given amenities.
	public String filterByAmenities(boolean[] choices) {
		ArrayList<Property> filtered = new ArrayList<Property>();
		for(Property p : getProperties()) {
			boolean equal = true;
			for(int i = 0; i < choices.length; i++) {
				if(choices[i] && !p.getAmenities()[i]) { 
					// the property does not have the requested amenity
					equal = false;
				}
			}
			if(equal) {
				filtered.add(p);
			}
		}
		return listProperties(filtered);
	}

	// Returns a string with all properties within a price range. 
	public String filterByPriceRange(int min, int max) {
		ArrayList<Property> filtered = new ArrayList<Property>();
		for(Property property : getProperties()) {
			int price = property.getPrice();
			if(price >= min && price <= max) {
				filtered.add(property);
			}
		}
		return listProperties(filtered);
	}

	// Returns a string with a student's favorite properties. 
	public String viewFavProperties(Account user) {
		if(user.type == AccountType.STUDENT) {
			return listProperties(((Student) user).getFavProperties());
		}
		return "No favorite properties.";
	}

	// Returns a string with a user's signed leases. 
	public String viewSignedLeases(Account user) {
		String ret = "";
		ArrayList<Lease> signedLeases = user.getSignedLeases();
		for(Lease l : signedLeases) {
			ret += l.toString();
		}
		return ret;
	}

	// Returns a string with a property manager's properties. 
	public String viewMyProperties(Account user) {
		if(user.type == AccountType.PROPERTYMANAGER) {
			return listProperties(((PropertyManager) user).getMyProperties());
		}
		return "No properties.";
	}
	
	public String viewMyPropertiesShort(Account user) {
		if(user.type == AccountType.PROPERTYMANAGER) {
			return listPropertiesShort(((PropertyManager) user).getMyProperties());
		}
		return "No properties.";
	}
	// Reviews a property and returns that review as a string. 
	public String reviewProperty(Account user, Property property, int rating, String description) {
		int reviewId = reviews.getSize() + 1;
		// add review to review list:
		Review review = reviews.addReview(reviewId, property.getPropertyId(), ReviewType.PROPERTY, rating, user.getUsername(), description);
		// add review to property:
		property.addReview(review);
		return review.toString();
	}

	// Reviews a property manager and returns that review as a string. 
	public String reviewPropertyManager(Account user, PropertyManager propertyManager, int rating, String description) {
		int reviewId = reviews.getSize() + 1;
		// add review to review list:
		Review review = reviews.addReview(reviewId, propertyManager.getID(), ReviewType.PROPERTYMANAGER, rating, user.getUsername(), description);
		// add review to property manager:
		propertyManager.addReview(review);
		return review.toString();
	}

	// Reviews a student and returns that review as a string. 
	public String reviewStudent(Account user, Student student, int rating, String description) {
		int reviewId = reviews.getSize() + 1;
		// add review to review list:
		Review review = reviews.addReview(reviewId, student.getID(), ReviewType.STUDENT, rating, user.getUsername(), description);
		// add review to student:
		student.addReview(review);
		return review.toString();
	}

	// User signs a lease and the lease is returned as a string. 
	public String signLease(Account user, Lease lease) {
		lease.sign(user);
		user.addLease(lease);
		return "Signed lease :" + lease;
	}

	// Returns a string with a short version of all property managers. 
	public String listPropertyManagersShort() {
		String ret = "";
		for(PropertyManager pm : propertyManagers.getPropertyManagers()) {
			ret += pm.getName() + "\n";
		}
		return ret;
	}

	// Returns a string with a short version of all students. 
	public String listStudentsShort() {
		String ret = "";
		for(Student student : students.getStudents()) {
			ret += student.getName() + "\n";
		}
		return ret;
	}

	// Returns a string with the users who have signed a lease. 
	public String getSignedBy(Lease lease) {
		String ret = "Students: \n";
		for(int i : lease.getSignedByStudents()) {
			ret += students.getStudent(i).getName() + "\n";
		}
		ret += "Property Manager: \n";
		ret += lease.getSignedByPropertyManager() + "\n";
		return ret;
	}

	// View reviews for all properties. 
	public String viewPropertyReviews() {
		String ret = "";
		for(Property p : getProperties()) {
			ret += p.shortToString();
			ret += "Reviews:\n";
			for(Review r : p.getReviews()) {
				ret += r;
			}
			ret += "\n";
		}
		return ret;
	}

	// View reviews for all property managers. 
	public String viewPropertyManagerReviews() {
		String ret = "";
		for(PropertyManager pm : getPropertyManagers()) {
			ret += "ID: " + pm.getID() + ", " + pm.getName() + "\n";
			ret += "Reviews:\n";
			for(Review r : pm.getReviews()) {
				ret += r;
			}
			ret += "\n";
		}
		return ret;
	}

	// View reviews for all students. 
	public String viewStudentReviews() {
		String ret = "";
		for(Student s : getStudents()) {
			ret += "ID: " + s.getID() + ", " + s.getName() + "\n";
			ret += "Reviews:\n";
			for(Review r : s.getReviews()) {
				ret += r;
			}
			ret += "\n";
		}
		return ret;
	}

	// Checks if a username is associated with an existing account. 
	public boolean usernameInList(String username) {
		return students.usernameInList(username) || propertyManagers.usernameInList(username);
	}

	// Creates and returns a student. 
	public Student createStudentAccount(String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID) {
		return students.addStudent(username, password, firstName, lastName, emailAddress, phone, studentID);
	}

	// Creates and returns a property manager. 
	public PropertyManager createPropertyManagerAccount(String username, String password, String firstName, String lastName, String emailAddress, String phone) {
		return propertyManagers.addPropertyManager(username, password, firstName, lastName, emailAddress, phone);
	}
	
	// Creates a new property. 
	public String addNewProperty(Account user, String location, boolean[] amenitiesBool, String utilities, int price, int beds, int baths, String description, String contact) {
		Property property = properties.addProperty(amenitiesBool, utilities, location, price, beds, baths, description, contact, true);
		if(user.getAccountType() == AccountType.PROPERTYMANAGER) {
			((PropertyManager) user).addMyProperty(property);
		}
		return "Added property: " + property;
	}
	
	// Adds a favorite property, for a student. 
	public void addFavProperty(Account user, Property property) {
		if(user.getAccountType() == AccountType.STUDENT) {
			((Student) user).addFavoriteProperty(property);
		}
	}
	
	// Sets a property to invisible. 
	public String removeProperty(Property property) {
		return "Removed property: " + properties.removeProperty(property).shortToString();
	}
	
	// Creates a lease for a property. 
	public String addLease(Property property, String fees, String repairs, String termination, String info) {
		int leaseID = leases.getSize() + 1;
		Lease lease = leases.addLease(leaseID, property.getPropertyId(), fees, repairs, termination, info);
		property.setLease(lease);
		return "Added lease: " + lease;
	}

}
