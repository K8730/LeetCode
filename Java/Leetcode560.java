import java.util.*;

public class Leetcode560 {
    public static void main(String[] args) {

    }
}

// 和为 K 的子数组

// class Solution {
// public int subarraySum(int[] nums, int k) {
// int res = 0;
// int i = 0, j = 0;
// int sum = nums[0];
// while (i < nums.length) {
// if (sum == k) {
// if (i == nums.length)
// sum += nums[++i];
// sum -= nums[j++];
// res++;
// } else if (sum < k) {
// sum += nums[++i];
// } else if (sum > k) {
// sum -= nums[j++];
// }
// }
// return res;
// }
// }

// 枚举
class Solution1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // 遍历以start结尾的所有情况
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

// 前缀和 + 哈希表
// pre[i] - pre[j - 1] == k
// pre[j - 1] == pre[i] - k
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        // pre 表示前缀和，前缀和不用重新遍历，直接加上当前值就可以
        int count = 0, pre = 0;
        // 键：前缀和。值：出现的次数
        HashMap<Integer, Integer> mp = new HashMap<>();
        // 对应pre[0]
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            // 把此时前缀和加入哈希表
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
