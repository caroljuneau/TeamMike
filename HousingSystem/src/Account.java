import java.util.ArrayList;

public class Account {

	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String emailAddress;
	protected String phone;
//	protected AccountType type;
	protected ArrayList<Integer> ratings;
	protected ArrayList<Review> reviews;
	protected ArrayList<Lease> signedLeases;
	
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
	
	public double getAvgRating()
	{
		return 0.0;
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
}
