import java.util.*;

public class Leetcode236 {

}

// 二叉树的最近公共祖先

// 广度优先遍历
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean getNewNode = false;
            TreeNode node = new TreeNode();
            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                node = queue.poll();
                if (hasNode(node, p) && hasNode(node, q)) {
                    ans = node;
                    getNewNode = true;
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (!getNewNode) {
                break;
            }
        }
        return ans;
    }

    boolean hasNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return hasNode(root.left, node) || hasNode(root.right, node);
    }
}

// 递归
class Solution2 {

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    // 后序遍历(左右根) 保证 得到的结果是最深(近)的
    boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}

// 改良版

// 最近公共祖先的 p 和 q 位于两侧的
// 如果有一边什么都没有, 说明应该到另一个子树中去查找
class Solution3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果 p q 在root, 就不用继续往下看
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左边没有 p 也没有 q, 说明在另一边
        if (left == null)
            return right;
        if (right == null)
            return left;

        // 如果 p q 分散在 root 两边, 那么最近的就是 root
        return root;
    }
}