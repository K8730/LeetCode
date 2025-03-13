public class Leetcode7 {

}

// 整数反转
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            // 超上界
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)
                return 0;
            // 超下界
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && temp < Integer.MIN_VALUE % 10)
                return 0;
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }
}