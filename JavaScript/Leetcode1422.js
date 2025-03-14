// 1422. 分割字符串的最大得分

/**
 * @param {string} s
 * @return {number}
 */
var maxScore = function (s) {
    // 计算字符串中 ‘1’ 的数量
    let score = _.countBy(s)['1'] ?? 0;
    let ans = 0;
    for (let i = 0; i < s.length - 1; i++) {
        score += s[i] === '0' ? 1 : -1;
        ans = Math.max(ans, score);
    }
    return ans;
};