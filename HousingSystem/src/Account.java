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
	protected ArrayList<Integer> ratings;
	protected ArrayList<Review> reviews;
	protected ArrayList<Lease> signedLeases;
	protected final double DEFAULT_RATING = 0.0;
//	protected ArrayList<Integer> reviewIDs;
//	protected ArrayList<Integer> signedLeaseIDs;
	
	public Account(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.ratings = new ArrayList<Integer>();
		this.reviews = new ArrayList<Review>();
		this.signedLeases = new ArrayList<Lease>();
	}

	public void setRatings(ArrayList<Integer> ratings) {
		this.ratings = ratings;
	}
	public ArrayList<Integer> getRatings() {
		return this.ratings;
	}
	public void setReviews(ArrayList<Integer> reviewIDs) {
		for(int i = 0; i < reviewIDs.size(); i++) {
			int id = reviewIDs.get(i);
			reviews.add(ReviewList.getInstance().getReview(id));
		}
	}
	public ArrayList<Review> getReviews() {
		return this.reviews;
	}
	public void setSignedLeases(ArrayList<Integer> signedLeaseIDs) {
		for(int i = 0; i < signedLeaseIDs.size(); i++) {
			int id = signedLeaseIDs.get(i);
			signedLeases.add(LeaseList.getInstance().getLease(id));
		}
	}
	public ArrayList<Lease> getSignedLeases() {
		return this.signedLeases;
	}
//	public void setReviewIDs(ArrayList<Integer> arr) {
//		this.reviewIDs = arr;
//	}
	public ArrayList<Integer> getReviewIDs() {
		ArrayList<Integer> reviewIDs = new ArrayList<Integer>();
		for(int i = 0; i < reviews.size(); i++) {
			Review review = reviews.get(i);
			if(reviews.get(i) != null) {
				reviewIDs.add(review.getId());
			}
		}
		return reviewIDs;
	}
//	public void setSignedLeaseIDs(ArrayList<Integer> arr) {
//		this.signedLeaseIDs = arr;
//	}
	public ArrayList<Integer> getSignedLeaseIDs() {
		ArrayList<Integer> leaseIDs = new ArrayList<Integer>();
		for(int i = 0; i < signedLeases.size(); i++) {
			Lease lease = signedLeases.get(i);
			if(signedLeases.get(i) != null) {
				leaseIDs.add(lease.getId());
			}
		}
		return leaseIDs;
	}
	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
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
	public String getEmailAddress() {
		return this.emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
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
	
	
	
	public double getAvgRating() {
		if (this.getRatings() == null) {
			return DEFAULT_RATING;
		}
		int num = this.getRatings().size();
		int sum = 0;
		for(int j: this.getRatings()) {
			sum += j;
		}
		return sum/num;
	}
	
	public String toString() {
		return "Username: " + this.username + "\nPassword: " + this.password+ "\nFirst: " + this.firstName +
				"\nLast: " + this.lastName + "\nEmail: " + this.emailAddress + "\nPhone: " +
				this.phone + "\nAvg Rating: " + this.getAvgRating() + "\n";
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String shortToString() {
		return "ID: " + ", " + getName() + "\n";
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void addLease(Lease lease) {
		this.signedLeases.add(lease);
	}
}
