/**
 * @param {number[]} prices
 * @return {number}
 */


// 买卖股票的最佳时机

// 从前往后，找到最小值
var maxProfit = function (prices) {
    let minPrice = Number.MAX_SAFE_INTEGER;
    let ans = 0;
    for (let i = 0; i < prices.length; i++) {
        if (prices[i] < minPrice) {
            minPrice = prices[i];
        } else {
            ans = Math.max(ans, prices[i] - minPrice);
        }
    }
    return ans;
};

// 从后往前，找到最大卖出
var maxProfit = function (prices) {
    let maxPrice = Number.MIN_SAFE_INTEGER;
    let ans = 0;
    for (let i = prices.length - 1; i >= 0; i--) {
        if (prices[i] > maxPrice) {
            maxPrice = prices[i];
        } else {
            ans = Math.max(ans, maxPrice - prices[i]);
        }
    }
    return ans;
};