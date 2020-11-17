

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
	
	@Test
	void testHaveValidFirstRepairs() {
		boolean repaircheck1 = lease.haveRepairs("repairs1");
		assertTrue(repaircheck1);
	}
	
	@Test
	void testHaveValidSecondRepairs() {
		boolean repaircheck2 = lease.haveRepairs("repairs2");
		assertTrue(repaircheck2);
	}
	
	@Test
	void testHaveValidFirstTermination() {
		boolean terminationcheck1 = lease.haveTermination("termination1");
		assertTrue(terminationcheck1);
	}
	
	@Test
	void testHaveValidSecondTermination() {
		boolean terminationcheck2 = lease.haveTermination("termination2");
		assertTrue(terminationcheck2);
	}
	
	@Test
	void testHaveValidFirstInfo() {
		boolean infocheck1 = lease.haveInfo("info1");
		assertTrue(infocheck1);
	}
	
	@Test
	void testHaveValidSecondInfo() {
		boolean infocheck2 = lease.haveInfo("info2");
		assertTrue(infocheck2);
	}
	// start of chris test
	@Test
	void testHaveInvalidInfo() {
		boolean hasInfo = lease.haveInfo("info3");
		assertFalse(hasInfo);
	}
	
	@Test
	void testHaveEmptyInfo() {
		boolean hasEmpty = lease.haveInfo("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveNullInfol() {
		boolean hasNull = lease.haveInfo("");
		assertFalse(hasNull);
	}
	
	@Test
	void testCreateValidLease() {
		int leaseId = 3;
		Lease l = new Lease(leaseId, leaseId, "fees3", "repairs3", "termination3", "info3");
		leaseList.add(l);
		assertEquals(l, lease.getLease(leaseId));
	}
	
	@Test
	void testCreateDuplicateLease() {
		boolean isCreated = leaseList.add(new Lease(3, 3, "fees3", "repairs3", "termination3", "info3"));
		assertFalse(isCreated);
	}
	
	@Test
	void testCreateEmptyLease() {
		boolean isCreated = leaseList.add(new Lease(0, 0, null, null, null, null));
		assertFalse(isCreated);
	}
}
