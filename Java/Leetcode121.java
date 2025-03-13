//买卖股票的最佳时机

// 从后往前, 储存最大卖出
class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            } else {
                ans = Math.max(maxPrice - prices[i], ans);
            }
        }
        return ans;
    }
}

// 从前往后, 储存最小花费
class Solution2 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            ans = Math.max(ans, price - cost);
        }
        return ans;
    }
}
