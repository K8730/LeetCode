// 3280. 将日期转换为二进制表示


// 输入： date = "2080-02-29"
// 输出： "100000100000-10-11101"
// 解释：100000100000, 10 和 11101 分别是 2080, 02 和 29 的二进制表示


/**
 * @param {string} date
 * @return {string}
 */
var convertDateToBinary = function (date) {
    // 1. 将日期字符串按照 - 分割成数组
    // 2. 对数组中的每一个字符串进行转换
    // 3. 将转换后的字符串拼接成一个新的字符串
    return date.split('-')
        .map(s => parseInt(s)
            .toString(2)).join('-');
};