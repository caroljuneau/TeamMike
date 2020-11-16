

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
		studentList.add(new Student(1, "username1", "password1", "first1", "last1", "email1", "phone1", "id1"));
		studentList.add(new Student(2, "username2", "password2", "first2", "last2", "email2", "phone2", "id2"));
		DataWriter.saveStudent();
	}
	
	@AfterEach
	public void tearDown() {
		StudentList.getInstance().getStudents().clear();
		DataWriter.saveStudent();
	}
	
	@Test
	void testHaveValidFirstReviewUser() {
		boolean idcheck1 = student.usernameInList("username1");
		assertTrue(idcheck1);
	}
	
	@Test
	void testHaveValidSecondReviewUser() {
		boolean idcheck2 = student.usernameInList("username2");
		assertTrue(idcheck2);
	}
	
}
