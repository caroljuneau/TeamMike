import java.util.ArrayList;

public class Student {

	private ArrayList<Property> favoriteProperties;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phone;
	private String studentID;
//	static Student student = new Student();
	
	public Student(String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID)
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.studentID = studentID;
	}
//	public Student() {
//		student = dataLoader.loadStudent();
//	}
//	public static Student getInstance() {
//		if(student == null) {
//			student = new Student();
//		}
//		
//		return student;
//	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUserame(String name) {
		this.username = name;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String first) {
		this.firstName = first;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setEmailAdress(String email) {
		this.emailAddress = email;
	}
	public String getEmailAdress() {
		return this.emailAddress;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setStudentId(String studentId) {
		this.studentID = studentId;
	}
	public String getStudentId() {
		return this.studentID;
	}
	
	public void addFavoriteProperty()
	{
		return;
	}
	
	public ArrayList<Property> getFavoriteProperty;
	{

	}
	
	public void removeFavoriteProperty()
	{
		return;
	}
	
	public void reviewProperty(Property property, int rating, String username, String review)
	{
		return;
	}
	
	public void reviewPropertyManager(PropertyManager propertyManager, int rating, String username, String review)
	{
		return;
	}
}
