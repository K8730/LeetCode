// 852. 山脉数组的峰顶索引

/**
 * @param {number[]} arr
 * @return {number}
 */

// 二分查找
var peakIndexInMountainArray = function (arr) {
    let left = 0, right = arr.length - 2;
    while (left + 1 < right) {
        const mid = Math.floor((left + right) / 2);
        if (arr[mid] > arr[mid + 1]) {
            right = mid;
        } else {
            left = mid;
        }
    }
    return right;
};

/**
 * @param {number[]} arr
 * @return {number}
 */
var peakIndexInMountainArray = function (arr) {
    let left = 0, right = arr.length - 1;
    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            return mid;
        } else if (arr[mid] < arr[mid + 1]) {
            left = mid;
        } else {
            right = mid;
        }
    }
};