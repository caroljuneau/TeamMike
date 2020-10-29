public class Lease {

	private Property property;
	private String fees;
	private String repairs;
	private String info;
	private boolean signed;
	private ArrayList<String> signedBy;

	public Lease(Property property, String fees, String repairs, String termination, String info) {
		this.property = property;
		this.fees = fees;
		this.repairs = repairs;
		this.termination = termination;
		this.info = info;
	}

	public void sign(String fullName) {
		this.fullname = fullname;
	}

	public boolean getSigned() {
		return signed;
	}

	public ArrayList<String> getSignedBy() {
		return signedBy;
	}

	public String toString() {
		String s;
		s = super.toString();
		return s;
	}
}
