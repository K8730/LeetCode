import { ListNode } from "./ds.js"

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
  let pre = null, cur = head;
  while (cur) {
    nxt = cur.next  // 记录下一个位置，防止丢失
    cur.next = pre; // 改变箭头

    // 向前移动
    pre = cur;
    cur = nxt;
  }
  return pre;
};

