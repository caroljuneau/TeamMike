import java.util.ArrayList;

public class PropertyManager extends Account {

	private ArrayList<Property> myProperties;
	private ArrayList<Integer> myPropertyIDs;
	
	public PropertyManager(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone)
	{
		super(id, username, password, firstName, lastName, emailAddress, phone);
		this.myProperties = null;
		this.type = AccountType.PROPERTYMANAGER;
	}
	public ArrayList<Integer> getMyPropertyIDs() {
		return myPropertyIDs;
	}

	public void setMyPropertyIDs(ArrayList<Integer> myPropertyIDs) {
		this.myPropertyIDs = myPropertyIDs;
	}
	
	public void createProperty(ArrayList<String> amenities, String utilities, String location, ArrayList<String> pictures, int price, ArrayList<Review> reviews, int beds, int baths, Lease lease, String description, String contact, boolean signedLease)
	{
		
	}
	
	public void addMyProperty(Property property)
	{
		
	}
	
	public void createLease(Property property)
	{
		
	}
	
	public void deleteProperty(Property property)
	{
		
	}
	
	public void editProperty(Property property)
	{
		
	}
	
	public void reviewStudent(Student student, int rating, String username, String review)
	{
		
	}
	public String toString() {
		String s;
		s = super.toString();
		return s;
	}

}
