import java.util.ArrayList;
import java.util.Iterator;

public class ReviewList {

	private ArrayList<Review> reviews;
	private static ReviewList reviewList;

	private ReviewList() {
		reviews = dataLoader.loadReviews();
	}

	public static ReviewList getInstance()
	{
		if(reviewList == null)
		{
			reviewList = new ReviewList();
		}
		return reviewList;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}
	
	public int addReview(int reviewedId, ReviewType type, int rating, String username, String description) {
		int id = reviews.size() + 1;
		reviews.add(new Review(id, reviewedId, type, rating, username, description));
		return id;
		//TODO datawriter
	}


}
