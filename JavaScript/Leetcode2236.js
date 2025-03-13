// 2236. 判断根结点是否等于子结点之和
import { TreeNode } from "./ds.js"


/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var checkTree = function (root) {
    if (root.val === root.left.val + root.right.val) {
        return true;
    } else {
        return false;
    }
};