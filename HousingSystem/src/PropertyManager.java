import java.util.ArrayList;

public class PropertyManager extends Account {

	private ArrayList<Property> myProperties;
	
	public PropertyManager(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.type = AccountType.PROPERTYMANAGER;
		this.myProperties = null;
		this.ratings = null;
		this.reviews = null;
		this.signedLeases = null;
	}
	
	public PropertyManager() {
		// TODO Auto-generated constructor stub
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
}
