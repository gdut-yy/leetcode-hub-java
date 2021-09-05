import java.util.ArrayList;
import java.util.List;

public class Solution897 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> orderList = new ArrayList<>();
        inorder(root, orderList);

        TreeNode cur = new TreeNode(-1);
        TreeNode dummy = cur;
        for (int order : orderList) {
            cur.right = new TreeNode(order);
            cur = cur.right;
        }
        return dummy.right;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        // 中序遍历
        list.add(root.val);
        inorder(root.right, list);
    }
}
/*
897. 递增顺序搜索树
https://leetcode-cn.com/problems/increasing-order-search-tree/

第 100 场周赛 T2。
中序遍历。
 */