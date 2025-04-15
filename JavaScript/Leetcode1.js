// 1. 两数之和

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

var twoSum = function (nums, target) {
  // 哈希表
  // 键：数值
  // 值：下标
  const idx = new Map();
  for (let i = 0; ; i++) {
    const x = nums[i];
    // 判断是否存在 target - x
    if (idx.has(target - x)) {
      return [idx.get(target - x), i];
    }
    idx.set(x, i);
  }
};