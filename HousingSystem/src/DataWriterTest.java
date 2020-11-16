

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWriterTest {
	private StudentList student = StudentList.getInstance();
	private ArrayList<Student> studentList = student.getStudents();
	
	@BeforeEach
	public void setup() {
		StudentList.getInstance().getStudents().clear();
		DataWriter.saveStudent();
	}
	
	@AfterEach
	public void tearDown() {
		StudentList.getInstance().getStudents().clear();
		DataWriter.saveStudent();
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
	
}