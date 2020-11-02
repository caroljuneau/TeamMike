import java.util.*;

public class SortByReviews implements Comparator<Review> {

	@Override
	public int compare(Review A, Review B) {
		return A.getReviews() - B.getReviews();
	}

}
