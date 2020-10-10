package commanddesignpattern;

public class StockTrade {
	
	/**
	 * This is the method that displays different messages 
	 */
	
	public StockTrade() {
		
	}
	
	/**
	 * This method is used to buy the entered number of shares of the entered stock name
	 * @param stockName the value held for the specfic stock the user wants to purchase
	 * @param numShares the value for how many shares the user wants to buy or sell
	 */
	
	public void buy(String stockName, int numShares) {
		System.out.println("Buying " + numShares + " of " + stockName);
	}
	
	/**
	 * This method is used to buy the entered number of shares of the entered stock name
	 * @param stockName the value held for the specfic stock the user wants to purchase
	 * @param numShares the value for how many shares the user wants to buy or sell
	 */
	
	public void sell(String stockName, int numShares) {
		System.out.println("Selling " + numShares + " of " + stockName);
	}
	

}
