public class Leetcode160 {

}

// 相交链表

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            // pa 走到头就从headB开始走
            // pb 走到头就从headA开始走
            // 两个
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        // pa 走了 a 的分叉，再走 b 的分叉，到达路口
        // pb 走了 b 的分叉，再走 a 的分叉，到达路口
        // 所用时间是一样的，所以会同时到达路口
        return pa;
    }
}