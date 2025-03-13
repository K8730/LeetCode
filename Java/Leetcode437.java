import java.util.*;

public class Leetcode437 {

}

// 路径总和

// 深度优先搜索
class Solution {
    // 不一定要以 root 为起点
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        // 此处为以 root 为起点
        int ans = rootSum(root, targetSum);
        // 下面是不以 root 作为起点
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }

    // 以 root 为起点, 满足路径和为 targetSum 的数目
    int rootSum(TreeNode root, long targetSum) {
        int ans = 0;

        if (root == null)
            return 0;

        int val = root.val;
        if (val == targetSum) {
            ans++;
        }
        ans += rootSum(root.left, targetSum - val);
        ans += rootSum(root.right, targetSum - val);
        return ans;
    }
}

// 前缀和 + 哈希表
class Solution2 {
    private int ans;

    public int pathSum(TreeNode root, int targetSum) {
        // 键: 路径和, 值: 出现了多少次
        Map<Long, Integer> cnt = new HashMap<>();
        // 放入边界 0
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }

    private void dfs(TreeNode node, long cur, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return;
        }
        cur += node.val;
        ans += cnt.getOrDefault(cur - targetSum, 0);
        cnt.merge(cur, 1, Integer::sum);
        dfs(node.left, cur, targetSum, cnt);
        dfs(node.right, cur, targetSum, cnt);
        cnt.merge(cur, -1, Integer::sum); // 恢复现场
    }
}