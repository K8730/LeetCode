import java.util.*;

public class Leetcode347 {

}

// 前 K 个高频元素
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 哈希表统计每个元素出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b));
        // 频率小的在前面

        // 将前 k 个元素, 加入最小堆中
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.poll();
                queue.offer(key);
            }
        }
        // 取出最小堆中的元素
        // 因为最小堆的大小正好是 k , 所以每一个都是答案
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}