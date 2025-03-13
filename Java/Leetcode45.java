// 跳跃游戏 II

// 向前查找一步可到达的最远位置
// 遍历到最远位置后, 开始查找下一步的最远位置 
class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int end = 0; // 表示上一步的尽头
        int maxPosition = 0; // 下一步最远位置
        int steps = 0;

        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}