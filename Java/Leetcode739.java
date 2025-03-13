import java.util.*;

public class Leetcode739 {

}

// 每日温度
// 暴力解, 时间超限
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int nextHot = 0;
            for (int j = 0; j < ans.length - i; j++) {
                if (temperatures[i + j] > temperatures[i]) {
                    nextHot = j;
                    break;
                }
            }
            ans[i] = nextHot;
        }
        return ans;
    }
}

// 单调栈
class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int temper = temperatures[i];
            while (!stack.isEmpty() && temper > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}