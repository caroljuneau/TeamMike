

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
	private Student student = Student.getInstance();
	private ArrayList<Student> userList = Student.getUsers();
	
	@BeforeEach
	public void setup() {
		Student.getInstance().getUsers().clear();
		DataWriter.saveStudent();
	}
	
	@AfterEach
	public void tearDown() {
		Student.getInstance().getUsers().clear();
		DataWriter.saveStudent();
	}
	
	
	@Test
	void testWritingZeroUsers() {
		userList = DataLoader.getStudent();
		assertEquals(0, userList.size());
	}

	@Test
	void testWritingOneUser() {
		userList.add(new User("asmith", "Amy", "Smith", 19, "803-454-3344"));
		DataWriter.saveStudent();
		assertEquals("asmith", DataLoader.getStudent().get(0).getUserName());
	}
	
	@Test
	void testWritingFiveUsers() {
		userList.add(new Student("asmith", "Amy", "Smith", 19, "803-454-3344"));
		userList.add(new Student("bsmith", "Amy", "Smith", 19, "803-454-3344"));
		userList.add(new Student("csmith", "Amy", "Smith", 19, "803-454-3344"));
		userList.add(new Student("dsmith", "Amy", "Smith", 19, "803-454-3344"));
		userList.add(new Student("esmith", "Amy", "Smith", 19, "803-454-3344"));
		DataWriter.saveStudent();
		assertEquals("esmith", DataLoader.getUsers().get(4).getUserName());
	}
	
	@Test
	void testWritingEmptyUser() {
		userList.add(new Student("", "", "", 0, ""));
		DataWriter.saveStudent();
		assertEquals("", DataLoader.getUsers().get(0).getUserName());
	}
	
	@Test
	void testWritingNullUser() {
		userList.add(new Student(null, "", "", 0, ""));
		DataWriter.saveStudent();
		assertEquals(null, DataLoader.getUsers().get(0).getUserName());
	}
	
}
