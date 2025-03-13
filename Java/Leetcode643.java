
// 子数组最大平均数 I
class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int maxSum = Integer.MIN_VALUE;
    int curSum = 0;
    for (int i = 0; i < nums.length; i++) {
      curSum += nums[i];
      if (i < k - 1) {
        continue;
      }
      maxSum = Math.max(maxSum, curSum);
      curSum -= nums[i - k + 1];
    }
    return 1.0 * maxSum / k;
  }
}