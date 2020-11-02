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
		for(PropertyManager pm : propertyManagers) {
			if(pm.getID() == id) {
				return pm;
			}
		}
		return null;
	}
	
	public int getSize() {
		return propertyManagers.size();
	}

	public void addPropertyManager(String username, String password, String firstName, String lastName, String emailAddress, String phone) {
		int id = propertyManagers.size() + 1;
		PropertyManager manager = new PropertyManager(id, username, password, firstName, lastName, emailAddress, phone);
		propertyManagers.add(manager);
//		//TODO add to json
//		dataWriter write = new dataWriter();
//		write.savePropertyManager(manager);
		//System.out.println(manager.toString());
	}
	
	public PropertyManager getPropertyManager(String username, String password) {
		Iterator<PropertyManager> iterator = propertyManagers.iterator();
		PropertyManager propertyManager = null;
		while(iterator.hasNext()) {
			propertyManager = iterator.next();
			if(propertyManager.getUsername().equals(username) && propertyManager.getPassword().equals(password)) {
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
