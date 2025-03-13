/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

// 移动零

var moveZeroes = function (nums) {
    let ptr = 0;
    let n = nums.length;
    for (let i = 0; i < n; i++) {
        if (nums[i] != 0) {
            nums[ptr++] = nums[i];
        }
    }
    for (; ptr < n; ptr++) {
        nums[ptr] = 0;
    }
};