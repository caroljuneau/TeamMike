

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HousingApplicationTest {
	private HousingApplication app = new HousingApplication();
	
	private StudentList student = StudentList.getInstance();
	private ArrayList<Student> studentList = student.getStudents();
	private AccountType stu = AccountType.STUDENT;
	
	private PropertyManagerList manager = PropertyManagerList.getInstance();
	private ArrayList<PropertyManager> managerList = manager.getPropertyManagers();
	private AccountType man = AccountType.PROPERTYMANAGER;
	private Account user;

	
	@BeforeEach
	void setup() {
		StudentList.getInstance().getStudents().clear();
		DataWriter.saveStudent();
		PropertyManagerList.getInstance().getPropertyManagers().clear();
		DataWriter.savePropertyManager();
		LeaseList.getInstance().getLeases().clear();
		DataWriter.saveLease();
		PropertyList.getInstance().getProperties().clear();
		DataWriter.saveProperty();
		ReviewList.getInstance().getReviews().clear();
		DataWriter.saveReview();
	}
	
	@AfterEach
	void tearDown() {
		StudentList.getInstance().getStudents().clear();
		DataWriter.saveStudent();
		PropertyManagerList.getInstance().getPropertyManagers().clear();
		DataWriter.savePropertyManager();
		LeaseList.getInstance().getLeases().clear();
		DataWriter.saveLease();
		PropertyList.getInstance().getProperties().clear();
		DataWriter.saveProperty();
		ReviewList.getInstance().getReviews().clear();
		DataWriter.saveReview();
	}
	
	// Student Account Creation 
	@Test
	void testCreateValidStudentAccount() {
		app.createStudentAccount("testName", "password", "chris", "walls", "email1", "#1", "stid1");
		boolean isCreated = app.usernameInList(stu, "testName");
		assertTrue(isCreated);
	}
	
	@Test
	void testCreateDuplicateStudentAccount() {
		app.createStudentAccount("testName", "password", "chris", "walls", "email1", "#1", "stid1");
		app.createStudentAccount("testName", "password", "chris", "walls", "email1", "#1", "stid1");
		boolean isCreated = app.usernameInList(stu, "testName");
		assertFalse(isCreated);
		// Should not be allowed, currently allowed to do so 10:58 11/16/20
		
	}
	
	@Test
	void testCreateEmptyStudentAccount() {
		app.createStudentAccount("", "", "", "", "", "", "");
		boolean isCreated = app.usernameInList(stu, "");
		assertFalse(isCreated);
	}
	
	@Test
	void testCreateNullStudentAccount() {
		app.createStudentAccount(null, null, null, null, null, null, null);
		boolean isCreated = app.usernameInList(stu, null);
		assertFalse(isCreated);
	}
	// Property Manager Account Creation
	@Test
	void testCreateValidPropertyManagerAccount() {
		app.createPropertyManagerAccount("testName", "password", "bob", "jones", "email1", "#1");
		boolean isCreated = app.usernameInList(man, "testName");
		assertTrue(isCreated);
	}
	
	@Test
	void testCreateDuplicatePropertyManagerAccount() {
		app.createPropertyManagerAccount("testName", "password", "bob", "jones", "email1", "#1");
		app.createPropertyManagerAccount("testName", "password", "bob", "jones", "email1", "#1");
		boolean isCreated = app.usernameInList(man, "testName");
		assertFalse(isCreated);
	}
	
	@Test
	void testCreateEmptyPropertyManagerAccount() {
		app.createPropertyManagerAccount("", "", "", "", "", "");
		boolean isCreated = app.usernameInList(stu, "");
		assertFalse(isCreated);
	}
	
	@Test
	void testCreateNullPropertyManagerAccount() {
		app.createPropertyManagerAccount(null, null, null, null, null, null);
		boolean isCreated = app.usernameInList(man, null);
		assertFalse(isCreated);
	}
//	
//	@Test
//	void testAddNewProperty() {
//		// The code makes sure that it is a property manager, so we specify
//		user = new Account(1, "testName", "password", "chris", "walls", "email", "#");
//		user.setAccountType(man);
//		app.addNewProperty(user, "Test Street", null, "util1", 600, 2, 2, "lovely house on the river", "555-555-5555");
//		manager.getPropertyManager("testName", "password").getMyProperties;
//	}
	
	@Test
	void testLogInWithStudent() {
		app.createStudentAccount("tester1", "password", "chris", "walls", "email1", "#1", "stid1");
		assertEquals(student.getStudent("tester1", "password"), app.logIn("tester1", "password"));
	}
	
	@Test
	void testLogInWithPropertyManager() {
		app.createPropertyManagerAccount("tester1", "password", "chris", "walls", "email1", "#1");
		assertEquals(manager.getPropertyManager("tester1", "password"), app.logIn("tester1", "password"));
	}
	
	@Test
	void testSearchByKeyword() {
		// currently search by keyword isnt setup
	}
	
	@Test
	void testSortByPrice() {
		// String sortByPrice(boolean increasing)
	}
	
	@Test
	void testSortByNumReviews() {
		// String sortByNumReviews(boolean increasing)
	}
	
	@Test
	void testFilterByAmenities() {
		// String filterByAmenities(boolean[] choices)
	}
	
	@Test
	void testFilterByPriceRange() {
		// String filterByPriceRange(int min, int max)
	}
	
	@Test
	void testReviewProperty() {
		// void reviewProperty(Account user, Property property, int rating, String description)
	}
	
	@Test
	void testReviewPropertyManager() {
		// void reviewPropertyManager(Account user, PropertyManager propertyManager, int rating, String description)
	}
	
	@Test
	void testReviewStudent() {
		//void reviewStudent(Account user, Student student, int rating, String description)
	}
	
	@Test
	void testSignLease() {
		// void signLease(Account user, Lease lease)
	}
	
	@Test
	void testAddNewProperty() {
		// void addNewProperty(Account user, String location, boolean[] amenitiesBool, String utilities, int price, int beds, int baths, String description, String contact)
	}
	
	@Test 
	void testAddFavProperty() {
		// void addFavProperty(Account user, Property property)
	}
	
	@Test
	void testDeleteProperty() {
		//boolean deleteProperty(Property property)
	}
	
	@Test
	void testAddLease() {
		//void addLease(Property property, String fees, String repairs, String termination, String info)
	}
	
	
	
	
	
}
