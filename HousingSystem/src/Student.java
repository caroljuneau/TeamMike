import java.util.ArrayList;

public class Student extends Account {

	private ArrayList<Integer> favProperties;
	private String studentID;

	public Student(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID) {
		super(id, username, password, firstName, lastName, emailAddress, phone);
		this.type = AccountType.STUDENT;
		this.favProperties = new ArrayList<Integer>();
		this.studentID = studentID;
	}

	public void setFavProperties(ArrayList<Integer> favIDs) {
		this.favProperties = favIDs;
	}

	public ArrayList<Integer> getFavProperties() {
		return favProperties;
	}

	public String getStudentId() {
		return this.studentID;
	}

	public void setStudentId(String studentId) {
		this.studentID = studentId;
	}

	public void addFavoriteProperty(int propertyID) {
		favProperties.add(propertyID);
	}
}
