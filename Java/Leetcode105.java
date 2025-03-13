import java.util.HashMap;

public class Leetcode105 {

}

// 从前序与中序遍历序列构造二叉树

// 前序遍历: 根 左 右
// 中序遍历: 左 根 右

class Solution {
    int[] preorder;
    // 键: 节点值 值: 节点下标
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 便于 recur 函数使用 preorder 数组
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    // root: 根节点在 pre 中的索引
    // left: 子树在 inorder 中的左边界
    // right: 子树在 inorder 中的右边界
    TreeNode recur(int root, int left, int right) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]);
        // root + 1 为左子树的根节点的索引
        node.left = recur(root + 1, left, i - 1);
        // root + i - left + 1 为右子树的根节点索引
        // 其中 (i - left) 为左子树的长度
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;
    }
}