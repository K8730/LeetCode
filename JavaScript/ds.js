export function ListNode(val) {
  this.val = val;
  this.next = null;
}

export function TreeNode(val, left, right) {
  this.val = (val === undefined ? 0 : val);
  this.left = (left === undefined ? null : left);
  this.right = (right === undefined ? null : right);
}
// 默认导出，不使用 {} 导入