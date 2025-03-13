import java.util.*;

public class Leetcode114 {

}

// 二叉树展开为链表
// 1 将左边子树放到右子树的地方
// 2 把原来的右子树放到右下方
// 3 考虑下面一个根节点
class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            // 左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
}

// 反向的前序遍历, 避免右孩子丢失
// 特殊的后序遍历(右左根)

class Solution2 {
    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}

// 前序遍历, 但是用栈来保存右子树, 所以可以直接修改 right
class Solution3 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            if (pre != null) {
                pre.right = temp;
                pre.left = null;
            }
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
            pre = temp;
        }
    }
}