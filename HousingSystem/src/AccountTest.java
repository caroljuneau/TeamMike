

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
	private ReviewList review = ReviewList.getInstance();
	private ArrayList<Account> reviewList = review.getReviews();
	
	@BeforeEach
	public void setup() {
		reviewList.clear();
		reviewList.add(new Account(1, "", "", "", "Chase Henry", "Description", ""));
		reviewList.add(new Account(1, "", "", "", "Chase Henry", "Description", ""));
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
}