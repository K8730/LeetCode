/**
 * @param {number[]} nums
 * @return {number}
 */

// 最长连续序列
// 输入：nums = [100,4,200,1,3,2]
// 输出：4
// 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

// 1. 哈希集，做到O(1)判断数字是否在nums中
// 2. 如果 x-1 在哈希集合中，则不以 x 为起点
// 2. 如果 x-1 不在哈希结合中，则计算这条序列的长度
var longestConsecutive = function (nums) {
    // 将nums转成哈希集合
    const set = new Set(nums);
    // for (const num of nums) {
    //     set.add(num);
    // }

    let maxLen = 0;
    for (const num of nums) {
        if (!set.has(num - 1)) {
            let curNum = num;
            let curLen = 1;

            while (set.has(curNum + 1)) {
                curNum += 1;
                curLen += 1;
            }

            maxLen = Math.max(maxLen, curLen);
        }
    }

    return maxLen;
};