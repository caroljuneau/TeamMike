import java.util.ArrayList;

public class Lease {

	private int propertyID;
	private String fees;
	private String repairs;
	private String termination;
	private String info;
	private boolean signed;
	private ArrayList<String> signedBy;

	public Lease(int propertyID, String fees, String repairs, String termination, String info) {
		this.propertyID = propertyID;
		this.fees = fees;
		this.repairs = repairs;
		this.termination = termination;
		this.info = info;
		signedBy = null;
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

	public void setSignedBy(ArrayList<String> signedBy) {
		this.signedBy = signedBy;
	}
	

	public void sign(String fullName) {
		signedBy.add(fullName);
	}

	public boolean getSigned() {
		return signed;
	}

	public ArrayList<String> getSignedBy() {
		return signedBy;
	}
	public String getSignedByString() {
		String s = "";
		for(String i: signedBy) {
			s += i + ", ";
		}
		return s;
	}
	public String toString() {
		String s;
		s = "Property ID: " + this.propertyID + "\nFees: " + this.fees + 
				"\nRepairs: " + this.repairs + "\nTermination: " + this.termination +
				"\nInfo: " + this.info;
		s += "\nSigned By: " + getSignedByString();
		return s;
	}
}
