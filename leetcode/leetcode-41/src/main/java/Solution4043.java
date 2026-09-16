public class Solution4043 {
    public int countRotations(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        int same = 0;
        int ans = 0;
        for (int i = 0; i < n * 2 - 2; i++) {
            // 1. 入
            if (s[i % n] == s[(i + 1) % n]) {
                same++;
            }
            // 注意窗口长度为 n-1
            int left = i - n + 2;
            if (left < 0) {
                continue;
            }
            // 2. 更新答案
            if (same == k) {
                ans++;
            }
            // 3. 出
            if (s[left] == s[(left + 1) % n]) {
                same--;
            }
        }
        return ans;
    }
}
/*
4043. 恰好有 K 对相等相邻字符的循环移位数量
https://leetcode.cn/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/description/

第 518 场周赛 T1。

给你一个长度为 n 的字符串 s 和一个整数 k。
s 的一次 循环移位 可以通过以下方式得到：选择 s 的一个长度在 0 到 n - 1（包含两端）之间的 前缀 ，并将其移动到字符串末尾，同时保持所有字符的相对顺序不变。
对于 s 的 每一种 循环移位，定义其 得分 为满足以下条件的下标 i 的数量：0 <= i < n - 1，且位置 i 和 i + 1 处的字符相同。
返回得分等于 k 的循环移位数量。
字符串的 前缀 是指从字符串开头开始，并延伸到字符串中某个位置的子串。
子串 是字符串中一段连续的字符序列，可以为空。
提示：
2 <= n == s.length <= 100
s 仅由小写英文字母组成。
0 <= k <= n - 1

中国时间 2026-09-06 周日 10:30
深圳。睡到 11:31
滑动窗口。
时间复杂度 O(n)。
 */