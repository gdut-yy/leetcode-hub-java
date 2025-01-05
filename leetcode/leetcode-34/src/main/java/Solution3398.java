public class Solution3398 {
}
/*
3398. 字符相同的最短子字符串 I
https://leetcode.cn/problems/smallest-substring-with-identical-characters-i/description/

第 429 场周赛 T3。

给你一个长度为 n 的二进制字符串 s 和一个整数 numOps。
你可以对 s 执行以下操作，最多 numOps 次：
- 选择任意下标 i（其中 0 <= i < n），并 翻转 s[i]，即如果 s[i] == '1'，则将 s[i] 改为 '0'，反之亦然。
你需要 最小化 s 的最长 相同 子字符串 的长度，相同子字符串 是指子字符串中的所有字符都 相同。
返回执行所有操作后可获得的 最小 长度。
提示：
1 <= n == s.length <= 1000
s 仅由 '0' 和 '1' 组成。
0 <= numOps <= n

同: 3399. 字符相同的最短子字符串 II
https://leetcode.cn/problems/smallest-substring-with-identical-characters-ii/description/
rating 2307 (clist.by)
 */