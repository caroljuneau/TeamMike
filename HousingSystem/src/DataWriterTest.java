

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWriterTest {
	private StudentList student = StudentList.getInstance();
	private ArrayList<Student> studentList = student.getStudents();
	private PropertyManagerList managers = PropertyManagerList.getInstance();
	private ArrayList<PropertyManager> managerList = managers.getPropertyManagers();
	private LeaseList leases = LeaseList.getInstance();
	private ArrayList<Lease> leaseList = leases.getLeases();
	private PropertyList properties = PropertyList.getInstance();
	private ArrayList<Property> propertyList = properties.getProperties();
	private boolean[] TRUE = {true, true, true, true, true};
	private boolean[] FALSE = {false, false, false, false, false};
	private ReviewList reviews = ReviewList.getInstance();
	private ArrayList<Review> reviewList = reviews.getReviews();
	ReviewType type = ReviewType.STUDENT;
	
	@BeforeEach
	public void setup() {
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
	public void tearDown() {
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
	
	
	@Test
	void testWritingZeroStudents() {
		studentList = DataLoader.loadStudent();
		assertEquals(0, studentList.size());
	}

	@Test
	void testWritingOneStudent() {
		studentList.add(new Student(1, "username1", "password1", "first1", "last1", "email1", "phone1", "id1"));
		DataWriter.saveStudent();
		assertEquals("username1", DataLoader.loadStudent().get(0).getUsername());
	}
	
	@Test
	void testWritingFiveStudents() {
		studentList.add(new Student(1, "username1", "password1", "first1", "last1", "email1", "phone1", "id1"));
		studentList.add(new Student(2, "username2", "password2", "first2", "last2", "email2", "phone2", "id2"));
		studentList.add(new Student(3, "username3", "password3", "first3", "last3", "email3", "phone3", "id3"));
		studentList.add(new Student(4, "username4", "password4", "first4", "last4", "email4", "phone4", "id4"));
		studentList.add(new Student(5, "username5", "password5", "first5", "last5", "email5", "phone5", "id5"));
		DataWriter.saveStudent();
		assertEquals("username5", DataLoader.loadStudent().get(4).getUsername());
	}
	
	@Test
	void testWritingEmptyStudent() {
		studentList.add(new Student(0, "", "", "", "", "", "", ""));
		DataWriter.saveStudent();
		assertEquals("", DataLoader.loadStudent().get(0).getUsername());
	}
	
	// start of chris (Property manager section)
	@Test
	void testWritingZeroManagers() {
		managerList = DataLoader.loadPropertyManager();
		assertEquals(0, managerList.size());
	}

	@Test
	void testWritingOneManager() {
		managerList.add(new PropertyManager(1, "username1", "password1", "first1", "last1", "email1", "phone1"));
		DataWriter.savePropertyManager();
		assertEquals("username1", DataLoader.loadPropertyManager().get(0).getUsername());
	}
	
	@Test
	void testWritingFiveManagers() {
		managerList.add(new PropertyManager(1, "username1", "password1", "first1", "last1", "email1", "phone1"));
		managerList.add(new PropertyManager(2, "username2", "password2", "first2", "last2", "email2", "phone2"));
		managerList.add(new PropertyManager(3, "username3", "password3", "first3", "last3", "email3", "phone3"));
		managerList.add(new PropertyManager(4, "username4", "password4", "first4", "last4", "email4", "phone4"));
		managerList.add(new PropertyManager(5, "username5", "password5", "first5", "last5", "email5", "phone5"));
		DataWriter.savePropertyManager();
		assertEquals("username5", DataLoader.loadPropertyManager().get(4).getUsername());
	}
	
	@Test
	void testWritingEmptyManager() {
		managerList.add(new PropertyManager(0, "", "", "", "", "", ""));
		DataWriter.savePropertyManager();
		assertEquals("", DataLoader.loadPropertyManager().get(0).getUsername());
	}
	// (Lease section)
	@Test
	void testWritingZeroLease() {
		leaseList = DataLoader.loadLeases();
		assertEquals(0, leaseList.size());
	}

	@Test
	void testWritingOneLease() {
		leaseList.add(new Lease(1, 1, "fees1", "repairs1", "term1", "info1"));
		DataWriter.saveLease();
		assertEquals("fees1", DataLoader.loadLeases().get(0).getFees());
	}
	
	@Test
	void testWritingFiveLeases() {
		leaseList.add(new Lease(1, 1, "fees1", "repairs1", "term1", "info1"));
		leaseList.add(new Lease(2, 2, "fees2", "repairs2", "term2", "info2"));
		leaseList.add(new Lease(3, 3, "fees3", "repairs3", "term3", "info3"));
		leaseList.add(new Lease(4, 4, "fees4", "repairs4", "term4", "info4"));
		leaseList.add(new Lease(5, 5, "fees5", "repairs5", "term5", "info5"));
		DataWriter.saveLease();
		assertEquals("fees5", DataLoader.loadLeases().get(4).getFees());
	}
	
	@Test
	void testWritingEmptyLease() {
		leaseList.add(new Lease(0, 0, "", null, null, null));
		DataWriter.saveLease();
		assertEquals("", DataLoader.loadLeases().get(0).getFees());
	}
	@Test
	void testWritingNullLease() {
		leaseList.add(new Lease(0, 0, null, null, null, null));
		DataWriter.saveLease();
		assertEquals(null, DataLoader.loadLeases().get(0).getFees());
	}
	// (property section)
	@Test
	void testWritingZeroProperty() {
		propertyList = DataLoader.loadProperties();
		assertEquals(0, propertyList.size());
	}

	@Test
	void testWritingOneProperty() {
		propertyList.add(new Property(1, TRUE, "util1", "loc1", 10, 1, 1, "desc1", "NA", true));
		DataWriter.saveProperty();
		assertEquals("loc1", DataLoader.loadProperties().get(0).getLocation());
	}
	
	@Test
	void testWritingFiveProperties() {
		propertyList.add(new Property(1, TRUE, "util1", "loc1", 10, 1, 1, "desc1", "NA", true));
		propertyList.add(new Property(2, TRUE, "util2", "loc2", 20, 2, 2, "desc2", "NA", true));
		propertyList.add(new Property(3, TRUE, "util3", "loc3", 30, 3, 3, "desc3", "NA", true));
		propertyList.add(new Property(4, TRUE, "util4", "loc4", 40, 4, 4, "desc4", "NA", true));
		propertyList.add(new Property(5, TRUE, "util5", "loc5", 50, 5, 5, "desc5", "NA", true));
		DataWriter.saveProperty();
		assertEquals("loc5", DataLoader.loadProperties().get(4).getLocation());
	}
	
	@Test
	void testWritingEmptyProperty() {
		propertyList.add(new Property(0, FALSE, "", "", 0, 0, 0, "", "", false));
		DataWriter.saveProperty();
		assertEquals("", DataLoader.loadProperties().get(0).getLocation());
	}
	@Test
	void testWritingNullProperty() {
		propertyList.add(new Property(0, null, null, null, 0, 0, 0, null, null, false));
		DataWriter.saveProperty();
		assertEquals(null, DataLoader.loadProperties().get(0).getLocation());
	}
	// (review section)
	@Test
	void testWritingZeroReviews() {
		reviewList = DataLoader.loadReviews();
		assertEquals(0, reviewList.size());
	}

	@Test
	void testWritingOneReview() {
		reviewList.add(new Review(1, 1, type, 5, "user1", "desc1"));
		DataWriter.saveReview();
		assertEquals("user1", DataLoader.loadReviews().get(0).getUsername());
	}
	
	@Test
	void testWritingFiveReviews() {
		reviewList.add(new Review(1, 1, type, 5, "user1", "desc1"));
		reviewList.add(new Review(2, 2, type, 5, "user2", "desc2"));
		reviewList.add(new Review(3, 3, type, 5, "user3", "desc3"));
		reviewList.add(new Review(4, 4, type, 5, "user4", "desc4"));
		reviewList.add(new Review(5, 5, type, 5, "user5", "desc5"));
		DataWriter.saveReview();
		assertEquals("user5", DataLoader.loadReviews().get(4).getUsername());
	}
	
	@Test
	void testWritingEmptyReview() {
		reviewList.add(new Review(0, 0, type, 0, "", ""));
		DataWriter.saveReview();
		assertEquals("", DataLoader.loadReviews().get(0).getUsername());
	}
	@Test
	void testWritingNullReview() {
		reviewList.add(new Review(0, 0, null, 0, null, null));
		DataWriter.saveReview();
		assertEquals(null, DataLoader.loadReviews().get(0).getUsername());
	}
	

	
	
	
	
}