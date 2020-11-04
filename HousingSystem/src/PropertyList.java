import java.util.ArrayList;

public class PropertyList {
	private ArrayList<Property> properties;
	private static PropertyList propertyList;

	private PropertyList() {
		properties = DataLoader.loadProperties();
	}

	public static PropertyList getInstance() {
		if (propertyList == null) {
			propertyList = new PropertyList();
		}
		return propertyList;
	}

	public Property addProperty(boolean[] amenities, String utilities, String location, int price, int beds, int baths, String description, String contact, boolean visible) {
		int id = properties.size() + 1;
		Property property = new Property(id, amenities, utilities, location, price, beds, baths, description, contact, visible);
		properties.add(property);
//		DataWriter.saveProperty(); TODO
		return property;
	}

	public ArrayList<Property> getProperties() {
		ArrayList<Property> viewableProperties = new ArrayList<Property>();
		for (Property p : properties) {
			if (p.isVisible())
				viewableProperties.add(p);
		}
		return viewableProperties;
	}

	public int getSize() {
		return properties.size();
	}

	public Property getProperty(int id) {
		for (Property p : properties) {
			if (p.getPropertyId() == id && p.isVisible()) {
				return p;
			}
		}
		return null;
	}

	public Property removeProperty(Property property) {
		property.setVisible(false);
		return property;
	}
}
