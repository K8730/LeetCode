import java.util.*;

public class Leetcode145 {

}

// 二叉树的后序遍历

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && root != cur.left && root != cur.right) {
                    stack.push(cur.left);
                } else if (cur.right != null && root != cur.right) {
                    stack.push(cur.right);
                } else {
                    ans.add(cur.val);
                    root = stack.pop();
                }
            }
        }
        return ans;
    }
}