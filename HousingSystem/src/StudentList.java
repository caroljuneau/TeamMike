import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {
	private ArrayList<Student> students;
	private static StudentList studentList;

	private StudentList() {
		students = dataLoader.loadStudent();
	}

	public static StudentList getInstance() {
		if (studentList == null) {
			studentList = new StudentList();
		}
		return studentList;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void addStudent(String username, String password, String firstName, String lastName, String emailAddress, String phone, String studentID) {
		int id = students.size() + 1;
		students.add(new Student(id, username, password, firstName, lastName, emailAddress, phone, studentID));
		//TODO datawriter
	}
	
	public Student getStudent(String username, String password) {
		Iterator<Student> iterator = students.iterator();
		Student student = null;
		while(iterator.hasNext()) {
			student = iterator.next();
			if(student.getUsername().equals(username) && student.getPassword().equals(password)) {
				return student;
			}
		}
		return null;
	}
	
	public Student getStudent(int id) {
		for(Student student : students) {
			if(student.getID() == id) {
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
	
	public int getSize() {
		return students.size();
	}
}
