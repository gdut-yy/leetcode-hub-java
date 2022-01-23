import java.util.HashMap;
import java.util.Map;

public class Solution873 {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            hashMap.put(arr[i], i);
        }

        int[][] dp = new int[len][len];
        int res = 2;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int k = hashMap.getOrDefault(arr[i] - arr[j], -1);
                dp[i][j] = (k >= 0 && k < j) ? dp[j][k] + 1 : 2;
                res = Math.max(res, dp[i][j]);
            }
        }
        // 斐波那契序列长度最少为 3
        return (res > 2) ? res : 0;
    }
}
/*
873. 最长的斐波那契子序列的长度
https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/

第 94 场周赛 T4。

如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是斐波那契式的：
- n >= 3
- 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
给定一个严格递增的正整数数组形成序列 arr，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。
（回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。
例如，[3, 5, 8]是[3, 4, 5, 6, 7, 8]的一个子序列）

动态规划。
时间复杂度 O(n^2)
空间复杂度 O(n^2)
 */