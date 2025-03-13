public class Leetcode912 {

}

// 排序数组

// 堆排序
class Solution1 {
    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            heapSort2(nums);
        }
        return nums;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void heapify(int[] arr, int i, int size) {
        int left = i * 2 + 1;
        while (left < size) {
            int best = (left + 1 < size && arr[left + 1] > arr[left]) ? left + 1 : left;
            best = (arr[best] > arr[i]) ? best : i;
            if (best == i)
                break;
            swap(arr, best, i);
            i = best;
            left = i * 2 + 1;
        }
    }

    public void heapSort2(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        int size = n;
        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }
}