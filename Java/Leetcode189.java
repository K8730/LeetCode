public class Leetcode189 {

}

// 轮转数组

// 一步一步轮转
class Solution {
    public void rotate(int[] nums, int k) {

        int tmp;
        for (int j = 0; j < k; j++) {
            for (int i = 1; i < nums.length; i++) {
                tmp = nums[0];
                nums[0] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}

// 三个反转
class Solution2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // 轮转 k 次等于轮转 k%n 次
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

// 直接再开一个数组
class Solution3 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
