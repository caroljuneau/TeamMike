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

	public Student getRecord(int id) {
		if (id >= 0 && id < students.size()) {
			return students.get(id);
		}
		return null;
	}
	
	public boolean foundUsername(String username) {
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext())
			if(iterator.next().getUsername() == username) return true;
		return false;
	}
	
	public boolean matchingPassword(Student student, String password) {
		if(student.getPassword() == password) return true;
		return false;
	}
//	public void addAllergy(int id, String allergy) {
//	Patient patient = getRecord(id);
//	if (patient == null) return;
//	patient.addAllergy(allergy);
//}
//
//public String getAllPatientsData() {
//	String string = "";
//	Iterator<Patient> iterator = patients.iterator();
//	while (iterator.hasNext()) {
//		string += iterator.next() + "\n";
//	}
//	return string;
//}

}