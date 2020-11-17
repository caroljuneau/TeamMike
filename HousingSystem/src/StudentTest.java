

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
	private StudentList student = StudentList.getInstance();
	private ArrayList<Student> studentList = student.getStudents();
	
	@BeforeEach
	public void setup() {
		studentList.clear();
		studentList.add(new Student(1, "joe", "password1", "first1", "last1", "email1", "phone1", "id1"));
		studentList.add(new Student(2, "bob", "password2", "first2", "last2", "email2", "phone2", "id2"));
		DataWriter.saveStudent();
	}
	
	@AfterEach
	public void tearDown() {
		StudentList.getInstance().getStudents().clear();
		DataWriter.saveStudent();
	}
	
	@Test
	void testHaveValidFirstReviewUser() {
		boolean hasJoe = student.usernameInList("joe");
		assertTrue(hasJoe);
	}
	
	@Test
	void testHaveValidSecondReviewUser() {
		boolean hasBob = student.usernameInList("bob");
		assertTrue(hasBob);
	}
	
	@Test
	void testHaveUserInvalid() {
		boolean hasJoe = student.usernameInList("bob");
		assertFalse(hasJoe);
	}
	
	@Test
	void testHaveUserEmpty() {
		boolean hasEmpty = student.usernameInList("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveUserNull() {
		boolean hasNull = student.usernameInList(null);
		assertFalse(hasNull);
	}
	/**
	 * maybe add addFavoriteProperty and addLease test, or do in
	 * those classes.
	 */
	
	
}
