import java.util.*;

public class SortByReviews implements Comparator<Property> {

	@Override
	public int compare(Property A, Property B) {
		return A.getNumOfReviews() - B.getNumOfReviews();
	}

}
