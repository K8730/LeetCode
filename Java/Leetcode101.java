import java.util.*;

public class Leetcode101 {

}

// 对称二叉树

// 递归写法
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return equal(root.left, root.right);
    }

    public boolean equal(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if ((a == null && b != null) || (a != null && b == null)) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        // 注意是轴对称相等, 而不是克隆相等
        return (equal(a.left, b.right) && equal(a.right, b.left));
    }
}

// 迭代写法
// 队列
class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            // 拿出这一层的节点, 检查
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            // 按相反顺序加入队列
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
