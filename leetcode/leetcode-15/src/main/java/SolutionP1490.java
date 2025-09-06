import java.util.ArrayList;
import java.util.List;

public class SolutionP1490 {
    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }
        Node cloneRoot = new Node(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            Node cloneChild = cloneTree(child);
            cloneRoot.children.add(cloneChild);
        }
        return cloneRoot;
    }

    // UT
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
/*
$1490. 克隆 N 叉树
https://leetcode.cn/problems/clone-n-ary-tree/description/

给定一棵 N 叉树的根节点 root ，返回该树的深拷贝（克隆）。
N 叉树的每个节点都包含一个值（ int ）和子节点的列表（ List[Node] ）。
class Node {
    public int val;
    public List<Node> children;
}
N 叉树的输入序列用层序遍历表示，每组子节点用 null 分隔（见示例）。
提示：
给定的 N 叉树的深度小于或等于 1000。
节点的总个数在 [0, 10^4] 之间
进阶：你的解决方案可以适用于克隆图问题吗？

层序遍历。
 */
