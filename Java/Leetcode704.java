public class Leetcode704 {
}

// 二分查找

// 左闭右闭区间
class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 避免溢出
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 目标在右边，修改左边界
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 目标在左边，修改右边界
                right = mid - 1;
            }
        }
        return -1;
    }
}