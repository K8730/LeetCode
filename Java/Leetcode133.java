import java.util.*;

public class Leetcode133 {

}

// 克隆图

// 先克隆 点，再克隆 边
class Solution {
    // 记录已经被克隆过的点，键：老节点，值：新节点
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // 如果该节点已经被克隆过，则直接取出新节点
        // 即从 B 到 A 回来了
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // 存入哈希表
        visited.put(node, cloneNode);

        // 遍历当前节点的邻居，克隆每个邻居，加入当前节点的邻居列表
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;

    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}