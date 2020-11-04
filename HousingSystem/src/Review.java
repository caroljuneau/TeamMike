public class Review {

	private int id;
	private int reviewedId;
	private ReviewType type;
	private int rating;
	private String username;
	private String description;

	public Review(int id, int reviewedId, ReviewType type, int rating, String username, String description) {
		this.id = id;
		this.reviewedId = reviewedId;
		this.type = type;
		this.rating = rating;
		this.username = username;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReviewedId() {
		return reviewedId;
	}

	public void setReviewedId(int reviewedId) {
		this.reviewedId = reviewedId;
	}

	public ReviewType getType() {
		return type;
	}

	public void setType(ReviewType type) {
		this.type = type;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "Rating: " + rating + "\n  Username: " + username + "\n  Description: " + description + "\n";
	}
}
