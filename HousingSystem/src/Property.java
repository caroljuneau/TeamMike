import java.util.ArrayList;

public class Property {
	private int propertyId;
	private boolean[] amenities;
	private String utilities;
	private String location;
	//private ArrayList<String> pictures;
	private int price;
	private ArrayList<Integer> ratings;
	private ArrayList<Integer> reviewIDs;
	private ArrayList<Integer> leaseIDs;
	private ArrayList<Review> reviews;
	private int beds;
	private int baths;
	private Lease lease;
	private String description;
	private String contact;
	private boolean visible;
	private int size;

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
	public ArrayList<Integer> getRatings() {
		return ratings;
	}
	public void setRatings(ArrayList<Integer> ratingIDs) {
		this.ratings = ratingIDs;
	}
	public ArrayList<Integer> getReviewIDs() {
		return reviewIDs;
	}
	public void setReviewIDs(ArrayList<Integer> reviewIDs) {
		this.reviewIDs = reviewIDs;
	}
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
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
	public Lease getLease() {
		return lease;
	}
	public void setLease(Lease lease) {
		this.lease = lease;
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
	public int getSize() {
		return size;
	}
	public Property get(int i) {
		return null;
	}
	public boolean matches(String key) {
		return false;
	}
	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	
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

	public ArrayList<Integer> getLeaseIDs() {
		return leaseIDs;
	}

	public void setLeaseIDs(ArrayList<Integer> leaseIDs) {
		this.leaseIDs = leaseIDs;
	}
	
	public void addReview(int reviewId) {
		reviewIDs.add(reviewId);
	}



}
