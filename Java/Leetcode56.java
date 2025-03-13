import java.util.*;

public class Leetcode56 {

}

// 合并区间
// 1 按左端点排序
// 2-1 有交集 更新右端点
// 2-2 无交集 保存当前区间
class Solution {
    public int[][] merge(int[][] intervals) {
        // 按左端点排序，注意排序怎么写
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            // 当前区间和下一区间没有交集
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < start) {
                merged.add(new int[] { start, end });
            } else {
                // 如果有交集，取最远端为右端点
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}