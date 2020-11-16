

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeaseTest {
	private LeaseList lease = LeaseList.getInstance();
	private ArrayList<Lease> leaseList = lease.getLeases();

	@BeforeEach
	public void setup() {
		leaseList.clear();
		leaseList.add(new Lease(1, 1, "fees1", "repairs1", "termination1", "info1"));
		leaseList.add(new Lease(2, 2, "fees2", "repairs2", "termination2", "info2"));
		DataWriter.saveLease();
	}

	@AfterEach
	public void tearDown() {
		LeaseList.getInstance().getLeases().clear();
		DataWriter.saveLease();
	}


	@Test
	void testHaveValidFirstFee() {
		boolean idcheck1 = lease.haveFees("fees1");
		assertTrue(idcheck1);
	}

	@Test
	void testHaveValidSecondFee() {
		boolean idcheck2 = lease.haveFees("fees2");
		assertTrue(idcheck2);
	}
}
