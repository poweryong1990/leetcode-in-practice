package dynamicProgramming;

public class BestTimeToBuyAndSellStock {
	/**
	 * Say you have an array for which the i-th element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
	 * design an algorithm to find the maximum profit.
	 */
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
//        int buy, sell;
        int maxProfit = 0, profit = 0;
        for(int i = 1; i < prices.length; i++){
        	profit += prices[i] - prices[i-1];
        	if(profit < 0){
        		profit = 0;
        	}else if(maxProfit < profit){
        		maxProfit = profit;
        	}
        }
        return maxProfit;
    }
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
	 * (ie, buy one and sell one share of the stock multiple times). 
	 * However, you may not engage in multiple transactions at the same time 
	 * (ie, you must sell the stock before you buy again).
	 */
	public int maxProfitII(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int buyDay = 0, profit = 0;
        for(int i = 1; i < prices.length; i++){
        	if(prices[i-1] > prices[i]){
        		profit += prices[i-1] - prices[buyDay];
        		buyDay = i;
        	}
        }
        profit += prices[prices.length-1] - prices[buyDay];
        return profit;
    }
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
	 * Note:
	 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 */
	public int maxProfitIII(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
        	if(prices[i-1] > prices[i]){
        		int profit = maxProfit(prices, 0, i-1) + maxProfit(prices, i, prices.length -1);
        		if(maxProfit < profit){
        			maxProfit = profit;
        		}
        	}
        }
        return maxProfit;
    }
	int maxProfit(int[] prices,int from, int to){
		if(from >= to) return 0;
        int maxProfit = 0, profit = 0;
        for(int i = from + 1; i <= to; i++){
      	  profit += prices[i] - prices[i-1];
      	  if(profit < 0){
      		  profit = 0;
      	  }else if(maxProfit < profit){
      		  maxProfit = profit;
      	  }
        }
        return maxProfit;
	}
	public int maxProfitIII_2(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int[] maxProfit = new int[prices.length];
        int buyPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] < buyPrice){
        		buyPrice = prices[i];
        		maxProfit[i] = maxProfit[i-1];
        	}else if(prices[i] - buyPrice > maxProfit[i-1]){
        		maxProfit[i] = prices[i] - buyPrice;
        	}else{
        		maxProfit[i] = maxProfit[i-1];
        	}
        }
        int max = maxProfit[maxProfit.length -1];
        int sellPrice = prices[prices.length-1];
        int secondTransactionMaxProfit = 0;
        for(int i = prices.length -1; i > 0; i--){
        	if(prices[i] > sellPrice){
        		sellPrice = prices[i];
        	}else if(sellPrice - prices[i] > secondTransactionMaxProfit){
        		secondTransactionMaxProfit = sellPrice - prices[i]; 
        	}
        	if(max < maxProfit[i-1] + secondTransactionMaxProfit){
        		max = maxProfit[i-1] + secondTransactionMaxProfit;
        	}
        }
        return max;
	}
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	
	Design an algorithm to find the maximum profit. You may complete at most k transactions.
	
	Note:
	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 */
	public int maxProfitIV(int k, int[] prices) {
		if(k < 1 || prices == null || prices.length <= 1) return 0;
		return maxProfitIV(k, prices, prices.length);
    }
	int maxProfitIV(int k, int[] prices, int n) {// prices[0, n-1] max profit in k transactions
        if(k < 1 || n < 2) return 0;
        int sell = prices[n-1];
        int max = 0;
        for(int i = n - 1; i > 0; --i){
        	if(prices[i-1] > prices[i]){
        		if(prices[i] < sell){
        			int p = maxProfit(prices, i, n-1) + maxProfitIV(k -1, prices, i);
        			if(max < p) max = p;
        		}
        		sell = prices[i -1];
        	}
        }
        if(prices[0] < sell){
        	int p = maxProfit(prices, 0, n-1);
            if(max < p) max = p;
        }
        return max;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();
		//         0  1 2 3  4 5 6  7   8 9
		int[] a = {5, 3,4,7, 5,9,10,11, 8};
		int[] b = {5, 3,4,7, 2,9,10,11, 8};
		int[] c = {5, 3,4,7, 2,9,10,11, 8,18};
//		System.out.println(s.maxProfit(a) + "->" + s.maxProfit(a, 0) + " <-maxProfit(prices, start)");
//		System.out.println(s.maxProfit(b) + "->" + s.maxProfit(b, 0) + " <-maxProfit(prices, start)");
//		System.out.println(s.maxProfit(c) + "->" + s.maxProfit(c, 0) + " <-maxProfit(prices, start)");
//		System.out.println("maxProfitIII:");
//		System.out.println(s.maxProfitIII(a) + ", " + s.maxProfitIII_2(a));
//		System.out.println(s.maxProfitIII(b) + ", " + s.maxProfitIII_2(b));
//		System.out.println(s.maxProfitIII(c) + ", " + s.maxProfitIII_2(c));
		
		System.out.println("maxProfitIV");
		System.out.println(s.maxProfit(a) + "->" +s.maxProfitIV(1,a));
		System.out.println(s.maxProfit(b) + "->" +s.maxProfitIV(1,b));
		System.out.println(s.maxProfit(c) + "->" +s.maxProfitIV(1,c));
		System.out.println("2 times");
		System.out.println(s.maxProfitIII(a) + "->" +s.maxProfitIV(2,a));
		System.out.println(s.maxProfitIII(b) + "->" +s.maxProfitIV(2,b));
		System.out.println(s.maxProfitIII(c) + "->" +s.maxProfitIV(2,c));
		System.out.println("many times");
		System.out.println(s.maxProfitII(a) + "->" +s.maxProfitIV(4,a));
		System.out.println(s.maxProfitII(b) + "->" +s.maxProfitIV(2,b));
		System.out.println(s.maxProfitII(c) + "->" +s.maxProfitIV(5,c));
		
//		System.out.println(s.maxProfitIV(3,a));
	}

}
