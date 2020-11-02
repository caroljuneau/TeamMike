import java.util.ArrayList;
import java.util.Collections;

public class HousingApplication {
	private PropertyList properties;
	private StudentList students;
	private PropertyManagerList propertyManagers;
	private LeaseList leases;
	private ReviewList reviews;

	public HousingApplication() {
		properties = PropertyList.getInstance();
		students = StudentList.getInstance();
		propertyManagers = PropertyManagerList.getInstance();
		leases = LeaseList.getInstance();
		reviews = ReviewList.getInstance();
	}

	public Account logIn(String username, String password)
	{
		//first check students
		Account user = null;
		user = students.getStudent(username, password);
		if(user != null) {
			return user;
		}
		//then check property managers
		user = propertyManagers.getPropertyManager(username, password);
		if(user != null) {
			return user;
		}
		//if not found, return null
		return null;
	}

	public ArrayList<Property> allProperties() {
		return properties.getProperties();
	}

	public ArrayList<PropertyManager> allPropertyManagers() {
		return propertyManagers.getPropertyManagers();
	}

	public ArrayList<Student> allStudents() {
		return students.getStudents();
	}

	public String listProperties(ArrayList<Property> list) {
		String ret = "";
		for(Property property : list) {
			ret += property.toString() + "\n";
		}
		return ret;
	}

	public String listPropertiesShort(ArrayList<Property> list) {
		String ret = "";
		for(Property property : list) {
			ret += property.shortToString() + "\n";
		}
		return ret;
	}

	public String viewAllProperties() {
		return listProperties(allProperties());
	}

	public String viewAllPropertiesShort() {
		return listPropertiesShort(allProperties());
	}

	public String searchByKeyword(String key) {
		ArrayList<Property> list = allProperties();
		//TODO
		return listProperties(list);
	}

	public String sortByPrice(boolean increasing) {
		ArrayList<Property> list = allProperties();
		//TODO Test
//		Collections.copy(list, allProperties());
		if(increasing == true) {
			Collections.sort(list, new SortByPrice());
		} else {
			Collections.sort(list, new SortByPrice().reversed());
		}
		return listProperties(list);
	}

	public String sortByNumReviews(boolean increasing) {
		//TODO Test
		ArrayList<Property> list = allProperties();
//		Collections.copy(list, allProperties());
		if(increasing == true) {
			Collections.sort(list, new SortByReviews());
		} else {
			Collections.sort(list, new SortByReviews().reversed());
		}
		return listProperties(list);
	}

	public String filterByAmenities(boolean[] choices) {
		//TODO check if it works when fixed in dataloader
		ArrayList<Property> filtered = new ArrayList<Property>();
		for(Property property : allProperties()) {
			if(choices.equals(property.getAmenities())) {
				filtered.add(property);
			}
		}
		return listProperties(filtered);
	}

	public String filterByPriceRange(int min, int max) {
		ArrayList<Property> filtered = new ArrayList<Property>();
		for(Property property : allProperties()) {
			int price = property.getPrice();
			if(price >= min && price <= max) {
				filtered.add(property);
			}
		}
		return listProperties(filtered);
	}

	public String viewFavProperties(Account user) {
		if(user.type == AccountType.STUDENT) {
			return listProperties(((Student) user).getFavProperties());
		}
		return "No favorite properties.";
	}

	public String viewSignedLeases(Account user) {
		String ret = "";
		ArrayList<Lease> signedLeases = user.getSignedLeases();
		for(Lease l : signedLeases) {
			ret += l.toString();
		}
		return ret;
	}

	public String viewMyProperties(Account user) {
		if(user.type == AccountType.PROPERTYMANAGER) {
			return listProperties(((PropertyManager) user).getMyProperties());
		}
		return "No properties.";
	}

	public void reviewProperty(Account user, Property property, int rating, String description) {
		int reviewId = ReviewList.getInstance().getSize();
		// add review to review list:
		Review review = reviews.addReview(reviewId + 1, property.getPropertyId(), ReviewType.PROPERTY, rating, user.getUsername(), description);
		// add review to property:
		property.addReview(review);
	}

