import java.util.ArrayDeque;
import java.util.Deque;

public class Solution173 {
    static class BSTIterator {
        private TreeNode cur;
        private final Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new ArrayDeque<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
/*
173. 二叉搜索树迭代器
https://leetcode-cn.com/problems/binary-search-tree-iterator/

中序遍历
因为 栈 stack 空间复杂度 空间复杂度 O(h) 所以：

next() 时间复杂度 O(1) 空间复杂度 O(h)
hasNext() 时间复杂度 O(1) 空间复杂度 O(h)
 */