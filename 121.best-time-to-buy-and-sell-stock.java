import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    // int maxProfit = 0;
    Stack<Integer> stack = new Stack<>();

    public int maxProfit(int[] prices) {


        int[] nge = new int[prices.length];
        nge = populateNGE(prices, prices.length - 1, nge);
        return findMaxProfit(prices, nge, 0, 0);
    }

    private int findMaxProfit(int[] prices, int[] nge, int i, int maxProfit) {
        if (i >= prices.length)
            return maxProfit;
        if (i + 1 < prices.length) {
            int profit = nge[i+1] - prices[i];

            if (profit > maxProfit)
                maxProfit = profit;

        }
        return findMaxProfit(prices, nge, ++i, maxProfit);
    }

    private int[] populateNGE(int[] prices, int i, int[] nge) {
        if (i < 0)
            return nge;
        while (!stack.isEmpty() && prices[i] >= stack.peek())
            stack.pop();

        if (stack.isEmpty())
            nge[i] = -1;
        else
            nge[i] = stack.peek();
        stack.push(prices[i]);
        return populateNGE(prices, --i, nge);
    }
}
// @lc code=end
