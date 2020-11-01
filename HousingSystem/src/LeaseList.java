import java.util.ArrayList;

public class LeaseList {

	private ArrayList<Lease> leases;
	private static LeaseList leaseList;
	
	private LeaseList() {
		leases = DataLoader.loadLeases();
	}
	
	public static LeaseList getInstance()
	{
		if(leaseList == null)
		{
			leaseList = new LeaseList();
		}
		return leaseList;
	}
	
	public ArrayList<Lease> getLeases() {
		return leases;
	}
}
