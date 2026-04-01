public class Solution3863 {
    public int minOperations(String S) {
        char[] s = S.toCharArray();
        int n = s.length;

        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (s[i - 1] > s[i]) {
                isSorted = false;
                break;
            }
        }
        // s 已经是升序
        if (isSorted) return 0;
        // 长为 2，无法排序
        if (n == 2) return -1;

        char mn = s[0];
        char mx = s[0];
        for (char ch : s) {
            mn = (char) Math.min(mn, ch);
            mx = (char) Math.max(mx, ch);
        }

        // 如果 s[0] 是最小值，排序 [1,n-1] 即可
        // 如果 s[n-1] 是最大值，排序 [0,n-2] 即可
        if (s[0] == mn || s[n - 1] == mx) {
            return 1;
        }

        // 如果 [1,n-2] 中有最小值，那么先排序 [0,n-2]，把最小值排在最前面，然后排序 [1,n-1] 即可
        // 如果 [1,n-2] 中有最大值，那么先排序 [1,n-1]，把最大值排在最后面，然后排序 [0,n-2] 即可
        for (int i = 1; i < n - 1; i++) {
            if (s[i] == mn || s[i] == mx) {
                return 2;
            }
        }

        // 现在只剩下一种情况：s[0] 是最大值，s[n-1] 是最小值，且 [1,n-2] 不含最小值和最大值
        // 先排序 [0,n-2]，把最大值排到 n-2
        // 然后排序 [1,n-1]，把最大值排在最后面，且最小值排在 1
        // 最后排序 [0,n-2]，把最小值排在最前面
        return 3;
    }
}
/*
3863. 将一个字符串排序的最小操作次数
https://leetcode.cn/problems/minimum-operations-to-sort-a-string/description/

第 492 场周赛 T3。

给你一个由小写英文字母组成的字符串 s。
在一次操作中，你可以选择 s 的任意 子字符串（但 不能 是整个字符串），并将其按 非降序字母顺序 进行 排序。
返回使 s 按 非降序 排列所需的 最小 操作次数。如果无法做到，则返回 -1。
提示：
1 <= s.length <= 10^5
s 仅由小写英文字母组成。

分类讨论。
时间复杂度 O(n)。
 */