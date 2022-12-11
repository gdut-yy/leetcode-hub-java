public class SolutionLCP26 {
    // https://leetcode.cn/problems/hSRGyL/solution/tan-xin-suan-fa-zheng-ming-by-newhar/
    private int res = 0;
    private int s = 1;

    public int navigation(TreeNode root) {
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        return res + ((l && r) ? 0 : s);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (root.left != null && root.right != null) {
            res += !l && !r ? 1 : 0;
            s = !(l && r) ? 1 : 0;
            return true;
        }
        return l || r;
    }
//    int res = 0, s = 1;
//    int dfs(TreeNode* root) {
//        if(!root) {
//            return 0;
//        }
//        int l = dfs(root->left), r = dfs(root->right);
//        if(root->left && root->right) {
//            res += !l && !r;
//            s = !(l && r);
//            return 1;
//        }
//        return l || r;
//    }
//    int navigation(TreeNode* root) {
//        int l = dfs(root->left), r = dfs(root->right);
//        return res + ((l && r)? 0 : s);
//    }
}
/*
LCP 26. 导航装置
https://leetcode.cn/problems/hSRGyL/

小扣参加的秋日市集景区共有 NN 个景点，景点编号为 1~N。景点内设有 N−1 条双向道路，使所有景点形成了一个二叉树结构，根结点记为 root，景点编号即为节点值。
由于秋日市集景区的结构特殊，游客很容易迷路，主办方决定在景区的若干个景点设置导航装置，按照所在景点编号升序排列后定义装置编号为 1 ~ M。
导航装置向游客发送数据，数据内容为列表 [游客与装置 1 的相对距离,游客与装置 2 的相对距离,...,游客与装置 M 的相对距离]。
由于游客根据导航装置发送的信息来确认位置，因此主办方需保证游客在每个景点接收的数据信息皆不相同。请返回主办方最少需要设置多少个导航装置。
提示：
2 <= N <= 50000
二叉树的非空节点值为 1~N 的一个排列。
 */