public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // 二维费用背包
        // f[j][k] 表示最多有 m 个 0 和 n 个 1 的最大子集的长度
        int[][] f = new int[m + 1][n + 1];
        for (String s : strs) {
            // 0 的个数，1 的个数
            int cnt0 = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    cnt0++;
                }
            }
            int cnt1 = s.length() - cnt0;

            for (int j = m; j >= cnt0; j--) {
                for (int k = n; k >= cnt1; k--) {
                    f[j][k] = Math.max(f[j][k], f[j - cnt0][k - cnt1] + 1);
                }
            }
        }
        return f[m][n];
    }
}
/*
474. 一和零
https://leetcode.cn/problems/ones-and-zeroes/

给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
提示：
1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] 仅由 '0' 和 '1' 组成
1 <= m, n <= 100

二维费用背包
时间复杂度 O(lmn + L) 其中 l = strs.length, L 为 strs 字符串长度之和
空间复杂度 O(mn)
 */