	public void reviewPropertyManager(Account user, PropertyManager propertyManager, int rating, String description) {
		int reviewId = ReviewList.getInstance().getSize();
		// add review to review list:
		Review review = reviews.addReview(reviewId + 1, propertyManager.getID(), ReviewType.PROPERTYMANAGER, rating, user.getUsername(), description);
		// add review to property manager:
		propertyManager.addReview(review);
	}

	public void reviewStudent(Account user, Student student, int rating, String description) {
		int reviewId = ReviewList.getInstance().getSize();
		// add review to review list:
		Review review = reviews.addReview(reviewId + 1, student.getID(), ReviewType.STUDENT, rating, user.getUsername(), description);
		// add review to student:
		student.addReview(review);
	}

	public void signLease(Account user, Lease lease) {
		lease.sign(user);
		user.addLease(lease);
	}

	public ArrayList<Property> getPropertiesWithLeases() {
		ArrayList<Property> list = new ArrayList<Property>();
		for(Property property : allProperties()) {
			if(property.getLease() != null) {
				list.add(property);
			}
		}
		return list;
	}

	public String viewPropertiesWithLeases() {
		return listPropertiesShort(getPropertiesWithLeases());
	}

	public int getNumOfPropertiesWithLeases() {
		return getPropertiesWithLeases().size();
	}

	public String listPropertyManagersShort() {
		String ret = "";
		for(PropertyManager pm : propertyManagers.getPropertyManagers()) {
			ret += pm.shortToString() + "\n";
		}
		return ret;
	}

	public String listStudentsShort() {
		String ret = "";
		for(Student student : students.getStudents()) {
			ret += student.shortToString() + "\n";
		}
		return ret;
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

	public String getSignedBy(Lease lease) {
		String ret = "Students: \n";
		for(Student s : lease.getSignedByStudents()) {
			ret += s.getName() + "\n";
		}
		ret += "Property Managers: \n";
		for(PropertyManager pm : lease.getSignedByPropertyManagers()) {
			ret += pm.getName() + "\n";
		}
		return ret;
	}

	public String viewPropertyReviews() {
		String ret = "";
		for(Property property : allProperties()) {
			ret += property.shortToString() + "\n";
			ret += "Reviews:\n";
			for(Review review : property.getReviews()) {
				ret += review.toString();
			}
			ret += "\n";
		}
		return ret;
	}

	public String viewPropertyManagerReviews() {
		String ret = "";
		for(PropertyManager pm : allPropertyManagers()) {
			ret += pm.shortToString() + "\n";
			ret += "Reviews:\n";
			for(Review review : pm.getReviews()) {
				ret += review.toString();
			}
			ret += "\n";
		}
		return ret;
	}

	public String viewStudentReviews() {
		String ret = "";
		for(Student s : allStudents()) {
			ret += s.shortToString() + "\n";
			ret += "Reviews:\n";
			for(Review review : s.getReviews()) {
				ret += review.toString();
			}
			ret += "\n";
		}
		return ret;
	}

	public boolean usernameInList(AccountType type, String username) {
		return students.usernameInList(username) || propertyManagers.usernameInList(username);
	}

	public void createStudentAccount(String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID) {
		students.addStudent(username, password, firstName, lastName, emailAddress, phone, studentID);
	}

	public void createPropertyManagerAccount(String username, String password, String firstName, String lastName, String emailAddress, String phone) {
		propertyManagers.addPropertyManager(username, password, firstName, lastName, emailAddress, phone);
	}
	public void addNewProperty(Account user, String location, boolean[] amenitiesBool, String utilities, int price, int beds, int baths, String description, String contact) {
		Property property = properties.addProperty(amenitiesBool, utilities, location, price, beds, baths, description, contact, true);
		if(user.getAccountType() == AccountType.PROPERTYMANAGER) {
			((PropertyManager) user).addMyProperty(property);
		}
	}
	public void addFavProperty(Account user, Property property) {
		if(user.getAccountType() == AccountType.STUDENT) {
			((Student) user).addFavoriteProperty(property);
		}
	}
	
	public boolean deleteProperty(Property property) {
		return properties.removeProperty(property);
	}
	
	public void addLease(Property property, String fees, String repairs, String termination, String info) {
		int leaseID = LeaseList.getInstance().getSize();
		Lease lease = leases.addLease(leaseID, property.getPropertyId(), fees, repairs, termination, info);
		property.setLease(lease);
	}

}
