

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTest {
	private static final boolean[] TRUE = {true, true, true, true, true};
	private static final boolean[] FALSE = {false, false, false, false, false};
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
	void testHaveValidFirstPropertyLocation() {
		boolean idcheck1 = property.haveLocation("Bluff Rd");
		assertTrue(idcheck1);
	}
	
	@Test
	void testHaveValidSecondPropertyLocation() {
		boolean idcheck2 = property.haveLocation("Olympia Rd");
		assertTrue(idcheck2);
	}
	
	@Test
	void testHaveInvalidLocation() {
		boolean loc = property.haveLocation("Bluff St");
		assertFalse(loc);
	}
	
	@Test
	void testHaveEmptyLocation() {
		boolean hasEmpty = property.haveLocation("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveNullLocation() {
		boolean hasNull = property.haveLocation(null);
		assertFalse(hasNull);
	}
	
	@Test
	void testCreateValidProperty() {
		int propId = 3;
		Property p = new Property(propId, TRUE, "water", "1232 Lazy Creek", 400, 2, 2, "on the creek", "N/A", true);
		propertyList.add(p);
		assertEquals(p, property.getProperty(propId));
	}
	
	@Test
	void testCreateDuplicateProperty() {
		int propId = 3;
		Property p = new Property(propId, TRUE, "water", "1232 Lazy Creek", 400, 2, 2, "on the creek", "N/A", true);
		boolean isCreated = propertyList.add(p);
		assertFalse(isCreated);
	}
	
	@Test
	void testCreateEmptyProperty() {
		Property p = new Property(0, null, null, null, 0, 0, 0, null, null, false);
		boolean isCreated = propertyList.add(p);
		assertFalse(isCreated);
	}
	
	@Test
	void testCreateAddNullProperty() {
		boolean isCreated = propertyList.add(null);
		assertFalse(isCreated);
	}
}