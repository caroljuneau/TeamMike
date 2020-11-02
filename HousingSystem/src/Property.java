import java.util.ArrayList;

public class Property {
	private int propertyId;
	private boolean[] amenities;
	private String utilities;
	private String location;
	//private ArrayList<String> pictures;
	private int price;
//	private ArrayList<Integer> reviewIDs;
//	private ArrayList<Integer> leaseIDs;
	private int beds;
	private int baths;
	private String description;
	private String contact;
	private boolean visible;
	private Lease lease;
//	private ArrayList<Lease> leases;
	private ArrayList<Integer> ratings;
	private ArrayList<Review> reviews;
//	private int size;

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
		this.lease = LeaseList.getInstance().getLease(leaseID);
	}
	
	public Lease getLease() {
		return this.lease;
	}
	
	public int getLeaseID() {
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
		String[] amenities = {"Washer/Dryer", "Gym", "Pool", "Furnished", "Pet Friendly"};
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
//	public ArrayList<String> getPictures() {
//		return pictures;
//	}
//	public void setPictures(ArrayList<String> pictures) {
//		this.pictures = pictures;
//	}
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
//	public boolean matches(String key) {
//		return false;
//	}
	
	public String toString() {
		String s;
		s = "Location: " + this.location + "\nAmenities: " + this.amenitiesToString() +
				"\nUtilities: " + this.utilities + "\nPrice: " + this.price + "\nBeds: " +
				this.beds + "\nBaths: " + this.baths + "\nDescription: " + this.description +
				"\nContact: " + this.contact;
		return s;
	}
	
	public String shortToString() {
		return "ID: " + this.propertyId + ", Location: " + this.location;
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}



}
