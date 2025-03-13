public class Leetcode2 {

}

// 两数相加

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        // 只要有一个存在就继续计算
        while (l1 != null || l2 != null || carry != 0) {
            // 是 null 没关系，把它看成 0
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;

            int sum = a + b + carry;
            carry = (sum >= 10) ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            // 是 null 没关系，不要 next 就可以
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;
    }
}