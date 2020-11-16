import java.util.ArrayList;

public class Student extends Account {
	
//	private ArrayList<Integer> favoriteIDs;
	private ArrayList<Property> favProperties;
	private String studentID;
	
	public Student(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID)
	{
		super(id, username, password, firstName, lastName, emailAddress, phone);
		this.type = AccountType.STUDENT;
		this.favProperties = new ArrayList<Property>();
		this.studentID = studentID;
	}
	
	public void setFavProperties(ArrayList<Integer> favIDs) {
		for(int i = 0; i < favIDs.size(); i++) {
			int id = favIDs.get(i);
			favProperties.add(PropertyList.getInstance().getProperty(id));
		}
	}
	
	public ArrayList<Property> getFavProperties() {
		return favProperties;
	}

//	public void setFavoriteIDs(ArrayList<Integer> arr) {
//		this.favoriteIDs = arr;
//	}
	public ArrayList<Integer> getFavoriteIDs() {
		ArrayList<Integer> favoriteIDs = new ArrayList<Integer>();
		for(int i = 0; i < favProperties.size(); i++) {
			Property property = favProperties.get(i);
			favoriteIDs.add(property.getPropertyId());
		}
		return favoriteIDs;
	}
	
	public String getStudentId() {
		return this.studentID;
	}
	
	public void setStudentId(String studentId) {
		this.studentID = studentId;
	}
	
	public void addFavoriteProperty(Property property) {
		favProperties.add(property);
	}
	
	public String getUsername() {
		return username;
	}
	
//	public String toString() {
//		String s;
//		s = super.toString();
//		return s;
//	}
}
