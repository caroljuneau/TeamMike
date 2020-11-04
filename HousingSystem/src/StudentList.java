import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {
	private ArrayList<Student> students;
	private static StudentList studentList;

	private StudentList() {
		students = DataLoader.loadStudent();
	}

	public static StudentList getInstance() {
		if (studentList == null) {
			studentList = new StudentList();
		}
		return studentList;
	}

	public int getSize() {
		return students.size();
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public Student addStudent(String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID) {
		int id = students.size() + 1;
		Student s = new Student(id, username, password, firstName, lastName, emailAddress, phone, studentID);
		students.add(s);
		return s;
	}

	public Student getStudent(String username, String password) {
		for (Student s : students) {
			if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
				return s;
			}
		}
		return null;
	}

	public Student getStudent(int id) {
		for (Student student : students) {
			if (student.getID() == id) {
				return student;
			}
		}
		return null;
	}

	public boolean usernameInList(String username) {
		for (Student s : students) {
			if (s.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
