// 跳跃游戏

// 时间超限
class Solution {
    public boolean canJump(int[] nums) {
        return help(nums, 0);
    }

    public boolean help(int[] nums, int cur) {
        if (cur >= nums.length - 1) {
            return true;
        }
        for (int i = nums[cur]; i >= 1; i--) {
            if (help(nums, cur + i)) {
                return true;
            }
        }
        return false;
    }
}

// 贪心算法
class Solution2 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int rightMost = 0;
        for (int i = 0; i < len; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= len - 1)
                    return true;
            }
        }
        return false;
    }
}