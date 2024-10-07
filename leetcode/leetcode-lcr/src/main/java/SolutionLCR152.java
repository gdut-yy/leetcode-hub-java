import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionLCR152 {
    public boolean verifyTreeOrder(int[] postorder) {
        Deque<Integer> st = new ArrayDeque<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!st.isEmpty() && st.peek() > postorder[i]) {
                root = st.pop();
            }
            st.push(postorder[i]);
        }
        return true;
    }
}
/*
LCR 152. 验证二叉搜索树的后序遍历序列
https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
参考以下这颗二叉搜索树：
     5
    / \
   2   6
  / \
 1   3
输入: [1,6,3,2,5]
输出: false

二叉搜索树，左子树的所有节点都小于根节点，右子树的所有节点都大于根节点
单调栈。
时间复杂度 O(n)
空间复杂度 O(n)
 */