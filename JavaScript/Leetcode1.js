/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

// 两数之和
var twoSum = function (nums, target) {
  // 哈希表
  const idx = new Map();
  for (let j = 0; ; j++) {
    const x = nums[j];
    if (idx.has(target - x)) {
      return [idx.get(target - x), j];
    }
    idx.set(x, j);
  }
};