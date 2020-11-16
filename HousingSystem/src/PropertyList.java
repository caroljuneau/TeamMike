import java.util.ArrayList;

public class PropertyList {
	private ArrayList<Property> properties;
	private static PropertyList propertyList;

	private PropertyList() {
		properties = DataLoader.loadProperties();
	}
	
	public static PropertyList getInstance() {
		if(propertyList == null) {
			propertyList = new PropertyList();
		}
		return propertyList;
	}
	
	public ArrayList<Property> getProperties() {
		return properties;
	}
	
	public Property addProperty(boolean[] amenities, String utilities, String location, int price, int beds, int baths, String description, String contact, boolean visible) {
		int id = properties.size() + 1;
		Property property = new Property(id, amenities, utilities, location, price, beds, baths, description, contact, visible);
		properties.add(property);
		DataWriter.saveProperty();
		return property;
	}

	public int getSize() {
		return properties.size();
	}

	public Property getProperty(int id) {
		for(Property prop : properties) {
			if(prop.getPropertyId() == id) {
				return prop;
			}
		}
		return null;
	}
	
	public boolean removeProperty(Property property) {
		return properties.remove(property);
	}
	
	public boolean haveLocation(String location) {
		for(Property p : properties) {
			if(p.getLocation().equals(location)) {
				return true;
			}
		}
		
		return false;
	}
}
