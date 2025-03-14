// 231. 2 的幂

/**
 * @param {number} n
 * @return {boolean}
 */

// 位运算
var isPowerOfTwo = function(n) {
    if (n <= 0) {
        return false;
    }
    // n & (n-1) 移除最低位的 1
    // n & ( -n) 获取最低位的 1
    return (n & (n-1)) === 0;
};

// 判断是不是最大幂的约数
var isPowerOfTwo = function(n) {
    // 32位有符号整数中，最大的 2的幂 = 2^30
    if(n <= 0){
        return false;
    }
    const BIG = 1 << 30;
    return BIG % n === 0;
};