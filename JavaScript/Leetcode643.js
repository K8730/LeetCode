/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function (nums, k) {
  // let maxSum = Number.MIN_VALUE; 这里不能用 MIN_VALUE (无法与number比较)
  let maxSum = Number.MIN_SAFE_INTEGER;
  let curSum = 0;
  for (let i = 0; i < nums.length; i++) {
    curSum += nums[i];
    if (i < k - 1) {
      continue;
    }
    maxSum = Math.max(maxSum, curSum);
    curSum -= nums[i - k + 1];
  }
  return maxSum / k;
};