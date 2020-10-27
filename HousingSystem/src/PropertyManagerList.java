import java.util.ArrayList;
import java.util.Iterator;

public class PropertyManagerList {
	private ArrayList<PropertyManager> propertyManagers;
	private static PropertyManagerList propertyManagerList;

	private PropertyManagerList() {
		propertyManagers = new ArrayList<PropertyManager>();
	}

	public static PropertyManagerList getInstance() {
		if (propertyManagerList == null) {
			propertyManagerList = new PropertyManagerList();
		}
		return propertyManagerList;
	}

	public int addPropertyManager(String username, String password, String firstName, String lastName, String emailAddress, String phone) {
		int id = propertyManagers.size();
		propertyManagers.add(new PropertyManager(username, password, firstName, lastName, emailAddress, phone));
		return id;
	}
	
	public PropertyManager getPropertyManager(String username, String password) {
		Iterator<PropertyManager> iterator = propertyManagers.iterator();
		while(iterator.hasNext()) {
			PropertyManager propertyManager = iterator.next();
			if(propertyManager.getUsername() == username && propertyManager.getPassword() == password) {
				return propertyManager;
			}
		}
		return null;
	}
	
	public boolean usernameInList(String username) {
		Iterator<PropertyManager> iterator = propertyManagers.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getUsername() == username) {
				return true;
			}
		}
		return false;
	}
}
