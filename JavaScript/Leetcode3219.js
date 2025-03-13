// 3219. 切蛋糕的最小总开销 II

// 给你整数 m ，n 和两个数组：

// horizontalCut 的大小为 m - 1 ，其中 horizontalCut[i] 表示沿着水平线 i 切蛋糕的开销。
// verticalCut 的大小为 n - 1 ，其中 verticalCut[j] 表示沿着垂直线 j 切蛋糕的开销。
// 一次操作中，你可以选择任意不是 1 x 1 大小的矩形蛋糕并执行以下操作之一：

// 沿着水平线 i 切开蛋糕，开销为 horizontalCut[i] 。
// 沿着垂直线 j 切开蛋糕，开销为 verticalCut[j] 。
// 每次操作后，这块蛋糕都被切成两个独立的小蛋糕。
// 每次操作的开销都为最开始对应切割线的开销，并且不会改变。
// 请你返回将蛋糕全部切成 1 x 1 的蛋糕块的 最小 总开销。


/**
 * @param {number} m
 * @param {number} n
 * @param {number[]} horizontalCut
 * @param {number[]} verticalCut
 * @return {number}
 */
var minimumCost = function (m, n, horizontalCut, verticalCut) {

    let horCut = horizontalCut.sort((a, b) => a - b);
    let verCut = verticalCut.sort((a, b) => a - b);

    let h = 1, v = 1;
    let res = 0;
    while (horCut.length || verCut.length) {
        if (!verCut.length || (horCut.length && horCut[horCut.length - 1] > verCut[verCut.length - 1])) {
            res += horCut[horCut.length - 1] * h;
            horCut.pop();
            v++;
        } else {
            res += verCut[verCut.length - 1] * v;
            verCut.pop();
            h++;
        }
    }
    return res;
};