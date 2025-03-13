// 3046. 分割数组
// 给你一个长度为 偶数 的整数数组 nums 。
// 你需要将这个数组分割成 nums1 和 nums2 两部分，要求：
// nums1.length == nums2.length == nums.length / 2 。
// nums1 应包含 互不相同 的元素。
// nums2也应包含 互不相同 的元素。
// 如果能够分割数组就返回 true ，否则返回 false 。


/**
 * @param {number[]} nums
 * @return {boolean}
 */

// 用哈希集统计每个元素出现的次数，如果有元素出现次数大于2，返回false
var isPossibleToSplit = function (nums) {
    let st1 = new Set();
    let st2 = new Set();
    for (const i of nums) {
        if (st2.has(i)) {
            return false;
        } else if (st1.has(i)) {
            st2.add(i);
        } else {
            st1.add(i);
        }
    }
    return true;
};
