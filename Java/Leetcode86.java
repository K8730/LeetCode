
public class Leetcode86 {

}
// 分隔链表

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode dummy2 = new ListNode(0);
        ListNode cur2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                cur.next = head;
                cur = cur.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur.next = dummy2.next;
        return dummy.next;
    }
}

class Solution2 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        // 防止出现环
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
