import java.util.ArrayList;

public class Account {

	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String emailAddress;
	protected String phone;
	
	protected ArrayList<Integer> ratings;
	protected ArrayList<Review> reviews;
	protected ArrayList<Lease> signedLeases;
	
	public double getAvgRating()
	{
		return 0.0;
	}
	
	public void addReview()
	{
	}
	
	public ArrayList<Review> getReviewed;
	{
		return null;
	}
	
	public void signLease(Property property)
	{
		return null;
	}
	
	public ArrayList<Lease> getSignedLease()
	{
		return null;
	}
}
