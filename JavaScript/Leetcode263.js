// 263. 丑数

/**
 * @param {number} n
 * @return {boolean}
 */
var isUgly = function (n) {
    if (n <= 0) {
        return false;
    }
    // 将 n 分解成 2 3 5
    // 分解到最后是 1，那么就是丑数
    while (n % 2 === 0 || n % 3 === 0 || n % 5 === 0) {
        if (n % 2 === 0) {
            n /= 2;
        }
        if (n % 3 === 0) {
            n /= 3;
        }
        if (n % 5 === 0) {
            n /= 5;
        }
    }
    return n === 1;
};


var isUgly = function (n) {
    if (n <= 0) {
        return false;
    }
    while (n % 2 === 0) {
        n /= 2;
    }
    while (n % 3 === 0) {
        n /= 3;
    }
    while (n % 5 === 0) {
        n /= 5;
    }
    return n === 1;
};
