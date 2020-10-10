package commanddesignpattern;
import java.util.*;

public class Agent {

	private ArrayList<Command> orders;
	
	public Agent() {
		this.orders = new ArrayList<Command>();
	}
	
	public void placeOrder(Command command) {
		this.orders.add(command);
	}
	
	public void processOrders() {
		for(Command c : orders) {
			c.execute();
		}
	}

}
