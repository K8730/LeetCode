public class Leetcode209 {

}

// 长度最小的子数组

// 滑动窗口
// 1 窗口内是什么
// 2 如何移动窗口的 结束位置
// 3 如何移动窗口的 起始位置
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        // 遍历窗口的 结束位置
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 动态调节窗口的 起始位置
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}