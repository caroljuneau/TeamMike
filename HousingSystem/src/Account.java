import java.util.ArrayList;

public class Account {

	protected int id;
	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String emailAddress;
	protected String phone;
	protected AccountType type;
	protected int[] ratings;
	protected ArrayList<Review> reviews;
	protected ArrayList<Lease> signedLeases;
	protected int[] ratingIDs;
	protected int[] reviewIDs;
	protected int[] signedLeaseIDs;
	
	public String getUsername() {
		return this.username;
	}
	public void setUserame(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAdress() {
		return this.emailAddress;
	}
	public void setEmailAdress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public AccountType getAccountType() {
		return this.type;
	}
	public void setAccountType(AccountType type) {
		this.type = type;
	}
	
	public int[] getRating() {
		return this.ratings;
	}
	public void setRating(int[] arr) {
		this.ratings = arr;
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
	
	public double getAvgRating() {
		int num = this.getRating().length;
		int sum = 0;
		for(int j: this.getRating()) {
			sum += j;
		}
		return sum/num;
	}
	
	public void addReview()
	{
		
	}
	
	public ArrayList<Review> getReviews()
	{
		return null;
	}
	
	public void signLease(Property property)
	{
		
	}
	
	public ArrayList<Lease> getSignedLeases()
	{
		return null;
	}
	
	public String toString() {
		String s;
		s = "Username: " + this.username + "\nPassword: " + this.password+ "\nFirst: " + this.firstName +
				"\nLast: " + this.lastName + "\nEmail: " + this.emailAddress + "\nPhone: " +
				this.phone + "\nAvg Rating: " + this.getAvgRating();
		return s;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
}
