package commanddesignpattern;
import java.util.*;
/**
 * 
 * @author chris
 * Agent is a class who manages stock orders to buy or sell, and executes them accordingly.
 * @orders stores all stock orders (buy/sell) in an arraylist.
 */
public class Agent {

	private ArrayList<Command> orders;
	
	/** 
	 * Agent() initializes the orders ArrayList<Command>
	 */
	public Agent() {
		this.orders = new ArrayList<Command>();
	}
	/**
	 * 
	 * @param command is a buy/sell order
	 * placeOrder(Command command) takes in a command
	 * and adds it to the list.
	 */
	public void placeOrder(Command command) {
		this.orders.add(command);
	}
	/**
	 * processOrders() iterates through the list
	 * and executes commands accordingly, buy or sell.
	 */
	public void processOrders() {
		for(Command c : orders) {
			c.execute();
		}
	}

}
