// 字符串及其反转中是否存在同一子字符串
// 输入：s = "leetcode"
// 输出：true
// 解释：子字符串 "ee" 的长度为 2，它也出现在 reverse(s) == "edocteel" 中。

/**
 * @param {string} s
 * @return {boolean}
 */

// x+y 在反转串 reverse(s) 中，等价于 y+x 在 s 中
// 对每一个 x+y 对，检查是否存在 y+x
// 遍历到了就保存下来，增加一次遍历得到的信息
// 时间复杂度 O(n)，因为只需要遍历一次字符串 s
var isSubstringPresent = function (s) {
    // 创建一个 26 * 26 的二维数组 
    let vis = Array.from({ length: 26 }, () => Array(26).fill(false));
    for (let i = 1; i < s.length; i++) {
        let x = s.charCodeAt(i - 1) - 'a'.charCodeAt(0);
        let y = s.charCodeAt(i) - 'a'.charCodeAt(0);
        vis[x][y] = true;
        if (vis[y][x]) {
            return true;
        }
    }
    return false;
};