// 709. 转换成小写字母

/**
 * @param {string} s
 * @return {string}
 */
var toLowerCase = function(s) {
    return s.toLowerCase();
};

// ASCII码实现

// 大写字母 A - Z 的 ASCII 码范围为 [65,90]
// 小写字母 a - z 的 ASCII 码范围为 [97,122]
// 差值为32
/**
 * @param {string} s
 * @return {string}
 */
var toLowerCase = function(s) {
    const sb = [];
    for(let ch of s){
        if (ch.charCodeAt() >= 65 && ch.charCodeAt() <= 90){
            ch = String.fromCharCode(ch.charCodeAt() | 32);
        }
        sb.push(ch);
    }
};