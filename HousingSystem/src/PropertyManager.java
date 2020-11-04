import java.util.ArrayList;

public class PropertyManager extends Account {

	private ArrayList<Integer> myProperties;

	public PropertyManager(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone) {
		super(id, username, password, firstName, lastName, emailAddress, phone);
		this.type = AccountType.PROPERTYMANAGER;
		this.myProperties = new ArrayList<Integer>();
	}

	public void setMyProperties(ArrayList<Integer> myPropertyIDs) {
		myProperties = myPropertyIDs;
	}

	public ArrayList<Integer> getMyProperties() {
		return this.myProperties;
	}

	public void addMyProperty(Property property) {
		myProperties.add(property.getPropertyId());
	}
}
