import java.util.ArrayList;

public class PropertyManager extends Account {

	private ArrayList<Property> myProperties;

	public PropertyManager(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone) {
		super(id, username, password, firstName, lastName, emailAddress, phone);
		this.type = AccountType.PROPERTYMANAGER;
		this.myProperties = new ArrayList<Property>();
	}

	public void setMyProperties(ArrayList<Integer> myPropertyIDs) {
		for (int i = 0; i < myPropertyIDs.size(); i++) {
			int id = myPropertyIDs.get(i);
			myProperties.add(PropertyList.getInstance().getProperty(id));
		}
	}

	public ArrayList<Property> getMyProperties() {
		return this.myProperties;
	}

	public ArrayList<Integer> getMyPropertyIDs() {
		ArrayList<Integer> myPropertyIDs = new ArrayList<Integer>();
		for (int i = 0; i < myProperties.size(); i++) {
			Property property = myProperties.get(i);
			myPropertyIDs.add(property.getPropertyId());
		}
		return myPropertyIDs;
	}

	public void addMyProperty(Property property) {
		myProperties.add(property);
	}
}
