
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyManagerTest {
	private PropertyManagerList propertyManager = PropertyManagerList.getInstance();
	private ArrayList<PropertyManager> myProperties = propertyManager.getPropertyManagers();
	
	@BeforeEach
	public void setup() {
		myProperties.clear();
		myProperties.add(new PropertyManager(1, "Username1", "Password1", "First1", "Last1", "Email1", "Phone1"));
		myProperties.add(new PropertyManager(2, "Username2", "Password2", "First2", "Last2", "Email2", "Phone2"));
		DataWriter.savePropertyManager();
	}
	
	@AfterEach
	public void tearDown() {
		PropertyManagerList.getInstance().getPropertyManagers().clear();
		DataWriter.savePropertyManager();
	}
	
	
	@Test
	void testHaveValidFirstUsername() {
		boolean idcheck1 = propertyManager.usernameInList("Username1");
		assertTrue(idcheck1);
	}
	
	@Test
	void testHaveValidSecondUsername() {
		boolean idcheck2 = propertyManager.usernameInList("Username2");
		assertTrue(idcheck2);
	}
	
	@Test
	void testHaveUserInvalid() {
		boolean hasChris = propertyManager.usernameInList("chris");
		assertFalse(hasChris);
	}
	
	@Test
	void testHaveUserEmpty() {
		boolean hasEmpty = propertyManager.usernameInList("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveUserNull() {
		boolean hasNull = propertyManager.usernameInList(null);
		assertFalse(hasNull);
	}
	
	@Test
	void testCreateValidPropertyManager() {
		myProperties.add(new PropertyManager(3, "clwalls3", "Password1", "Chris", "Walls", "@null", "#####"));
		boolean hasChris = propertyManager.usernameInList("clwalls3");
		assertTrue(hasChris);
	}
	
	@Test
	void testCreateDuplicatePropertyManager() {
		boolean isCreated = myProperties.add(new PropertyManager(3, "clwalls3", "Password1", "Chris", "Walls", "@null", "#####"));
		assertFalse(isCreated);
	}
	
	@Test
	void testCreateEmptyPropertyManager() {
		boolean isCreated = myProperties.add(new PropertyManager(0, null, null, null, null, null, null));
		assertFalse(isCreated);
	}
}