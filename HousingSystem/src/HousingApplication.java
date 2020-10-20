import java.util.ArrayList;

public class HousingApplication {
	private PropertyList properties;
	private AccountList accounts;
	
	public HousingApplication() {
		properties = PropertyList.getInstance();
		accounts = AccountList.getInstance();
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
	
	public void createStudentAccount() {
		
	}
	
	public ArrayList<Property> getMyFavoriteProperties() {
		return null;
	}
	
	public ArrayList<Lease> getMySignedLeases() {
		return null;
	}
	
	public void rateProperty(Property property) {
		
	}
	
	public void manageAccount(Student student) {
		
	}
	
	public void createPropertyManagerAccount() {
		
	}
	
}
