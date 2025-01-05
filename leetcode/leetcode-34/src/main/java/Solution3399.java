public class Solution3399 {
    public int minLength(String s, int numOps) {
        int n = s.length();
        char[] cs = s.toCharArray();
        if (check(cs, numOps, 0) || check(cs, numOps, 1)) return 1;

        int left = 2;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(cs, numOps, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(char[] s, int numOps, int x) {
        int cnt = 0;
        for (int i = 0; i < s.length; i++) if (s[i] % 2 != (i + x) % 2) cnt++;
        return cnt <= numOps;
    }

    private boolean checkMid(char[] s, int numOps, int mid) {
        int needOps = 0;
        int i = 0;
        while (i < s.length) {
            int st = i;
            for (i++; i < s.length && s[i] == s[st]; i++) {
            }
            int span = i - st;
            needOps += span / (mid + 1);
        }
        return needOps <= numOps;
    }
}
/*
3399. 字符相同的最短子字符串 II
https://leetcode.cn/problems/smallest-substring-with-identical-characters-ii/description/

第 429 场周赛 T4。

给你一个长度为 n 的二进制字符串 s 和一个整数 numOps。
你可以对 s 执行以下操作，最多 numOps 次：
- 选择任意下标 i（其中 0 <= i < n），并 翻转 s[i]，即如果 s[i] == '1'，则将 s[i] 改为 '0'，反之亦然。
你需要 最小化 s 的最长 相同 子字符串 的长度，相同子字符串是指子字符串中的所有字符都相同。
返回执行所有操作后可获得的 最小 长度。
提示：
1 <= n == s.length <= 10^5
s 仅由 '0' 和 '1' 组成。
0 <= numOps <= n

二分 + 贪心 + 分类讨论。
但 x=1 的情况就不能使用这个调整了。考虑 s = 0110，无论是第一个 1 还是第二个 1，都位于这一段的边界，可能会影响到相邻段的答案，
因此不能直接应用这个贪心。好在 x=1 的情况下，最终的字符串只可能有两种：要么 0101...，要么 1010...。
我们把最终字符串和 s 进行比较，看是不是至多有 numOps 个字符不同即可。
rating 2382 (clist.by)
 */