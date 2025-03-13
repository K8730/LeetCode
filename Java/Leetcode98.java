import java.util.*;

public class Leetcode98 {

}

// 验证二叉搜索树

// 考虑以 root 为根的子树，判断子树中所有节点的值是否都在 (l,r) 的范围内
class Solution {
    public boolean isValidBST(TreeNode root) {
        // 最开始是无限制
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 一步一步缩小限制
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}

// 二叉搜索树「中序遍历」(左根右)得到的值构成的序列一定是升序的
class Solution2 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}