import java.util.ArrayList;
import java.util.List;

public class Solution2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        int n = arr.size();

        List<List<Integer>> ans = new ArrayList<>();
        for (int q : queries) {
            int j = lowerBound(arr, q);
            int mx = j == n ? -1 : arr.get(j);
            if (j == n || arr.get(j) != q) { // a[j]>q, a[j-1]<q
                j--;
            }
            int mn = j < 0 ? -1 : arr.get(j);
            ans.add(List.of(mn, mx));
        }
        return ans;
    }

    // BST 中序遍历
    private void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }

    private int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
2476. 二叉搜索树最近节点查询
https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/

第 320 场周赛 T2。

给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
返回数组 answer 。
提示：
树中节点的数目在范围 [2, 10^5] 内
1 <= Node.val <= 10^6
n == queries.length
1 <= n <= 10^5
1 <= queries[i] <= 10^6

中序遍历 + 二分查找
时间复杂度 O(qlogn)
 */