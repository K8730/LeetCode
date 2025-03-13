/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */


// 字符串相加
var addStrings = function (num1, num2) {
  let i = num1.length - 1;
  let j = num2.length - 1;
  let add = 0;
  const ans = [];
  while (i >= 0 || j >= 0 || add != 0) {
    // 取最后一个数
    const x = (i >= 0) ? num1.charAt(i) - '0' : 0;
    const y = (j >= 0) ? num2.charAt(j) - '0' : 0;
    const result = x + y + add;
    ans.push(result % 10);
    add = Math.floor(result / 10);
    i--;
    j--;
  }
  return ans.reverse().join('');
};