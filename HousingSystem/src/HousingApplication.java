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
	
	public String listProperties(ArrayList<Property> list) {
		String ret = "";
		for(Property property : list) {
			ret += property.toString() + "\n\n";
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
		//TODO FIX
//		Collections.copy(list, allProperties());
		if(increasing == true) {
			Collections.sort(list, Collections.reverseOrder().reversed());
		} else {
			Collections.sort(list, Collections.reverseOrder());
		}
		return listProperties(list);
	}
	
	public String sortByNumReviews(boolean increasing) {
		//TODO FIX
		ArrayList<Property> list = allProperties();
//		Collections.copy(list, allProperties());
		if(increasing == true) {
			Collections.sort(list, Collections.reverseOrder().reversed());
		} else {
			Collections.sort(list, Collections.reverseOrder());
		}
		return listProperties(list);
	}

	public String filterByAmenities(boolean[] choices) {
		//TODO check if it works when fixed in dataloader
		ArrayList<Property> filtered = new ArrayList<Property>();
		for(int i = 0; i < properties.getSize(); i++) {
			Property property = properties.getProperty(i);
			boolean[] actualAmenities = property.getAmenities();
			if(choices.equals(actualAmenities)) {
				filtered.add(property);
			}
		}
		return listProperties(filtered);
	}

	public String filterByPriceRange(int min, int max) {
		ArrayList<Property> filtered = new ArrayList<Property>();
		for(int i=0; i<properties.getSize(); ++i) {
			Property property = properties.getProperty(i);
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
	
	public void signLease(Account user, Property property) {
		
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
//	
	public void signLease(Account user, int propertyId) {
//		properties.getProperty(propertyId).getLease().sign(user);
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

}
