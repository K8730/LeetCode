import java.util.*;

public class Leetcode194 {

}

// 字符串解码

// 递归

// 要么是 String -> Digits [ String ] String
// 要么是 String -> Char String
// 为 LL(1)文法，即
// 从左向右分析(Left-to-right-parse)
// 最左推导(Leftmost-derivation)
// 超前查看一个符号(1-symbollookahead)
class Solution {
    public String src;
    public int ptr;

    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }
        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // 解析 digit
            repTime = getDigits();

            // 过滤左括号
            if (src.charAt(ptr) == '[') {
                ptr++;
            }

            // 解析 String, 递归实现
            String str = getString();

            // 过滤右括号
            if (src.charAt(ptr) == ']') {
                ptr++;
            }

            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // 如果是普通字符, 直接加到字符串上
            ret = String.valueOf(src.charAt(ptr));
            ptr++;
        }
        return ret + getString();
    }

    // 探测到是数字，然后while循环取出整个数字
    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';// 数字大小 = 数字字符 - ‘0’
        }
        // 结束的时候 ptr 指向的元素为 数字元素的下一个('[')
        return ret;
    }
}

// 栈
class Solution2 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        // 储存乘数
        LinkedList<Integer> stack_multi = new LinkedList<>();
        // 储存字符
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++)
                    tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9')
                multi = multi * 10 + Integer.parseInt(c + "");
            else
                res.append(c);
        }
        return res.toString();
    }
}