package commanddesignpattern;

public class BuyStockCommand implements Command {
	private StockTrade stockTrade;
	private String stockName;
	private int shares;
	
	public BuyStockCommand(StockTrade stockTrade, String stockName, int shares) {
		this.stockTrade = stockTrade;
		this.stockName = stockName;
		this.shares = shares;
	}
	
	public void execute() {
		stockTrade.buy(stockName, shares);
	}

}
