public class Leetcode124 {

}
// 二叉树中的最大路径和

// 根 + 左max + 右max
class Solution {
    public int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    // 计算每个节点的最大贡献值, 以该节点为起点的最长路径
    // 以 node 为交叉点的路径最大值 = node.val + leftGain + rightGain
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 贡献值必须大于 0, 因为可以选择不要
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 每次遍历更新 maxSum
        int curSum = node.val + leftGain + rightGain;
        maxSum = Math.max(curSum, maxSum);

        return node.val + Math.max(leftGain, rightGain);
    }
}

/*
 * 竞业协议
 * 参与涉密项目要签订保密协议
 * 国央企 9月入企，实习 9月之前结束
 */