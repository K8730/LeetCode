// 326. 3 的幂

/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfThree = function (n) {
    if (n <= 0) {
        return false;
    }

    // 把它除到不能除 3
    while (n % 3 === 0) {
        n /= 3;
    }
    return n === 1;
};