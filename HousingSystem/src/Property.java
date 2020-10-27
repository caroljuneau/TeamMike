import java.util.ArrayList;

public class Property {
	private String[] amenities;
	private String utilities;
	private String location;
	private ArrayList<String> pictures;
	private int price;
	private int[] ratingIDs;
	private int[] reviewIDs;
	private int rating;
	private ArrayList<Review> reviews;
	private int beds;
	private int baths;
	private Lease lease;
	private String description;
	private String contact;
	private boolean visible;
	private int size;

	public Property(String[] amenities, String utilities, String location, int price, int beds, int baths, String description, String contact, boolean visible) {
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

	public String[] getAmenities() {
		return amenities;
	}
	public void setAmenities(String[] amenities) {
		this.amenities = amenities;
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
	public ArrayList<String> getPictures() {
		return pictures;
	}
	public void setPictures(ArrayList<String> pictures) {
		this.pictures = pictures;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int[] getRatingIDs() {
		return ratingIDs;
	}
	public void setRatingIDs(int[] ratingIDs) {
		this.ratingIDs = ratingIDs;
	}
	public int[] getReviewIDs() {
		return reviewIDs;
	}
	public void setReviewIDs(int[] reviewIDs) {
		this.reviewIDs = reviewIDs;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
	public String toString() {
		//TODO return a string with all the characteristics of the property
		return "";
	}

}
