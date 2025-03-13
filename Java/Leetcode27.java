public class Leetcode27 {

}

// 移除元素

// 快慢指针
class Solution {
    public int removeElement(int[] nums, int val) {
        // 慢指针指向 有效数字 的尾部
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}