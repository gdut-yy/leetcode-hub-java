import java.util.ArrayList;
import java.util.List;

public class Solution3955 {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();
        backtrack(n, k, 0, 0, false, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(int n, int k, int index, int cost, boolean prevIsOne,
                           StringBuilder sb, List<String> ans) {
        if (index == n) {
            ans.add(sb.toString());
            return;
        }
        sb.append('0');
        backtrack(n, k, index + 1, cost, false, sb, ans);
        sb.setLength(sb.length() - 1);
        if (!prevIsOne && cost + index <= k) {
            sb.append('1');
            backtrack(n, k, index + 1, cost + index, true, sb, ans);
            sb.setLength(sb.length() - 1);
        }
    }
}
/*
3955. 成本限制的有效二进制字符串
https://leetcode.cn/problems/valid-binary-strings-with-cost-limit/description/

第 505 场周赛 T2。

给你两个整数 n 和 k。
二进制字符串 s 的 成本 定义为所有满足 s[i] == '1' 的下标 i（从 0 开始）的总和。
如果一个二进制字符串满足以下条件，则认为它是 有效 的：
- 不包含两个连续的 '1' 字符。
- 它的 成本 小于等于 k。
返回所有长度为 n 的有效二进制字符串列表，顺序不限。
提示：
1 <= n <= 12
0 <= k <= n * (n - 1) / 2

回溯。
时间复杂度 O(n * 2^n)。
 */