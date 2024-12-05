/*
121. Best Time to Buy and Sell Stock
Easy
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 
Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        int buyingPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (buyingPrice < prices[i]) {
                int Profit = prices[i] - buyingPrice;
                max_profit = Math.max(max_profit, Profit); 
            } else {
                buyingPrice = prices[i];
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        // Test case 1: Prices with a potential to make profit
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit (Test Case 1): " + maxProfit(prices1)); // Expected output: 5 (buy at 1, sell at 6)

        // Test case 2: Prices where no profit can be made
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max profit (Test Case 2): " + maxProfit(prices2)); // Expected output: 0 (no profit)

        // Test case 3: Prices with no change
        int[] prices3 = {5, 5, 5, 5, 5};
        System.out.println("Max profit (Test Case 3): " + maxProfit(prices3)); // Expected output: 0 (no profit)

        // Test case 4: Prices with only one price point
        int[] prices4 = {10};
        System.out.println("Max profit (Test Case 4): " + maxProfit(prices4)); // Expected output: 0 (no profit)

        // Test case 5: Prices with an increasing trend
        int[] prices5 = {1, 2, 3, 4, 5};
        System.out.println("Max profit (Test Case 5): " + maxProfit(prices5)); // Expected output: 4 (buy at 1, sell at 5)
    }
}
