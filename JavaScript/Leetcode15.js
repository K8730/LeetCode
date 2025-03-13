/**
 * @param {number[]} nums
 * @return {number[][]}
 */

// 三数之和

// 先排序
// 固定第一个数
// 双指针遍历剩下两个数值
var threeSum = function (nums) {
  let ans = [];
  const len = nums.length;
  // 特殊情况
  if (nums == null || len < 3) {
    return ans;
  }

  nums.sort((a, b) => a - b); // 排序

  for (let i = 0; i < len; i++) {
    // 第一个数必须是负数
    if (nums[i] > 0) {
      break;
    }

    // 去掉重复
    if (i > 0 && nums[i] == nums[i - 1]) {
      continue;
    }

    // 左指针，右指针
    let left = i + 1;
    let right = len - 1;

    while (left < right) {
      const sum = nums[i] + nums[left] + nums[right];
      if (sum == 0) {
        ans.push([nums[i], nums[left], nums[right]]);
        // 得到答案后，去掉重复的 left 和 right
        while (left < right && nums[left] == nums[left + 1]) left++;
        while (left < right && nums[right] == nums[right + 1]) right--;
        left++;
        right--;
      } else if (sum < 0) {
        left++;
      } else if (sum > 0) {
        right--;
      }
    }
  }
  return ans;
};