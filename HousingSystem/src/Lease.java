import java.util.ArrayList;

public class Lease {

	private int id;
	private ArrayList<Student> signedByStudents;
	private ArrayList<PropertyManager> signedByPropertyManagers;
//	private ArrayList<Integer> signedByStudentIds;
//	private ArrayList<Integer> signedByPropertyManagerIds;
	private int propertyID;
	private String fees;
	private String repairs;
	private String termination;
	private String info;
	private boolean signed;

	public Lease(int id, int propertyID, String fees, String repairs, String termination, String info) {
		this.id = id;
		this.propertyID = propertyID;
		this.fees = fees;
		this.repairs = repairs;
		this.termination = termination;
		this.info = info;
	}
	
	public void setSignedByStudents(ArrayList<Integer> signedByStudentIDs) {
		for(int i = 0; i < signedByStudentIDs.size(); i++) {
			int id = signedByStudentIDs.get(i);
			signedByStudents.add(StudentList.getInstance().getStudent(id));
		}
	}
	
	public ArrayList<Student> getSignedByStudents() {
		return this.signedByStudents;
	}
	
	public void setSignedByPropertyManagers(ArrayList<Integer> signedByPropertyManagerIDs) {
		for(int i = 0; i < signedByPropertyManagerIDs.size(); i++) {
			int id = signedByPropertyManagerIDs.get(i);
			signedByPropertyManagers.add(PropertyManagerList.getInstance().getPropertyManager(id));
		}
	}
	
	public ArrayList<PropertyManager> getSignedByPropertyManagers() {
		return this.signedByPropertyManagers;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
//	public ArrayList<Integer> getSignedByStudentIds() {
//		return signedByStudentIds;
//	}
//	
//	public void setSignedByStudentIds(ArrayList<Integer> iDs) {
//		this.signedByStudentIds = iDs;
//	}
//	
//	public ArrayList<Integer> getSignedByPropertyManagerIds() {
//		return signedByPropertyManagerIds;
//	}
//	
//	public void setSignedByPropertyManagerIds(ArrayList<Integer> iDs) {
//		this.signedByPropertyManagerIds = iDs;
//	}
	
	public int getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getRepairs() {
		return repairs;
	}

	public void setRepairs(String repairs) {
		this.repairs = repairs;
	}

	public String getTermination() {
		return termination;
	}

	public void setTermination(String termination) {
		this.termination = termination;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setSigned(boolean signed) {
		this.signed = signed;
	}

	public boolean getSigned() {
		return signed;
	}
	
	public void sign(Account user) {
		if(user.type == AccountType.STUDENT) {
			signedByStudents.add((Student) user);
			setSigned(true);
		}
		if(user.type == AccountType.PROPERTYMANAGER) {
			signedByPropertyManagers.add((PropertyManager) user);
			setSigned(true);
		}
		return;
	}

	public String toString() {
		String s;
		s = "Property ID: " + this.propertyID + "\nFees: " + this.fees +
				"\nRepairs: " + this.repairs + "\nTermination: " + this.termination +
				"\nInfo: " + this.info;
		return s;
	}

}
