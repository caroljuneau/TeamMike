import java.util.ArrayList;

public class LeaseList {

	private ArrayList<Lease> leases;
	private static LeaseList leaseList;

	private LeaseList() {
		leases = DataLoader.loadLeases();
	}

	public static LeaseList getInstance() {
		if (leaseList == null) {
			leaseList = new LeaseList();
		}
		return leaseList;
	}

	public ArrayList<Lease> getLeases() {
		return leases;
	}

	public Lease getLease(int id) {
		for (Lease l : leases) {
			if (l.getId() == id) {
				return l;
			}
		}
		return null;
	}

	public int getSize() {
		return leases.size();
	}

	public Lease addLease(int id, int propertyID, String fees, String repairs, String termination, String info) {
		Lease lease = new Lease(id, propertyID, fees, repairs, termination, info);
		leases.add(lease);
//		DataWriter.saveReview(); TODO
		return lease;
	}
}
