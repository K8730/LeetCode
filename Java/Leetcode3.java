import java.util.*;

public class Leetcode3 {
    public static void main(String[] args) {

    }
}

/**
 * 滑动窗口
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = ss[right];
            while (set.contains(ch)) {
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}