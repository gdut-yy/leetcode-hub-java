public class Solution4105 {
    public boolean repeatedStringMatch(String a, String b, int x, int y) {
        long la = a.length();
        long lb = b.length();
        long targetLen = lb * (long) y;
        long sourceLen = la * (long) x;
        if (targetLen > sourceLen) {
            return false;
        }
        long lcm = la / gcd(la, lb) * lb;
        long checkLen = Math.min(targetLen, lcm);
        long maxStart = Math.min(la - 1, sourceLen - targetLen);

        for (long start = 0; start <= maxStart; start++) {
            boolean ok = true;
            for (long k = 0; k < checkLen; k++) {
                char ca = a.charAt((int) ((start + k) % la));
                char cb = b.charAt((int) (k % lb));
                if (ca != cb) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return true;
            }
        }

        return false;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
/*
4105. 重复字符串匹配 II
https://leetcode.cn/problems/repeated-string-match-ii/description/

第 195 场双周赛 T4。

给你两个由小写英文字母组成的字符串 a 和 b，以及两个整数 x 和 y。
如果将 b 重复恰好 y 次得到的字符串 (b * y) 是将 a 重复恰好 x 次得到的字符串 (a * x) 的 子串 ，返回 true。否则，返回 false。
子串 是字符串内连续的 非空 字符序列。
示例 1：
输入： a = "ab", b = "abab", x = 2, y = 1
输出： true
示例 2：
输入： a = "abc", b = "bc", x = 2, y = 3
输出： false
示例 3：
输入： a = "abcd", b = "cdab", x = 2, y = 1
输出： true
提示：
1 <= a.length <= 100
1 <= b.length <= 100
1 <= x <= 10^9
1 <= y <= 10^9
a 和 b 仅由小写英文字母组成。

暴力。
 */