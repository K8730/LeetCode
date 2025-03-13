/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */


// 数组中的第K个最大元素

// 快速排序，分治法
// 时间复杂度为 O(nlogn)
var findKthLargest = function (nums, k) {
    nums.sort((a, b) => b - a);
    return nums[k - 1];
};

// 快速选择
// 时间复杂度为 O(n)
// 先随机选择一个基准数，然后将数组分为三部分
// 大于基准数的放在左边，小于基准数的放在右边，等于基准数的放在中间
// 相当于是快速排序的一部分，只需要找到第 k 大的元素即可
// 对快速排序剪枝
var findKthLargest = function (nums, k) {

    return quickSelect(nums, k);
    function quickSelect(nums, k) {
        // 随机选择基准数
        let pivot = nums[Math.floor(Math.random() * nums.length)];
        let big = [], equal = [], small = [];

        // 将数组分为三部分
        for (let num of nums) {
            if (num > pivot) {
                big.push(num);
            } else if (num < pivot) {
                small.push(num);
            } else {
                equal.push(num);
            }
        }


        if (k <= big.length) {
            // 第 k 大的元素在 big 数组中
            return quickSelect(big, k);
        }
        if (nums.length - small.length < k) {
            // 第 k 大的元素在 small 数组中
            return quickSelect(small, k - (nums.length - small.length));
        }
        // 第 k 大的元素在 equal 数组中，就是 pivot
        return pivot;
    }
}

// 快速排序，减治法
// 经过一次partition操作（左边大，右边小），返回的是基准元素的下标
// 如果返回的下标大于 k 说明答案在左边，只需要在左边继续查找 arr[1, index - 1]里面的第 k 个元素
// 如果返回的下标小于 k 说明答案在右边，只需要在右边继续查找 arr[index + 1, n]里面的第 k - index 个元素
var findKthLargest = function (nums, k) {
    // 递归排序
    return quickSort(nums, 0, nums.length - 1, k);

    function quickSort(arr, left, right, k) {
        // 通过 partition 操作，返回基准元素的下标
        let index = partition(arr, left, right);
        // 如果正好是第 k 个元素，直接返回
        if (index === k - 1) {
            return arr[index];
        } else if (index > k - 1) {
            // 如果基准元素的下标大于 k，说明答案在左边
            return quickSort(arr, left, index - 1, k);
        } else if (index < k - 1) {
            // 如果基准元素的下标小于 k，说明答案在右边
            return quickSort(arr, index + 1, right, k);
        }
    }

    function partition(arr, left, right) {
        // 随机选择一个基准元素，可以避免最坏情况，有bug
        // let pivot = arr[left + Math.floor(Math.random() * (right - left + 1))];
        let pivot = arr[left];
        let j = left;
        for (let i = left + 1; i <= right; i++) {
            if (arr[i] > pivot) {
                j++;
                [arr[i], arr[j]] = [arr[j], arr[i]];
            }
        }
        [arr[left], arr[j]] = [arr[j], arr[left]];
        return j;
    }
}


// 堆排序
// 时间复杂度为 O(nlogn)
var findKthLargest = function (nums, k) {
    let heapSize = nums.length;

    // 先构建好一个大根堆
    buildMaxHeap(nums, heapSize);

    for (let i = nums.length - 1; i > nums.length - k; i--) {
        [nums[0], nums[i]] = [nums[i], nums[0]];
        heapSize--;
        maxHeapify(nums, 0, heapSize);
    }
    return nums[0]

    // 自上而下构建一个大根堆
    function buildMaxHeap(nums, heapSize) {
        for (let i = Math.floor(heapSize / 2) - 1; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    // 从左到右，自上而下地调整节点
    function maxHeapify(nums, i, heapSize) {
        let l = i * 2 + 1;
        let r = i * 2 + 2;
        let largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest !== i) {
            [nums[i], nums[largest]] = [nums[largest], nums[i]];
            maxHeapify(nums, largest, heapSize);
        }
    }
}

// 部分冒泡排序
// 由于只需要找到第 k 大的元素，所以只需要进行 k 次排序
// 这样后 k 个元素就是最大的 k 个
// 时间复杂度为 O(nk)，时间超限
var findKthLargest = function (nums, k) {
    let n = nums.length;
    // 只需要进行k次排序
    for (let i = 0; i < k; i++) {
        for (let j = 0; j < n - 1 - i; j++) {
            if (nums[j] > nums[j + 1]) {
                // 交换
                [nums[j], nums[j + 1]] = [nums[j + 1], nums[j]];
            }
        }
    }
    return nums[n - k];
};

