import java.util.ArrayList;

public class Student extends Account {
	
	private ArrayList<Property> favoriteProperties;
	private ArrayList<Integer> favoriteIDs;
	//private int[] favoriteIDs;
	private String studentID;
	
	public Student(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID)
	{
		super(id, username, password, firstName, lastName, emailAddress, phone);
		this.studentID = studentID;
		this.favoriteProperties = null;
		this.type = AccountType.STUDENT;
	}

	public void setFavoriteIDs(ArrayList<Integer> arr) {
		this.favoriteIDs = arr;
	}
	public ArrayList<Integer> getFavoriteIDs() {
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
		//TODO grab the favoriteProperties array and populate it with the new favorite property by that specific studentID
//		for(int i = 0; i < this.favoriteIDs.length; i++)
//		{
//			if(this.favoriteIDs[i] == null)
//			{
//				favoriteIDs[i] = property.propertyId;
//				return;
//			}
//		}
		//public void addStudent(String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID)
		//int id = students.size() + 1;
		//students.add(new Student(id, username, password, firstName, lastName, emailAddress, phone, studentID));
	}
	
	public ArrayList<Property> getFavoriteProperties()
	{
		return this.favoriteProperties;
	}
	
	public void removeFavoriteProperty(Property property)
	{
//		for(int i = 0; i < favoriteProperties; i++)
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
