public class Leetcode977 {

}

// 有序数组的平方

// 双指针
class Solution {
    public int[] sortedSquares(int[] nums) {
        // 两个指针分别指向 队首 和 队尾
        int right = nums.length - 1;
        int left = 0;

        int[] result = new int[nums.length];
        // 从后往前填充答案
        int index = nums.length - 1;

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                index--;
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }

        return result;
    }
}