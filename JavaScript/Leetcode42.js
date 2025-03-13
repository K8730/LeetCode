/**
 * @param {number[]} height
 * @return {number}
 */

// 接雨水


// 用俩个数组分别表示左边最大高度和右边最大高度
var trap = function (height) {
    let n = height.length;

    let leftMax = new Array(n).fill(0);
    leftMax[0] = height[0];
    for (let i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }

    let rightMax = new Array(n).fill(0);
    rightMax[n - 1] = height[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], height[i])
    }

    let ans = 0;
    for (let i = 0; i < n; i++) {
        ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return ans;
};

console.log(trap([2, 1, 3]))