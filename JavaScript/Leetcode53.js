/**
 * @param {number[]} nums
 * @return {number}
 */

// 最大子数组和

// 动态规划

var maxSubArray = function (nums) {
  let ans = nums[0];  // 答案
  let sum = 0; // 当前序列和
  for (const num of nums) {
    if (sum > 0) {
      // 如果当前序列和是正值，说明有用，就保留 sum
      sum += num;
    } else {
      // 如果当前序列和是负值，说明没有用，就舍弃 sum
      sum = num;
    }
    ans = Math.max(ans, sum);
  }
  return ans;
};