// 盛最多水的容器
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。


/**
 * @param {number[]} height
 * @return {number}
 */


// 贪心算法
// 局部最优 -> 全局最优
// 首先把宽度放到最大，然后再去找高度
// 如果左边的高度小，那么必定要舍弃左边的，不然面积不会增大
var maxArea = function (height) {
    let left = 0;
    let right = height.length - 1;
    let maxWater = 0;
    maxWater = (right - left) * Math.min(height[left], height[right]);

    while (left < right) {
        if (height[left] < height[right]) {
            left++;
            maxWater = Math.max(maxWater, (right - left) * Math.min(height[right], height[left]));
        } else {
            right--;
            maxWater = Math.max(maxWater, (right - left) * Math.min(height[left], height[right]));
        }
    }

    return maxWater;
};