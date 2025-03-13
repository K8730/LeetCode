// 1486. 数组异或操作

/**
 * @param {number} n
 * @param {number} start
 * @return {number}
 */
var xorOperation = function (n, start) {
    let ans = 0;
    for (let i = 0; i < n; i++) {
        ans ^= (start + i * 2);
    }
    return ans;
};


// 数学方法
function xorN(n) {
    // 0 到 n 的异或结果
    switch (n % 4) {
        case 0: return n;
        case 1: return 1;
        case 2: return n + 1;
        case 3: return 0;
        default: return 0;
    }
}

var xorOperation = function (n, start) {
    const a = Math.floor(start / 2);
    const b = n & start & 1;
    return (xorN(a + n - 1) ^ xorN(a - 1)) * 2 + b;
}