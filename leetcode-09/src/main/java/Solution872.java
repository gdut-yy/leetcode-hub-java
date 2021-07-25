import java.util.ArrayList;
import java.util.List;

public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> leafList1 = new ArrayList<>();
        List<Integer> leafList2 = new ArrayList<>();
        traverse(root1, leafList1);
        traverse(root2, leafList2);
        return leafList1.equals(leafList2);
    }

    private void traverse(TreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafList.add(root.val);
        } else {
            traverse(root.left, leafList);
            traverse(root.right, leafList);
        }
    }
}
/*
872. 叶子相似的树
https://leetcode-cn.com/problems/leaf-similar-trees/

第 94 场周赛 T1。
求出两棵树的叶值序列，然后进行比较即可。
 */