public class Leetcode21 {

}

// 合并俩个有序链表
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (true) {

            if (list1 == null) {
                cur.next = list2;
                return res.next;
            }
            if (list2 == null) {
                cur.next = list1;
                return res.next;
            }

            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
    }
}