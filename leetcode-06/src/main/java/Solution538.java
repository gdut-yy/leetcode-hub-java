import java.util.ArrayDeque;
import java.util.Deque;

public class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
/*
538. 把二叉搜索树转换为累加树
https://leetcode.cn/problems/convert-bst-to-greater-tree/

中序遍历变形。
同: 1038. 把二叉搜索树转换为累加树
https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/
 */