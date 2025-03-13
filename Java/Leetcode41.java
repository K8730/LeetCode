import java.util.*;

public class Leetcode41 {

}

// 缺失的第一个正数

// 把所有数字放入哈希表
// 遍历找到缺失的数字
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> hash = new HashSet<Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            hash.add(nums[i]);
        }
        // 答案只可能出现在 [1, n + 1] 内
        for (int i = 1; i < len + 1; i++) {
            if (!hash.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}

// 用下标储存答案
// 空间复杂度为 O(1)
// 关键：答案只可能出现在 [1, n + 1] 内
// 用数组的下标来保存答案，下标对应的数设置为负数，说明不是答案
// [0, n - 1] 对应到 [1, n]
// 如果遍历结束都没有，答案就是 n + 1
class Solution1 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 负数一定不是答案，设置成 n + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }

        }
        // 如果出现，就用负号来标记
        for (int i = 0; i < n; i++) {
            // 用 abs 防止负号的影响
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 再一次遍历，找到答案
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 没找到就是全有，返回 n + 1
        return n + 1;
    }
}

// 置换法
// 数字 x 应该出现在 num[x - 1] 的位置
// 如果出现的数字不是 x ，说明该下标对应的数是缺失的
class Solution2 {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 如果 nums[i] 在 [1, n] 内，说明需要置换
            // 当置换相同数字时，要停止
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}