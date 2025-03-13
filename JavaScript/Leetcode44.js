// 通配符匹配
// 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
// '?' 可以匹配任何单个字符。
// '*' 可以匹配任意字符序列（包括空字符序列）。



/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */


// dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
// 通过状态转移方程来更新 dp 数组
var isMatch = function (s, p) {
    let m = s.length;
    let n = p.length;
    // dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
    let dp = Array.from(Array(m + 1), () => Array(n + 1).fill(false));
    dp[0][0] = true; // 表示空字符串和空字符串是匹配的


    // 处理边界情况（p的前缀是 * 的情况）
    for (let i = 1; i <= n; i++) {
        if (p[i - 1] == '*') {
            dp[0][i] = true;
        } else {
            break;
        }
    }

    // 填充 dp 数组
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (p[j - 1] == '*') {
                // 如果 p[j] 是通配符 *，则 dp[i][j] 的值由 dp[i-1][j] 或 dp[i][j-1] 决定
                // 即  把*当作空字符 或者 使用*匹配掉s[i]
                dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            } else if (p[j - 1] == '?' || s[i - 1] == p[j - 1]) {
                // 如果 p[j] 是通配符 ?，或者 s[i] 和 p[j] 对应位置的字符相同
                dp[i][j] = dp[i - 1][j - 1];
            }
        }
    }
    return dp[m][n];
};

var isMatch = function (s, p) {
    // 在s和p的前面加上一个空格，这样可以避免处理边界情况
    s = ' ' + s;
    p = ' ' + p;
    let m = s.length;
    let n = p.length;
    let dp = Array.from(Array(m), () => Array(n).fill(false));
    dp[0][0] = true;

    // 填充 dp 数组
    // dp[0][j] 可能是true，因为p的前缀是*的情况
    // dp[i][0] 一定是false，因为p为空字符串，s不为空字符串，不可能匹配 
    for (let i = 0; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (p[j] == '*') {
                // 如果 p[j] 是通配符 *，则 dp[i][j] 的值由 dp[i-1][j] 或 dp[i][j-1] 决定
                // 即 把*当作空字符 或者 使用*匹配掉s[i]
                dp[i][j] = dp[i][j - 1] || (i != 0 && dp[i - 1][j]);
            } else if (p[j] == '?' || s[i] == p[j]) {
                // 如果 p[j] 是通配符 ?，或者 s[i] 和 p[j] 对应位置的字符相同
                dp[i][j] = (i != 0 && dp[i - 1][j - 1]);
            }
        }
    }
    return dp[m - 1][n - 1];
}


// 别人的写法
/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function (s, p) {
    let starIdx = -1; // 记录最后一个 '*' 的位置
    let pIdx = 0; // 模式字符串 p 的当前索引
    let sIdx = 0; // 字符串 s 的当前索引
    let matchIdx = 0; // 记录匹配到 '*' 时，字符串 s 的索引

    while (sIdx < s.length) {
        if (pIdx < p.length && (s.charAt(sIdx) === p.charAt(pIdx) || p.charAt(pIdx) === "?")) {
            // 当前字符匹配（字符相同或模式字符为 '?'）
            pIdx++;
            sIdx++;
        } else if (pIdx < p.length && p.charAt(pIdx) === "*") {
            // 模式字符为 '*'，记录 '*' 的位置和当前 s 的索引
            starIdx = pIdx;
            matchIdx = sIdx;
            pIdx++;
        } else if (starIdx !== -1) {
            // 如果之前遇到过 '*'，回溯到 '*' 之后的位置，尝试匹配更多字符
            pIdx = starIdx + 1;
            matchIdx++;
            sIdx = matchIdx;
        } else {
            // 不匹配且没有 '*'，返回 false
            return false;
        }
    }

    // 检查模式字符串 p 剩余的字符是否都是 '*'
    while (pIdx < p.length && p[pIdx] === '*') {
        pIdx++;
    }

    // 如果 pIdx 达到 p 的长度，说明匹配成功
    return pIdx === p.length;
};