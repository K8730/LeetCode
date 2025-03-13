import java.util.*;

public class Leetcode138 {

}

// 随机链表的复制

// 递归 哈希表
class Solution {
    // 记录已经被克隆过的点，键：老节点，值：新节点
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        // 如果该节点已经被克隆过，则直接取出新节点
        if (visited.containsKey(head)) {
            return visited.get(head);
        }

        // 克隆节点
        Node cloneNode = new Node(head.val);
        // 存入哈希表
        visited.put(head, cloneNode);

        cloneNode.next = copyRandomList(head.next);
        cloneNode.random = copyRandomList(head.random);
        return cloneNode;
    }
}

// 迭代 节点拆分
class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 在 A 和 B 之间生成一个 A`
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        // 在 A` 中补充 random 点
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        // 将 A` B` C` 链接起来
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}

class Node {
    public int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}