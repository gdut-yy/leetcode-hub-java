import java.util.HashSet;
import java.util.Set;

public class SolutionLCP44 {
    public int numColor(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        preorder(root, set);
        return set.size();
    }

    private void preorder(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        preorder(root.left, set);
        preorder(root.right, set);
    }
}
/*
LCP 44. 开幕式焰火
https://leetcode-cn.com/problems/sZ59z6/

前序遍历。
 */