/**
 * @param {number[]} nums
 * @return {number[][]}
 */

// 全排列

// 深度优先遍历
var permute = function (nums) {
  const n = nums.length;
  const ans = []; // 答案数组
  const path = new Array(n).fill(0); // 每一个答案
  const on_path = new Array(n).fill(false); // 标记是否在排列中

  const dfs = (i) => {
    if (i === n) {
      ans.push([...path]); // ...将数组展开，确保创建一个新数组
      return;
    }
    for (let j = 0; j < n; j++) {
      if (!on_path[j]) {
        path[i] = nums[j];  // 从没有选的数字中选一个
        on_path[j] = true;
        dfs(i + 1); // 深度遍历，把有 num[j] 的情况全部遍历
        on_path[j] = false; // 恢复现场
        // path 无需恢复现场，因为可以直接覆盖
      }
    }
  }

  dfs(0);
  return ans;

};