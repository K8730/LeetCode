// 1512. 好数对的数目

/**
 * @param {number[]} nums
 * @return {number}
 */

// 用哈希表 维护左边每个数出现的次数
var numIdenticalPairs = function (nums) {
    let ans = 0;
    const cnt = new Map();
    for (const x of nums) {
        const c = cnt[x] ?? 0;
        ans += c; // 更新答案
        cnt[x] = c + 1; // 更新哈希表
    }
    return ans;
};