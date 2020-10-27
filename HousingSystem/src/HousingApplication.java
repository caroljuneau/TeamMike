import java.util.ArrayList;

public class HousingApplication {
	private PropertyList properties;
	private StudentList students;
	private PropertyManagerList propertyManagers;

	public HousingApplication() {
		//properties = PropertyList.getInstance();
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

	public String listProperties(ArrayList<Property> properties) {
		// list all the properties from the given arraylist
		return "";
	}

	public ArrayList<Property> getAllProperties() {
		return null;
	}

	public ArrayList<Property> searchProperties(String key) {
		return null;
	}

	public ArrayList<Property> sortByDistance(boolean increasing) {
		// can sort by distance increasing (true) or decreasing (false)
		return null;
	}

	public ArrayList<Property> sortByPrice(boolean increasing) {
		return null;
	}

	public ArrayList<Property> sortByNumReviews(boolean increasing) {
		return null;
	}

	public ArrayList<Property> filterByAmenities(boolean pool, boolean gym, boolean pets, boolean laundry, boolean shuttle) {
		return null;
	}

	public ArrayList<Property> filterByPriceRange(int min, int max) {
		return null;
	}

	//public ArrayList<Property> sortByKeyword(String key, ArrayList<Property> list) {
		/**
		 * Sort class. Currently commented out because code is broken due to no data.
		 */
		//ArrayList<Property> sort = new ArrayList<Property>();
	    //for(Property string : list){
	    //    if(string.matches(key)){
	    //        sort.add(string);
	    //    }
	    //}
	    //return sort;
	//}
	
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
