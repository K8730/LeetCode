import java.util.*;

public class Leetcode76 {
    public static void main(String[] args) {

    }
}

// 最小覆盖子串

// 滑动窗口，双指针
class Solution {
    public String minWindow(String s, String t) {
        // 先判断特殊情况
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length())
            return "";

        // 用两个哈希表，键：字符，值：数量
        // 储存窗口中的字母数量
        HashMap<Character, Integer> hs = new HashMap<>();
        // 储存 t 中的窗口数量
        HashMap<Character, Integer> ht = new HashMap<>();

        // 用哈希表统计 t 中的字母数量
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ht.put(c, ht.getOrDefault(c, 0) + 1);
        }

        String res = "";
        // 储存窗口中的 有效字符！ 数量
        int cnt = 0;

        // 双指针，i表示窗口右边，j表示窗口左边
        for (int i = 0, j = 0; i < s.length(); i++) {
            // 将第 i 个字符加入哈希表
            char cur = s.charAt(i);
            hs.put(cur, hs.getOrDefault(cur, 0) + 1);
            // 如果这个加入的字符的数量 小于 要求的字符数量
            // 说明就是 有效字符！
            if (hs.get(cur) <= ht.getOrDefault(cur, 0)) {
                cnt++;
            }

            // 如果最左边的字符,是 无效字符，就移动 j
            while (hs.getOrDefault(s.charAt(j), 0) > ht.getOrDefault(s.charAt(j), 0)) {
                hs.put(s.charAt(j), hs.get(s.charAt(j)) - 1);
                j++;
                // 如果已经到头了，就跳出，说明全是无效字符
                if (j == s.length()) {
                    break;
                }
            }

            // 如果有效字符数量等于t的长度，说明全部包含了
            if (cnt == t.length()) {
                // 如果更长，就更新答案
                if (res.isEmpty() || i - j + 1 < res.length()) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }
}

// 滑动窗口，双指针
// 区别就是这个的 cut +1 代表一种字母全部包含，也是就 cut 最大就26个字母
class Solution2 {
    public String minWindow(String s, String t) {
        // 先判断特殊情况
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length())
            return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 初始化 need，记录 t 中每个字符的出现次数
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0; // 窗口的左右边界
        int valid = 0; // 已经匹配上的字符（种类）数量
        int start = 0, minLen = Integer.MAX_VALUE; // 最小窗口的起始位置和长度

        while (right < s.length()) {
            char r = s.charAt(right);
            right++;

            // 更新窗口内字符的计数
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r)))
                    valid++;// 表示 a 字母已经完全包含
            }

            // 当窗口内的字符已经完全包含了 t 中的所有字符时，再缩小
            while (valid == need.size()) {
                // 更新最小窗口的起始位置和长度
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char l = s.charAt(left);
                // 缩小窗口，移动左边界
                if (need.containsKey(l)) {
                    window.put(l, window.get(l) - 1);
                    if (window.get(l) < need.get(l))
                        valid--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
