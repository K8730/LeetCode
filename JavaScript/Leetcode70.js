/**
 * @param {number} n
 * @return {number}
 */

// 爬楼梯
// 有多少种不同的方法可以爬到楼顶

// f(x)=f(x−1)+f(x−2)

// 递归-时间超限
var climbStairs = function (n) {
    if (n == 1) return 1
    if (n == 2) return 2
    return climbStairs(n - 1) + climbStairs(n - 2)
};

// 一个一个算 p+q算法^_^
var climbStairs = function (n) {
    let p = 0;
    let q = 0;
    let r = 1;

    for (let i = 1; i <= n; i++) {
        p = q;
        q = r;
        r = p + q;
    }
    return r;
};