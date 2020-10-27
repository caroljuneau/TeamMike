import java.util.ArrayList;

public class Student extends Account {
	
	private ArrayList<Property> favoriteProperties;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phone;
	private String studentID;
	private int rating;
	private ArrayList<Review> reviews;
	private ArrayList<Lease> signedLeases;
	private ArrayList<Property> favorites;
	private int[] reviewIDs;
	private int[] signedLeaseIDs;
	private int[] favoriteIDs;
	private int[] ratings;
//	static Student student = new Student();
	
	public Student(String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID)
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phone = phone;
//		this.type = AccountType.STUDENT;
		this.studentID = studentID;
		this.favoriteProperties = null;
		this.ratings = null;
		this.reviews = null;
		this.signedLeases = null;
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

	public void setFavoriteIDs(int[] arr) {
		this.favoriteIDs = arr;
	}
	public int[] getFavoriteIDs() {
		return this.favoriteIDs;
	}
	public void setRating(int[] arr) {
		int num = arr.length;
		int sum = 0;
		for(int j: arr) {
			sum += j;
		}
		this.rating = sum/num;
	}
	public double getAvgRating() {
		return this.rating;
	}
	public void setReviewIDs(int[] arr) {
		this.reviewIDs = arr;
	}
	public int[] getReviewIDs() {
		return this.reviewIDs;
	}
	public void setSignedLeaseIDs(int[] arr) {
		this.signedLeaseIDs = arr;
	}
	public int[] getSignedLeaseIDs() {
		return this.signedLeaseIDs;
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
}
