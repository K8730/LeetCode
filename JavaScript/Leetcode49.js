/**
 * @param {string[]} strs
 * @return {string[][]}
 */


// 字母异位词分组
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

// 字母出现次数一样 === 异位词
var groupAnagrams = function (strs) {
    // 键：一个count数组，描述了26个字母出现的次数
    // 值：一个数组，包含一种字母解构的所有单词
    const map = new Map();
    for (let str of strs) {
        // 0~25分别对应26个字母，没出现的置为零
        // [0, ...  0, 0]
        const count = new Array(26).fill(0);
        for (let c of str) {
            // 统计每个字母出现的次数
            count[c.charCodeAt() - 'a'.charCodeAt()]++;
        }
        if (map[count]) {
            // 如果里面已经有单词了，就 push 添加单词
            map[count].push(str);
        } else {
            // 如果里面没有，就初始化一个数组
            map[count] = [str];
        }
    }
    // 返回 map 对象中所有值，以数组的形式
    return Object.values(map);
};