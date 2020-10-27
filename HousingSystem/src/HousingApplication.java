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
			ret += property.toString() + '\n';
		}
		return ret;
	}

//
//	public ArrayList<Property> sortByPrice(boolean increasing) {
//		ArrayList<Property> sortPrice = new ArrayList<Property>();
//		if(increasing == true) {
//			Collections.sort(sortPrice, Collections.reverseOrder().reversed());
//		} else {
//			Collections.sort(sortPrice, Collections.reverseOrder());
//		}
//		return sortPrice;
//	}

//	public ArrayList<Property> sortByNumReviews(boolean increasing) {
//		ArrayList<Property> sortReviews = new ArrayList<Property>();
//			if(increasing == true) {
//				Collections.sort(sortReviews, Collections.reverseOrder().reversed());
//			} else {
//				Collections.sort(sortReviews, Collections.reverseOrder());
//			}
//			return sortReviews;
//	}

	public String filterByAmenities(boolean pool, boolean gym, boolean pets, boolean laundry, boolean shuttle) {
		//need to fix
		ArrayList<Property> listData = new ArrayList<Property>();
//		for(Property data : listData) {
//			//something wrong here: type mismatch on amenities boolean/string[]
//			if(data.getAmenities() != null) {
//				listData.add(data);
//			}
//		}
		return listProperties(listData);
	}

	public String filterByPriceRange(int min, int max) {
		ArrayList<Property> output = new ArrayList<Property>();
		for(int i=0; i<properties.getSize(); ++i) {
			Property property = properties.getProperty(i);
			int price = property.getPrice();
			if(price >= min && price <= max) {
				output.add(property);
			}
		}
		return listProperties(output);
	}

	// what is sort by keyword? just search by keyword?
	public String sortByKeyword(String key, ArrayList<Property> list) {
		//need to fix
		ArrayList<Property> sort = new ArrayList<Property>();
//	    for(Property string : list){
//	        if(string.matches(key)){
//	            sort.add(string);
//	        }
//	    }
	    return listProperties(sort);
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
