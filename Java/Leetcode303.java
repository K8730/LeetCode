public class Leetcode303 {

}

// 区域和检索-数组不可变
class NumArray {
    // 定义前缀和
    // s[0] = 0
    // s[1] = a[0]
    // s[2] = a[0] + a[1]
    // ...
    // s[n] = a[0] + a[1] + ... + a[n-1]
    int[] s;

    public NumArray(int[] nums) {
        s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = s[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}