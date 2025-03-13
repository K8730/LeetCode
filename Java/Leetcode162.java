public class Leetcode162 {

}

// 寻找峰值
class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}

// 找到最大值
class Solution2 {
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}

// 二分查找优化
class Solution3 {
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (arr.length == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[n - 1] > arr[n - 2])
            return n - 1;

        int l = 1, r = n - 2, m = 0, ans = -1;
        while (l <= r) {
            m = (l + r) / 2;
            // 如果左边有大的点, 说明左边有峰值点, 移动 r
            if (arr[m - 1] > arr[m]) {
                r = m - 1;
            } else if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                ans = m;
                break;
            }
        }
        return ans;
    }
}