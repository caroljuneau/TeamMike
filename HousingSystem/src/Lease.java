import java.util.ArrayList;

public class Lease {

	private int id;
	private ArrayList<Integer> signedByStudentIds;
	private ArrayList<Integer> signedByPropertyManagerIds;
	private int propertyID;
	private String fees;
	private String repairs;
	private String termination;
	private String info;
	private boolean signed;
//	private ArrayList<String> signedBy;

	public Lease(int id, ArrayList<Integer> signedByStudentIds, ArrayList<Integer> signedByPropertyManagerIds, int propertyID, String fees, String repairs, String termination, String info, boolean signed) {
		this.id = id;
		this.signedByStudentIds = signedByStudentIds;
		this.signedByPropertyManagerIds = signedByPropertyManagerIds;
		this.propertyID = propertyID;
		this.fees = fees;
		this.repairs = repairs;
		this.termination = termination;
		this.info = info;
//		signedBy = null;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Integer> getSignedByStudentIds() {
		return signedByStudentIds;
	}
	
	public void setSignedByStudentIds(ArrayList<Integer> iDs) {
		this.signedByStudentIds = iDs;
	}
	
	public ArrayList<Integer> getSignedByPropertyManagerIds() {
		return signedByPropertyManagerIds;
	}
	
	public void setSignedByPropertyManagerIds(ArrayList<Integer> iDs) {
		this.signedByPropertyManagerIds = iDs;
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
	
	public void sign(Account user) {
		if(user.type == AccountType.STUDENT) {
			signedByStudentIds.add(user.getID());
			setSigned(true);
		}
		if(user.type == AccountType.PROPERTYMANAGER) {
			signedByPropertyManagerIds.add(user.getID());
			setSigned(true);
		}
		return;
	}

//	public ArrayList<String> getSignedBy() {
//		return signedBy;
//	}
//	public void setSignedBy(ArrayList<String> signedBy) {
//		this.signedBy = signedBy;
//	}
	
	
	//getSignedByString is now in HOusing Application
	
	public String toString() {
		String s;
		s = "Property ID: " + this.propertyID + "\nFees: " + this.fees +
				"\nRepairs: " + this.repairs + "\nTermination: " + this.termination +
				"\nInfo: " + this.info;
//		s += "\nSigned By: " + getSignedByString();
		return s;
	}

}
