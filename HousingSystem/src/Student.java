import java.util.ArrayList;

public class Student extends Account {
	
	private ArrayList<Property> favoriteProperties;
	private int[] favoriteIDs;
	private String studentID;
	
	public Student(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID)
	{
		super(id, username, password, firstName, lastName, emailAddress, phone);
		this.studentID = studentID;
		this.favoriteProperties = null;
		this.type = AccountType.STUDENT;
	}

	public void setFavoriteIDs(int[] arr) {
		this.favoriteIDs = arr;
	}
	public int[] getFavoriteIDs() {
		return this.favoriteIDs;
	}
	public String getStudentId() {
		return this.studentID;
	}
	public void setStudentId(String studentId) {
		this.studentID = studentId;
	}
	
	public void addFavoriteProperty(Property property)
	{
		
	}
	
	public ArrayList<Property> getFavoriteProperties()
	{
		return null;
	}
	
	public void removeFavoriteProperty(Property property)
	{
		
	}
	
	public void reviewProperty(Property property, int rating, String username, String review)
	{
		
	}
	
	public void reviewPropertyManager(PropertyManager propertyManager, int rating, String username, String review)
	{
		
	}
	public String toString() {
		String s;
		s = super.toString();
		return s;
	}
}
