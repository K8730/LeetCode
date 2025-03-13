import java.util.*;

public class Leetcode141 {

}

// 环形链表

// 哈希表
// 遍历所有节点，加入哈希表，判断有没有重复出现
class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            // 如果 head 已经存在，add(head) 返回 false，加入失败
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

// 快慢指针
// 如果存在圈，慢指针就会被快指针套圈
class Solution2 {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        // 注意： 追上的点并不是 入环的第一个节点！
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}