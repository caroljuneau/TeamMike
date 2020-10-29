import java.util.ArrayList;

public class PropertyManager extends Account {

	private ArrayList<Integer> myPropertyIDs;
	
	public PropertyManager(int id, String username, String password, String firstName, String lastName, String emailAddress, String phone) {
		super(id, username, password, firstName, lastName, emailAddress, phone);
		this.type = AccountType.PROPERTYMANAGER;
	}
	
	public ArrayList<Integer> getMyPropertyIDs() {
		return myPropertyIDs;
	}

	public void setMyPropertyIDs(ArrayList<Integer> myPropertyIDs) {
		this.myPropertyIDs = myPropertyIDs;
	}
	
	public String toString() {
		String s;
		s = super.toString();
		return s;
	}

}
