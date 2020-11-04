import java.util.ArrayList;
import java.util.Iterator;

public class ReviewList {

	private ArrayList<Review> reviews;
	private static ReviewList reviewList;

	private ReviewList() {
		reviews = DataLoader.loadReviews();
	}

	public static ReviewList getInstance() {
		if (reviewList == null) {
			reviewList = new ReviewList();
		}
		return reviewList;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public int getSize() {
		return reviews.size();
	}

	public Review getReview(int id) {
		for (Review r : reviews) {
			if (r.getId() == id) {
				return r;
			}
		}
		return null;
	}

	public Review addReview(int id, int reviewedId, ReviewType type, int rating, String username, String description) {
		Review review = new Review(id, reviewedId, type, rating, username, description);
		reviews.add(review);
		DataWriter.saveReview();
		return review;
	}

	public ArrayList<Review> getReviewsOfType(ReviewType type) {
		ArrayList<Review> typeReviews = new ArrayList<Review>();
		for (Review r : reviews) {
			if (r.getType() == type) {
				typeReviews.add(r);
			}
		}
		return typeReviews;
	}

}
