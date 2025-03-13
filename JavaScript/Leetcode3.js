/**
 * @param {string} s
 * @return {number}
 */


// 无重复字符的最长子串

// 滑动窗口
var lengthOfLongestSubstring = function (s) {
  let ans = 0;
  let left = 0;
  const window = new Set();
  for (let right = 0; right < s.length; right++) {
    const c = s[right];
    // 如果窗口内有 c，需要在加入 c 之前，一直移除，直到移除掉原有的 c
    while (window.has(c)) {
      window.delete(s[left]);
      left++;
    }
    window.add(c);
    ans = Math.max(ans, right - left + 1);
  }
  return ans;
};