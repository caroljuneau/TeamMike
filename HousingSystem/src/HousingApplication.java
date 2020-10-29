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
		ArrayList<Property> list = null;
		Collections.copy(list, allProperties());
		if(increasing == true) {
			Collections.sort(list, Collections.reverseOrder().reversed());
		} else {
			Collections.sort(list, Collections.reverseOrder());
		}
		return listProperties(list);
	}
	
	public String sortByNumReviews(boolean increasing) {
		ArrayList<Property> list = null;
		Collections.copy(list, allProperties());
		if(increasing == true) {
			Collections.sort(list, Collections.reverseOrder().reversed());
		} else {
			Collections.sort(list, Collections.reverseOrder());
		}
		return listProperties(list);
	}
	
	public String listProperties(ArrayList<Property> properties) {
		String ret = "";
		for(Property property : properties) {
			ret += property.toString() + "\n";
		}
		return ret;
	}
	
	public ArrayList<Property> getPropertiesWithLeases() {
		ArrayList<Property> list = null;
		for(Property property : allProperties()) {
			if(property.getLeaseIDs() != null) {
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
	
	public String listPropertiesShort(ArrayList<Property> properties) {
		String ret = "";
		for(Property property : properties) {
			ret += property.shortToString() + "\n";
		}
		return ret;
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

	public String filterByAmenities(boolean[] choices) {
		//TODO need to test
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
		//TODO need to test
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
			ArrayList<Integer> favIDs = ((Student) user).getFavoriteIDs();
			String ret = "";
			for(int i = 0; i < favIDs.size(); i++) {
				ret += properties.getProperty(i) + "\n";
			}
			return ret;
		}
		return "";
	}
	
	public String viewMyProperties(Account user) {
		if(user.type == AccountType.PROPERTYMANAGER) {
			ArrayList<Integer> myIDs = ((PropertyManager) user).getMyPropertyIDs();
			String ret = "";
			for(int i = 0; i < myIDs.size(); i++) {
				ret += properties.getProperty(i) + "\n";
			}
			return ret;
		}
		return "";
	}
	
	public String viewSignedLeases(Account user) {
		ArrayList<Integer> leaseIDs = user.getSignedLeaseIDs();
		String ret = "";
		for(int i = 0; i < leaseIDs.size(); i++) {
			//TODO
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
		for(int i : lease.getSignedByStudentIds()) {
			ret += getStudent(i).getName() + "\n";
		}
		ret += "Property Managers: \n";
		for(int i : lease.getSignedByPropertyManagerIds()) {
			ret += getPropertyManager(i).getName() + "\n";
		}
		return ret;
	}
	
	public int getNumOfProperties() {
		return properties.getSize();
	}
	
	public int getNumOfStudents() {
		return students.getSize();
	}
	
	public int getNumOfPropertyManagers() {
		return propertyManagers.getSize();
	}
	
	public void signLease(Account user, int propertyId) {
		properties.getProperty(propertyId).getLease().sign(user);
	}
	
	public void reviewProperty(Account user, int propertyId, int rating, String review) {
		int reviewId = reviews.addReview(propertyId, ReviewType.PROPERTY, rating, user.getUsername(), review);
		properties.getProperty(propertyId).addReview(reviewId);
	}
	
	public void reviewPropertyManager(Account user, int propertyManagerId, int rating, String review) {
		int reviewId = reviews.addReview(propertyManagerId, ReviewType.PROPERTYMANAGER, rating, user.getUsername(), review);
		propertyManagers.getPropertyManager(propertyManagerId).addReview(reviewId);
	}
	
	public void reviewStudent(Account user, int studentId, int rating, String review) {
		int reviewId = reviews.addReview(studentId, ReviewType.STUDENT, rating, user.getUsername(), review);
		students.getStudent(studentId).addReview(reviewId);
	}

	public boolean usernameInList(AccountType type, String username) {
		if(students.usernameInList(username) || propertyManagers.usernameInList(username)) {
			return true;
		}
		return false;
	}

	public void createStudentAccount(String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID) {
		students.addStudent(username, password, firstName, lastName, emailAddress, phone, studentID);
	}

	public void createPropertyManagerAccount(String username, String password, String firstName, String lastName, String emailAddress, String phone) {
		propertyManagers.addPropertyManager(username, password, firstName, lastName, emailAddress, phone);
	}

}
