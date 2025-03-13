public class Leetcode142 {

}

// 环形链表 II
// 快慢指针
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 此处如果用 while (fast != slow)，则在一开始时就违背了条件
        // 也可用 do while, 但以下代码更符合 repeat until (重复直到) 的思考习惯
        while (true) {
            // 指向空节点，说明无环。
            if (fast == null || fast.next == null)
                return null;

            // fast 和 slow 异速前进
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break; // fast 和 slow 相遇
        }

        // ptr 和 slow 同速前进，直至相遇在入口
        ListNode ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }

        return ptr; // 返回入口节点
    }
}