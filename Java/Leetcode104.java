import java.util.*;

public class Leetcode104 {

}

// 二叉树的最大深度

// 递归 深度优先搜索
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// 广度优先搜索
class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;// 记录深度
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                // 上一层的出队列, 下一层的进队列
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}