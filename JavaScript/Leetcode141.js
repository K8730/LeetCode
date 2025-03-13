import { ListNode } from "./ds";

// 环形链表
// 判断链表中是否有环

/**
 * @param {ListNode} head
 * @return {boolean}
 */


// 哈希集
var hasCycle = function (head) {
    if (head === null) return false;

    let set = new Set();
    while (head !== null) {
        if (set.has(head)) {
            return true;
        }
        set.add(head);
        head = head.next;
    }
    return false;
};

// 快慢指针
// 两个指针相遇，说明有环

var hasCycle = function (head) {
    let slow = head;
    let fast = head;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
        if (fast === slow) return true;
    }
    return false;
};