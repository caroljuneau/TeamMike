import java.util.ArrayList;

public class HousingApplication {
	private PropertyList properties;
	private AccountList accounts;

	public HousingApplication() {
		//properties = PropertyList.getInstance();
		//accounts = AccountList.getInstance();
	}
	
	public Account logIn(String username, String password)
	{
		// need to return the account with the given username and password
		// if it does not exist, print out an error message and return null
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

	public void createStudentAccount() {

	}

	public void createPropertyManagerAccount() {

	}

}
