import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int res = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int cur_num = num;
                int cur_streak = 1;

                while (num_set.contains(cur_num + 1)) {
                    cur_num += 1;
                    cur_streak += 1;
                }

                res = Math.max(res, cur_streak);
            }
        }
        return res;
    }
}