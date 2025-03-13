// 1366. 通过投票对团队排名
// 输入：votes = ["ABC","ACB","ABC","ACB","ACB"]
// 输出："ACB"


/**
 * @param {string[]} votes
 * @return {string}
 */
var rankTeams = function (votes) {
    const m = votes[0].length;
    // 把每个字母在每个位置上的得票数记录下来
    // {
    //     'A': [5,0,0],
    //     'B': [0,2,3],
    //     'C': [0,3,2],
    // }
    const cnts = {};
    for (const ch of votes[0]) {
        cnts[ch] = Array(m).fill(0);
    }
    for (const vote of votes) {
        for (let i = 0; i < m; i++) {
            cnts[vote[i]][i]++; // 记录每个字母在每个位置上的得票数
        }
    }

    const ans = votes[0].split('');
    ans.sort((a, b) => {
        for (let i = 0; i < m; i++) {
            if (cnts[a][i] != cnts[b][i]) {
                return cnts[b][i] - cnts[a][i]; // 谁大谁在前
            }
        }
        // 如果每一位次得票数相同，按字母顺序排序
        // localeCompare() 方法返回两个字符串的比较结果
        return a.localeCompare(b);
    })
    return ans.join('');
};