public class Solution3980 {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        if (n == 1) {
            if (s1.equals(s2)) return 0;
            if (s1.equals("0") && s2.equals("1")) return 1;
            return -1;
        }

        int ans = 0;
        int i = 0;
        while (i < n) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else if (s1.charAt(i) == '0' && s2.charAt(i) == '1') {
                ans += 1;
                i++;
            } else {
                int j = i;
                while (j < n && s1.charAt(j) == '1' && s2.charAt(j) == '0') {
                    j++;
                }
                int len = j - i;
                ans += len / 2 + (len % 2) * 2;
                i = j;
            }
        }
        return ans;
    }
}
/*
3980. 变换二进制字符串的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-transform-binary-string/description/

第 186 场双周赛 T3。

给你两个长度同为 n 的二进制字符串 s1 和 s2 。
你可以对 s1 以任意顺序执行以下操作 任意 次：
- 选择一个满足 s1[i] 为 '0' 的下标 i ，并将其更改为 '1' 。
- 选择一个满足 0 <= i < n - 1 且 s1[i] 和 s1[i + 1] 均为 '1' 的下标 i 。将这两个字符都更改为 '0' 。
返回使 s1 等于 s2 所需的 最小 操作次数。如果无法使 s1 等于 s2 ，则返回 -1 。
提示：
1 <= n == s1.length == s2.length <= 10^5
s1 和 s2 仅由 '0' 和 '1' 组成。

贪心。
时间复杂度 O(n)。
 */