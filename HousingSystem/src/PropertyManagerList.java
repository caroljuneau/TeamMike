import java.util.ArrayList;
import java.util.Iterator;

public class PropertyManagerList {
	private ArrayList<PropertyManager> propertyManagers;
	private static PropertyManagerList propertyManagerList;

	private PropertyManagerList() {
		propertyManagers = DataLoader.loadPropertyManager();
	}

	public static PropertyManagerList getInstance() {
		if (propertyManagerList == null) {
			propertyManagerList = new PropertyManagerList();
		}
		return propertyManagerList;
	}

	public ArrayList<PropertyManager> getPropertyManagers() {
		return this.propertyManagers;
	}

	public PropertyManager getPropertyManager(int id) {
		for (PropertyManager pm : propertyManagers) {
			if (pm.getID() == id) {
				return pm;
			}
		}
		return null;
	}

	public int getSize() {
		return propertyManagers.size();
	}

	public PropertyManager addPropertyManager(String username, String password, String firstName, String lastName, String emailAddress, String phone) {
		int id = propertyManagers.size() + 1;
		PropertyManager pm = new PropertyManager(id, username, password, firstName, lastName, emailAddress, phone);
		propertyManagers.add(pm);
//		DataWriter.savePropertyManager(); TODO
		return pm;
	}

	public PropertyManager getPropertyManager(String username, String password) {
		for (PropertyManager pm : propertyManagers) {
			if (pm.getUsername().equals(username) && pm.getPassword().equals(password)) {
				return pm;
			}
		}
		return null;
	}

	public boolean usernameInList(String username) {
		for (PropertyManager pm : propertyManagers) {
			if (pm.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
