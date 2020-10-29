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


}
