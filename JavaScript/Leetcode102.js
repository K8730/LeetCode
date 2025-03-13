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
 * @return {number[][]}
 */

// 二叉树的层序遍历

// 两个数组
// 分别存这一层和下一层的节点
var levelOrder = function (root) {
  if (root === null) return [];

  let ans = [];
  let cur = [root]; // 把这一层的根节点存在数组里面

  while (cur.length) {
    let nxt = [];  // 下一层的根节点
    let vals = []; // 这一层的节点值
    for (const node of cur) {
      vals.push(node.val);
      if (node.left) {
        nxt.push(node.left);
      }
      if (node.right) {
        nxt.push(node.right);
      }
    }
    cur = nxt;
    ans.push(vals);
  }
  return ans;
};


// 队列，也就是bfs
// 这里用数组模拟队列
// 好像没有区别，只不过是把 cur数组 和 nxt数组 合起来了
var levelOrder = function (root) {
  if (root === null) return [];

  let ans = [];
  let q = [root];

  while (q.length) {
    let vals = [];
    let len = q.length;
    for (let i = 0; i < len; i++) {
      let node = q.shift(); // 取出头节点
      vals.push(node.val);
      if (node.left) q.push(node.left);
      if (node.right) q.push(node.right);
    }
    ans.push(vals);
  }
  return ans;
};

console.log(levelOrder(new TreeNode(1)))