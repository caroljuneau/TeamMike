import java.util.ArrayList;

public class Lease {

	private int id;
	private ArrayList<Student> signedByStudents;
//	private String manager;
//	private ArrayList<PropertyManager> signedByPropertyManagers;
	private PropertyManager signedByPropertyManager;
//	private ArrayList<Integer> signedByStudentIds;
//	private ArrayList<Integer> signedByPropertyManagerIds;
	private int propertyID;
	private String fees;
	private String repairs;
	private String termination;
	private String info;
	private String startDate;
	private String endDate;
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
	
	public ArrayList<Integer> getSignedByStudentIDs() {
		ArrayList<Integer> signedByStudentIDs = new ArrayList<Integer>();
		for(Student s : signedByStudents) {
			signedByStudentIDs.add(s.getID());
		}
		return signedByStudentIDs;
	}
	
	public void setSignedByPropertyManager(int signedByPMID) {
		this.signedByPropertyManager = PropertyManagerList.getInstance().getPropertyManager(signedByPMID);
	}
	
	public PropertyManager getSignedByPropertyManager() {
		return this.signedByPropertyManager;
	}
	
	public int getSignedByPropertyManagerID() {
		return this.signedByPropertyManager.getID();
	}
	
//	public void setSignedByPropertyManagers(ArrayList<Integer> signedByPropertyManagerIDs) {
//		for(int i = 0; i < signedByPropertyManagerIDs.size(); i++) {
//			int id = signedByPropertyManagerIDs.get(i);
//			signedByPropertyManagers.add(PropertyManagerList.getInstance().getPropertyManager(id));
//		}
//	}
//	public void setManager() {
//		this.manager = getProperty().;		
//	}
//	public PropertyManager getManager() {
//		return this.manager;
//	}
	
	
//	public ArrayList<PropertyManager> getSignedByPropertyManagers() {
//		return this.signedByPropertyManagers;
//	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
//	public ArrayList<Integer> getSignedByPropertyManagerIds() {
//		ArrayList<Integer> signedByPropertyManagerIds = new ArrayList<Integer>();
//		for(PropertyManager pm : signedByPropertyManagers) {
//			signedByPropertyManagerIds.add(pm.getID());
//		}
//		return signedByPropertyManagerIds;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
	public void sign(Account user) {
		if(user.type == AccountType.STUDENT) {
			signedByStudents.add((Student) user);
			setSigned(true);
		}
		if(user.type == AccountType.PROPERTYMANAGER) {
			signedByPropertyManager = (PropertyManager) user;
			setSigned(true);
		}
		return;
	}
	public Property getProperty() {
		Property property = PropertyList.getInstance().getProperty(this.propertyID);
		return property;
	}

	public String toString() {
		String s;
		s = "Property ID: " + this.propertyID + "\nFees: " + this.fees +
				"\nRepairs: " + this.repairs + "\nTermination: " + this.termination +
				"\nInfo: " + this.info;
		return s;
	}
	public void toTxt() {
		String s;
		s = "Property ID: " + this.propertyID + "\nFees: " + this.fees +
				"\nRepairs: " + this.repairs + "\nTermination: " + this.termination +
				"\nInfo: " + this.info;
	}

}
