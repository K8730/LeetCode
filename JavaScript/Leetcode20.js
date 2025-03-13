/**
 * @param {string} s
 * @return {boolean}
 */

var isValid = function (s) {
  if (s.length % 2) {
    return false;
  }

  const mp = { ')': '(', ']': '[', '}': '{' };
  const stack = [];
  for (const c of s) {
    if (!mp.hasOwnProperty(c)) {
      // 是左括号的话
      stack.push(c); // 入栈
    } else if (stack.length === 0 || stack.pop() != mp[c]) { //是右括号的话
      // 如果没有左括号，或者左括号类型不对
      return false;
    }
  }
  return stack.length === 0;
};