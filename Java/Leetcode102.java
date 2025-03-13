import java.util.*;

public class Leetcode102 {

}

// 二叉树的层序遍历

// 广度优先搜索
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 用来记录这一层的值
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();

            // 进行拓展(即 offer左右) size 次
            // 即一次取 size 个元素的广度优先搜索
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}