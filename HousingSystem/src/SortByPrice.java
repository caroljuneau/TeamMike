import java.util.*;

public class SortByPrice implements Comparator<Property> {

	@Override
	public int compare(Property A, Property B) {
		return A.getPrice() - B.getPrice();
	}

}
