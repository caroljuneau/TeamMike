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

	public int addPropertyManager(/*params*/) {
		int id = propertyManagers.size();
		propertyManagers.add(new PropertyManager(null, null, null, null, null, null/*constructor params*/));
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
}
