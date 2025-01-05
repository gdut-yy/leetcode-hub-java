import java.util.ArrayList;
import java.util.List;

public class Solution1382 {
    private List<Integer> inorderList;

    public TreeNode balanceBST(TreeNode root) {
        inorderList = new ArrayList<>();
        inorder(root);
        return build(0, inorderList.size() - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        inorderList.add(node.val);
        inorder(node.right);
    }

    private TreeNode build(int l, int r) {
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(inorderList.get(mid));
        if (l <= mid - 1) node.left = build(l, mid - 1);
        if (mid + 1 <= r) node.right = build(mid + 1, r);
        return node;
    }
}
/*
1382. 将二叉搜索树变平衡
https://leetcode.cn/problems/balance-a-binary-search-tree/description/

给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
提示：
树节点的数目在 [1, 10^4] 范围内。
1 <= Node.val <= 10^5

贪心策略的雏形就形成了：我们可以通过中序遍历将原来的二叉搜索树转化为一个有序序列，然后对这个有序序列递归建树，对于区间 [L,R]：
取 mid=(L+R)/2，即中心位置作为当前节点的值；
如果 L≤mid−1，那么递归地将区间 [L,mid−1] 作为当前节点的左子树；
如果 mid+1≤R，那么递归地将区间 [mid+1,R] 作为当前节点的右子树。
 */