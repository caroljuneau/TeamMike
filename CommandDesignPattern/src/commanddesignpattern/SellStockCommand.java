package commanddesignpattern;

public class SellStockCommand implements Command {

	/**
	* Variables
	*/
	private StockTrade stockTrade;
	private String stockName;
	private int shares;
	
	/**
	* Defines Variables
	*/
	public SellStockCommand(StockTrade stockTrade, String stockName, int shares) {
		this.stockTrade = stockTrade;
		this.stockName = stockName;
		this.shares = shares;
	}
	
	/**
	* Executes stockName with shares
	*/
	public void execute() {
		stockTrade.sell(stockName, shares);
	}

}
