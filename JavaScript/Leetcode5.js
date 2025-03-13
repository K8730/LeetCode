/**
 * @param {string} s
 * @return {string}
 */


// 最长回文子串

// 递推公式
// P(i, j) 表示 第i个 到 第j个字母组成的串 是否为回文串
// P(i, j) = P(i + 1, j - 1) ^ (s[i] === s[j])
// var longestPalindrome = function (s) {


// };

// 中心扩散法
// 向左扩散
// 向右扩散
// 左右扩散
var longestPalindrome = function (s) {
    // 边界情况 
    if (s === null || s.length < 2) {
        return s;
    }

    const strLen = s.length;
    let maxStart = 0; // 最长回文串的起点
    let maxEnd = 0;  // 最长回文串的终点
    let maxLen = 1; // 最长回文串的长度

    const dp = Array.from(Array(strLen), () => Array(strLen).fill(false));

    for (let r = 1; r < strLen; r++) {
        for (let l = 0; l < r; l++) {
            if (s.charAt(l) === s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                dp[l][r] = true;
                if (r - l + 1 > maxLen) {
                    maxLen = r - 1 + 1;
                    maxStart = 1;
                    maxEnd = r;
                }
            }
        }
    }
    return s.substring(maxStart, maxEnd + 1);
};
