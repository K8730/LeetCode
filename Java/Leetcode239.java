import java.util.*;

public class Leetcode239 {

}

// 暴力解法，遍历，失败
// class Solution {
// public int[] maxSlidingWindow(int[] nums, int k) {
// if (k == 1) {
// return nums;
// }
// int[] res = new int[nums.length - k + 1];

// for (int i = 0; i < res.length; i++) {
// // 注意最小值要用 Integer.MIN_VALUE
// int maxValue = Integer.MIN_VALUE;
// for (int j = 0; j < k; j++) {
// maxValue = Math.max(maxValue, nums[i + j]);
// }
// res[i] = maxValue;
// }

// return res;
// }
// }

// 优先队列
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 创建一个优先队列，存储数组中的元素及其索引，按元素值降序排列
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                // 如果元素值不同，按元素值降序排列；如果元素值相同，按索引降序排列
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        // 初始化优先队列，将前 k 个元素加入队列
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[] { nums[i], i });
        }

        // 创建结果数组，长度为 n - k + 1
        int[] ans = new int[n - k + 1];
        // 将第一个窗口的最大值存入结果数组
        ans[0] = pq.peek()[0];

        // 遍历数组，从第 k 个元素开始
        for (int i = k; i < n; ++i) {
            // 将当前元素及其索引加入优先队列
            pq.offer(new int[] { nums[i], i });
            // 移除队列中不在当前窗口范围内的元素
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            // 将当前窗口的最大值存入结果数组
            ans[i - k + 1] = pq.peek()[0];
        }

        // 返回结果数组
        return ans;
    }
}

// 单调队列
// O(n)
class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 维护一个单调递减的队列，队列储存的是数组下标
        Deque<Integer> deque = new LinkedList<Integer>();

        // 初始化第一个队列
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                // 如果新来的元素比队尾元素大，就删掉队尾元素，保持单调性
                deque.pollLast();
            }
            // 将新来的加到队尾
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];

        // 遍历过程中，维护队列单调性
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 如果下标已经到了窗口左边，也要弹出
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 遍历一个就要得出一个窗口最大值，也就是单调队列的队头
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
