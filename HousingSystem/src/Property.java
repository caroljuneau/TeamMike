import java.util.ArrayList;

public class Property {
	private int propertyId;
	private boolean[] amenities;
	private String utilities;
	private String location;
	private int price;
	private int beds;
	private int baths;
	private String description;
	private String contact;
	private boolean visible;
	private Lease lease;
	private ArrayList<Integer> ratings;
	private ArrayList<Review> reviews;

	public Property(int id, boolean[] amenities, String utilities, String location, int price, int beds, int baths, String description, String contact, boolean visible) {
		this.propertyId = id;
		this.amenities = amenities;
		this.utilities = utilities;
		this.location = location;
		this.price = price;
		this.beds = beds;
		this.baths = baths;
		this.description = description;
		this.contact = contact;
		this.visible = visible;
		this.lease = null;
		this.ratings = new ArrayList<Integer>();
		this.reviews = new ArrayList<Review>();
	}
	
	public void setLease(int leaseID) {
		if(leaseID == -1) return;
		this.lease = LeaseList.getInstance().getLease(leaseID);
	}
	
	public void setLease(Lease lease) {
		this.lease = lease;
	}
	
	public Lease getLease() {
		return this.lease;
	}
	
	public int getLeaseID() {
		if(this.lease == null) return -1;
		return this.lease.getId();
	}

	public void setRatings(ArrayList<Integer> ratingIDs) {
		this.ratings = ratingIDs;
	}
	
	public ArrayList<Integer> getRatings() {
		return ratings;
	}
	
	public void setReviews(ArrayList<Integer> reviewIDs) {
		for(int i = 0; i < reviewIDs.size(); i++) {
			int id = reviewIDs.get(i);
			reviews.add(ReviewList.getInstance().getReview(id));
		}
	}
	
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	
	public ArrayList<Integer> getReviewIDs() {
		ArrayList<Integer> reviewIDs = new ArrayList<Integer>();
		for(int i = 0; i < reviews.size(); i++) {
			Review review = reviews.get(i);
			reviewIDs.add(review.getId());
		}
		return reviewIDs;
	}
	
	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public boolean[] getAmenities() {
		return amenities;
	}
	public void setAmenities(boolean[] amenities) {
		this.amenities = amenities;
	}
	public String amenitiesToString() {
		String s = "";
		String[] amenities = {"Pool", "Gym", "Pet Friendly", "Laundry", "Shuttle"};
		for(int i = 0; i < this.amenities.length; i++) {
			if(this.amenities[i] == true) {
				s += amenities[i] + " ";
			} 
		}
		return s;
	}
	public String getUtilities() {
		return utilities;
	}
	public void setUtilities(String utilities) {
		this.utilities = utilities;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public int getBaths() {
		return baths;
	}
	public void setBaths(int baths) {
		this.baths = baths;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public String toString() {
		return "Property ID: " + this.propertyId + "\nLocation: " + this.location + "\nAmenities: " + this.amenitiesToString() +
				"\nUtilities: " + this.utilities + "\nPrice: " + this.price + "\nBeds: " +
				this.beds + "\nBaths: " + this.baths + "\nNumber of Reviews: " + this.reviews.size() + 
				"\nDescription: " + this.description + "\nContact: " + this.contact + "\n";
	}
	
	public String shortToString() {
		return "Property ID: " + this.propertyId + ", Location: " + this.location + "\n";
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public int getNumOfReviews() {
		return this.reviews.size();
	}



}
