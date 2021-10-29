import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1038 {
    public TreeNode bstToGst(TreeNode root) {
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
1038. 把二叉搜索树转换为累加树
https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/

同: 538. 把二叉搜索树转换为累加树
https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */