import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        st.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < st.peek().val) { // 小于栈顶元素的值，说明应该在栈顶元素的左子树
                st.peek().left = node;
            } else { // 大于栈顶元素的值，我们要找到当前元素的父节点
                TreeNode parent = st.peek();
                // 栈从栈底到栈顶是递减的
                while (!st.isEmpty() && preorder[i] > st.peek().val) {
                    parent = st.pop();
                }
                parent.right = node;
            }
            // 节点压栈
            st.push(node);
        }
        return root;
    }
}
/*
1008. 前序遍历构造二叉搜索树
https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/description/

给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大于 Node.val。
二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
提示：
1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
preorder 中的值 互不相同

单调栈 https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/solutions/301677/javadai-ma-de-5chong-jie-ti-si-lu-by-sdwwld/
时间复杂度 O(n)
 */