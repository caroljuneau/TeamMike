import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {
	private ArrayList<Student> students;
	private static StudentList studentList;

	private StudentList() {
		students = new ArrayList<Student>();
	}

	public static StudentList getInstance() {
		if (studentList == null) {
			studentList = new StudentList();
		}
		return studentList;
	}

	public int addStudent(String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID) {
		int id = students.size();
		students.add(new Student(username, password, firstName, lastName, emailAddress, phone, studentID));
		return id;
	}
	
	public Student getStudent(String username, String password) {
		Iterator<Student> iterator = students.iterator();
		Student student = null;
		while(iterator.hasNext()) {
			student = iterator.next();
			if(student.getUsername() == username && student.getPassword() == password) {
				return student;
			}
		}
		return null;
	}
	
	public boolean usernameInList(String username) {
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getUsername() == username) {
				return true;
			}
		}
		return false;
	}
}