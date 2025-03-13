/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var maxVowels = function (s, k) {
  let ans = 0
  let vowel = 0
  for (let i = 0; i < s.length; i++) {
    if (s[i] === 'a' || s[i] === 'e' || s[i] === 'i' || s[i] === 'o' || s[i] === 'u') {
      vowel++;
    }
    if (i < k - 1) {
      continue;
    }

    ans = Math.max(ans, vowel)

    let out = s[i - k + 1]
    if (out === 'a' || out === 'e' || out === 'i' || out === 'o' || out === 'u') {
      vowel--;
    }
  }
  return ans;
};