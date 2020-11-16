

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {

	private static final boolean[] TRUE = null;
	private static final boolean[] FALSE = null;
	private PropertyList property = PropertyList.getInstance();
	private ArrayList<Property> propertyList = property.getProperties();
	
	@BeforeEach
	public void setup() {
		propertyList.clear();
		propertyList.add(new Property(1, TRUE, "pool", "Bluff Rd", 1, 1, 1, "Description", "Contact", true));
		propertyList.add(new Property(2, FALSE, "pool", "Olympia Rd", 2, 2, 2, "Description", "Contact", false));
		DataWriter.saveProperty();
	}
	
	@AfterEach
	public void tearDown() {
		PropertyList.getInstance().getProperties().clear();
		DataWriter.saveProperty();
	}
	
	
	@Test
	void testGetPropertySize() {
		propertyList = DataLoader.loadProperties();
		assertEquals(2, propertyList.size());
	}

	@Test
	void testGetPropertySizeZero() {
		PropertyList.getInstance().getProperties().clear();
		DataWriter.saveProperty();
		assertEquals(0, propertyList.size());
	}
	
}