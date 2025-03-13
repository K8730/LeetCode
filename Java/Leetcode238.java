public class Leetcode238 {

}

// 除自身以外数组的乘积

// 前缀后缀分解
// 前缀 pre(i) = a0 * a1 * ... * ai-1
// 后缀 suf(i) = an-1 * an-2 * ... ai+1
// bi = pre(i) * suf(i)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        ans[0] = 1;
        // 遍历一遍，算出每个 i 的前缀积
        for (int i = 1; i < len; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        // 用 R 记录后缀积
        int R = 1;
        for (int i = len - 1; i >= 0; --i) {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }
}