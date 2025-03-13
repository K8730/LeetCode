import java.util.PriorityQueue;

public class Leetcode215 {

}

// 数组中的第K个最大元素
class Solution {

    // 随机选择算法，时间复杂度O(n)
    public static int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, nums.length - k);
    }

    // 如果arr排序的话，在i位置的数字(第i个数字)是什么
    public static int randomizedSelect(int[] arr, int i) {
        int ans = 0;
        for (int l = 0, r = arr.length - 1; l <= r;) {
            // 随机选一个数字 x，常数时间比较大
            // 但只有这一下随机，才能在概率上把时间复杂度收敛到O(n)
            partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]);
            // 因为左右两侧只需要走一侧
            // 所以不需要临时变量记录全局的first、last
            // 直接用即可
            if (i < first) {
                r = first - 1;
            } else if (i > last) {
                l = last + 1;
            } else {
                ans = arr[i];
                break;
            }
        }
        return ans;
    }

    // 荷兰国旗问题
    public static int first, last;

    // <x ==x >x 划分, 并保存 first last
    public static void partition(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                swap(arr, first++, i++);
            } else {
                swap(arr, i, last--);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

// 堆排序
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        // 创建一个最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 遍历数组的前 k 个元素, 加入最小堆中
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        // 遍历剩余元素
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();// 移除堆顶元素
                heap.offer(nums[i]);// 加入较大的元素到堆中
            }
            // 如果第i元素比堆顶还要小, 就不管了
        }
        return heap.peek();
    }
}