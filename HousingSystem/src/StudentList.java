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

	public int addStudent(/*params*/) {
		int id = students.size();
		students.add(new Student(null, null, null, null, null, null, null/*constructor params*/));
		return id;
	}
	
	public Student getStudent(String username, String password) {
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			if(student.getUsername() == username && student.getPassword() == password) {
				return student;
			}
		}
		return null;
	}
}