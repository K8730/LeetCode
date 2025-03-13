class Solution {
  public int maxVowels(String S, int k) {
    // 1. 将 String 转为 Array
    char[] s = S.toCharArray();
    int ans = 0;
    int vowel = 0; // 统计窗口中元音个数

    // 2. 进入窗口
    for (int i = 0; i < s.length; i++) {
      if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
        vowel++;
      }
      if (i < k - 1) { // 窗口大小不足 k
        continue;
      }
      // 2. 更新答案, 更新答案时, 窗口中恰好有 k 个元素
      ans = Math.max(ans, vowel);

      // 3. 退出窗口
      char out = s[i - k + 1]; // 即将退出窗口的元素
      if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
        vowel--;
      }

    }
    return ans;
  }
}