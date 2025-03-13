public class Leetcode25 {
}

// K 个一组翻转链表

// 画图，需要思路清晰

// 将内部每一条边反转
// 改变前面的指针
// 改变后面的指针
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        // 创建虚节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 每一组的前缀节点
        ListNode preGroup = dummy;

        while (true) {
            // 每一组的开始节点
            ListNode start = preGroup.next;

            // 获取每一组的结束节点
            ListNode end = start;
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            // 如果不足k个节点，则停止
            if (end == null)
                break;

            // 记录下一组的开始节点
            ListNode nextStart = end.next;
            // 断裂与下一组的连接
            end.next = null;

            // 反转当前组
            ListNode currGroup = reverse(start);

            // 将当前组与前缀节点连接
            preGroup.next = currGroup;
            // 连接下一组，start已经变为end
            start.next = nextStart;
            // 更新下一组的前缀节点
            preGroup = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}