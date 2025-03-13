// 正则表达式匹配
// 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素




/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function (s, p) {
    s = ' ' + s;
    p = ' ' + p;
    let m = s.length;
    let n = p.length;
    let dp = Array.from(Array(m), () => Array(n).fill(false));
    dp[0][0] = true;
    for (let i = 0; i < m; i++) {
        for (let j = 1; j < n; j++) {
            // 如果当前是带*的，可以考虑直接丢弃
            if (p[j + 1] === '*') {
                dp[i][j + 1] = dp[i][j - 1];
            }
            if (p[j] === '*') {
                dp[i][j] = (p[j - 1] === '.' || s[i] === p[j - 1]) && dp[i - 1][j];
            } else if (p[j] === '.' || p[j] === s[i]) {
                dp[i][j] = (i != 0 && dp[i - 1][j - 1]);
            }
            // if (p[j + 1] === '*') {
            //     if (i === 0) {
            //         dp[i][j + 1] == true;
            //     } else {
            //         dp[i][j] = dp[i - 1][j - 1] && (p[j - 1] === '.' || (p[j - 1] === s[i])) || (dp[i][j - 1]);
            //     }

            // } else if (p[j] === '.' || p[j] === s[i]) {
            //     dp[i][j] = (i != 0 && dp[i - 1][j - 1]);
            // }
        }
    }
    return dp[m - 1][n - 1];
};

var isMatch = function (s, p) {
    let m = s.length;
    let n = p.length;

    let f = Array.from({ length: m + 1 }, () => Array(n + 1).fill(false));

}