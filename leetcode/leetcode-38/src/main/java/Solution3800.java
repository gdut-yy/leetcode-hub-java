public class Solution3800 {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        int n = s.length();
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sc == '0' && tc == '1') {
                a++;
            } else if (sc == '1' && tc == '0') {
                b++;
            }
        }
        if (a == 0 && b == 0) {
            return 0;
        }
        if ((long) swapCost >= 2L * flipCost) {
            return (long) (a + b) * flipCost;
        }
        long ans = Long.MAX_VALUE;
        for (int k = -b; k <= a; k++) {
            long cost = (long) Math.abs(k) * crossCost
                    + (long) Math.min(a - k, b + k) * swapCost
                    + (long) Math.abs(a - b - 2 * k) * flipCost;
            if (cost < ans) {
                ans = cost;
            }
        }
        return ans;
    }
}
/*
3800. 使二进制字符串相等的最小成本
https://leetcode.cn/problems/minimum-cost-to-make-two-binary-strings-equal/description/

第 483 场周赛 T3。

给你两个长度为 n 的二进制字符串 s 和 t，以及三个 正整数 flipCost、swapCost 和 crossCost。
你可以对字符串 s 和 t 应用以下操作任意次（顺序不限）：
- 选择任意下标 i，翻转 s[i] 或 t[i]（将 '0' 变为 '1' 或将 '1' 变为 '0'）。此操作的成本为 flipCost。
- 选择两个 不同 下标 i 和 j，交换 s[i] 和 s[j] 或 t[i] 和 t[j]。此操作的成本为 swapCost。
- 选择一个下标 i，交换 s[i] 和 t[i]。此操作的成本为 crossCost。
返回使字符串 s 和 t 相等所需的 最小总成本。
提示：
n == s.length == t.length
1 <= n <= 10^5
1 <= flipCost, swapCost, crossCost <= 109
s 和 t 仅由字符 '0' 和 '1' 组成。

分类讨论
时间复杂度 O(n)。
 */