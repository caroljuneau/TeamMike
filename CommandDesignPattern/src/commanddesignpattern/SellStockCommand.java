package commanddesignpattern;

public class SellStockCommand implements Command {
	private StockTrade stockTrade;
	private String stockName;
	private int shares;
	
	public SellStockCommand(StockTrade stockTrade, String stockName, int shares) {
		this.stockTrade = stockTrade;
		this.stockName = stockName;
		this.shares = shares;
	}
	
	public void execute() {
		stockTrade.sell(stockName, shares);
	}

}
