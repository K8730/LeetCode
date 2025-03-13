import { TreeNode } from "./ds.js"

// 路径总和
// 判断该树中是否存在 根节点到叶子节点 的路径
// 这条路径上所有节点值相加等于目标和 targetSum

/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {boolean}
 */
var hasPathSum = function (root, targetSum) {
    if (root === null) { // root 是null
        return false;
    }
    if (root.left === root.right) { // root是叶节点的简单写法
        return root.val === targetSum;
    } else {  // root 不是叶节点
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
};

