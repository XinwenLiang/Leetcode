package Day28;

public class StockProfit {
    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length ; i++) {
            count += Math.max(prices[i] - prices[i-1],0);
        }
        return count;
    }
}
