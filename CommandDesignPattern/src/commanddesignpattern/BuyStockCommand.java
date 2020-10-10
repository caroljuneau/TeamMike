package commanddesignpattern;

public class BuyStockCommand implements Command {

	/**
	* Private Variables
	*/
	private StockTrade stockTrade;
	private String stockName;
	private int shares;
	
	/**
	* Defines Variables
	*/
	public BuyStockCommand(StockTrade stockTrade, String stockName, int shares) {
		this.stockTrade = stockTrade;
		this.stockName = stockName;
		this.shares = shares;
	}
	
	/**
	* Executes stockName with shares
	*/
	public void execute() {
		stockTrade.buy(stockName, shares);
	}

}
