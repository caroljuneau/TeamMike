import java.util.ArrayList;

public class HousingApplication {
	private Property properties;
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
		ArrayList<Property> listprop = new ArrayList<Property>();
		for(Property prop:listprop)
		// list all the properties from the given arraylist
		return null;//NOT DONE
		return null;
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
		ArrayList<Property> sortPrice = new ArrayList<Property>();
		if(increasing == true) {
			Collections.sort(sortPrice, Collections.reverseOrder().reversed());
		} else {
			Collections.sort(sortPrice, Collections.reverseOrder());
		}
		return sortPrice;
	}

	public ArrayList<Property> sortByNumReviews(boolean increasing) {
		ArrayList<Property> sortReviews = new ArrayList<Property>();
			if(increasing == true) {
				Collections.sort(sortReviews, Collections.reverseOrder().reversed());
			} else {
				Collections.sort(sortReviews, Collections.reverseOrder());
			}
			return sortReviews;
	}

	public ArrayList<Property> filterByAmenities(boolean pool, boolean gym, boolean pets, boolean laundry, boolean shuttle) {
		ArrayList<Property> listData = new ArrayList<Property>();
		for(Property data : listData) {
			//something wrong here: type mismatch on amenities boolean/string[]
			if(data.getAmenities() != null) {
				listData.add(data);
			}
		}
		return listData;
	}

	public ArrayList<Property> filterByPriceRange(int min, int max) {
		ArrayList<Property> output = new ArrayList<Property>();
		for(int i=0; i<properties.getSize(); ++i) {
			Property property = properties.get(i);
			int price = property.getPrice();
			if(price >= min && price <= max) {
				output.add(property);
			}
		}
		return output;
	}

	public ArrayList<Property> sortByKeyword(String key, ArrayList<Property> list) {
		ArrayList<Property> sort = new ArrayList<Property>();
	    for(Property string : list){
	        if(string.matches(key)){
	            sort.add(string);
	        }
	    }
	    return sort;
	}

	public Student createStudentAccount() {
		return null;
	}

	public PropertyManager createPropertyManagerAccount() {
		return null;
	}

}
