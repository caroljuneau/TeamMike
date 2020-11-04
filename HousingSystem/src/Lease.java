import java.util.ArrayList;

public class Lease {

	private int id;
	private ArrayList<Integer> studentIDs;
	private int propertyManagerID;
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
		this.signed = false;
		this.studentIDs = new ArrayList<Integer>();
		this.propertyManagerID = -1;
	}

	public void setSignedByStudents(ArrayList<Integer> signedByStudentIDs) {
		this.studentIDs = signedByStudentIDs;
	}

	public ArrayList<Integer> getSignedByStudents() {
		return this.studentIDs;
	}

	public void setSignedByPropertyManager(int signedByPMID) {
		this.propertyManagerID = signedByPMID;
	}

	public int getSignedByPropertyManager() {
		return this.propertyManagerID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		if (user.type == AccountType.STUDENT) {
			studentIDs.add(user.getID());
			setSigned(true);
		}
		if (user.type == AccountType.PROPERTYMANAGER) {
			propertyManagerID = user.getID();
			setSigned(true);
		}
		return;
	}

	public Property getProperty() {
		Property property = PropertyList.getInstance().getProperty(this.propertyID);
		return property;
	}

	public String toString() {
		return "Property ID: " + this.propertyID + "\nFees: " + this.fees + "\nRepairs: " + this.repairs
				+ "\nTermination: " + this.termination + "\nInfo: " + this.info + "\nSigned: " + this.signed;
	}
	
	public void generateTxt() {
		DataWriter.generateLeaseText(this);
	}
}
