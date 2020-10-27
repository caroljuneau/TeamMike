import java.util.ArrayList;

public class PropertyList {
	//TODO make iterable
	//TODO make singleton
	private static PropertyList propertyList;
	private ArrayList<Property> properties;
		
	private void propertyName(String name) {
		
	}
	
	private PropertyList() {
		properties = new ArrayList<Property>();
	}
	
	public static PropertyList getInstance()
	{
		if(propertyList == null)
		{
			propertyList = new PropertyList();
		}
		return propertyList;
	}
	
	public String toString()
	{
		return propertyList.toString();
	}
}
