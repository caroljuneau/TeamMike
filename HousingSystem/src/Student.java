import java.util.ArrayList;

public class Student extends Account {
	
	private ArrayList<Integer> favoriteIDs;
	//private int[] favoriteIDs;
	private String studentID;
	
	public Student(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID)
	{
		super(id, username, password, firstName, lastName, emailAddress, phone);
		this.studentID = studentID;
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
	public String toString() {
		String s;
		s = super.toString();
		return s;
	}
}
