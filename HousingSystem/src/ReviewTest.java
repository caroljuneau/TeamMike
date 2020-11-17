import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReviewTest {
	private ReviewType type;
	private ReviewList review = ReviewList.getInstance();
	private ArrayList<Review> reviewList = review.getReviews();
	
	@BeforeEach
	public void setup() {
		reviewList.clear();
		reviewList.add(new Review(1, 1, type, 1, "Chase Henry", "Description"));
		reviewList.add(new Review(2, 2, type, 2, "Chazz Henry", "Description2"));
		DataWriter.saveReview();
	}
	
	@AfterEach
	public void tearDown() {
		ReviewList.getInstance().getReviews().clear();
		DataWriter.saveReview();
	}
	
	
	@Test
	void testHaveValidFirstReviewUser() {
		boolean idcheck1 = review.haveUser("Chase Henry");
		assertTrue(idcheck1);
	}
	
	@Test
	void testHaveValidSecondReviewUser() {
		boolean idcheck2 = review.haveUser("Chazz Henry");
		assertTrue(idcheck2);
	}
	
	@Test
	void testHaveReviewUserInvalid() {
		boolean hasChris = review.haveUser("Chris Henry");
		assertFalse(hasChris);
	}
	
	@Test
	void testHaveReviewUserEmpty() {
		boolean hasEmpty = review.haveUser("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveReviewUserNull() {
		boolean hasNull = review.haveUser(null);
		assertFalse(hasNull);
	}
	
	@Test
	void testCreateValidReview() {
		int reviewId = 3;
		Review r = new Review(reviewId, 3, type, 5, "clwalls2", "nice plot :)");
		reviewList.add(r);
		assertEquals(r, review.getReview(reviewId));
	}
	
	@Test
	void testCreateDuplicateReview() {
		boolean isCreated = reviewList.add(new Review(1, 1, type, 1, "Chase Henry", "Description"));
		assertFalse(isCreated);
	}
	
	@Test
	void testCreateEmptyReview() {
		boolean isCreated = reviewList.add(new Review(0, 0, type, 0, null, null));
		assertFalse(isCreated);
	}
	
}