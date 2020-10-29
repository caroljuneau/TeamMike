import java.util.ArrayList;
import java.util.Collections;

public class HousingApplication {
	private PropertyList properties;
	private StudentList students;
	private PropertyManagerList propertyManagers;

	public HousingApplication() {
		properties = PropertyList.getInstance();
		students = StudentList.getInstance();
		propertyManagers = PropertyManagerList.getInstance();
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
