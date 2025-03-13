/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

// 判断子序列

// 两个指针往后遍历
var isSubsequence = function (s, t) {
    const n = s.length, m = t.length;
    let i = 0, j = 0;

    while (i < n && j < m) {
        if (s.charAt(i) === t.charAt(j)) {
            i++;
        }
        j++;
    }

    return i === n;
};