/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */

// 寻找两个正序数组的中位数

var findMedianSortedArrays = function (nums1, nums2) {
    // 保证前面是更短的数组
    if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }

    let m = nums1.length; // 较短的那条
    let n = nums2.length;
    let imin = 0, imax = m; // 用于二分查找，找到中位数在短条中的位置
    let halfLen = Math.floor((m + n + 1) / 2); // 中位数的位置

    // 使用二分查找
    while (imin <= imax) {
        let i = Math.floor((imin + imax) / 2); // num1 的分割点
        let j = halfLen - i; // nums2 的分割点

        if (i < m && nums1[i] < nums2[j - 1]) {

        }
    }
};