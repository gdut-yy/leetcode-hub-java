public class Solution3442 {
    public int maxDifference(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int maxOdd = 0, minEven = Integer.MAX_VALUE;
        for (int c : cnt) {
            if (c % 2 == 1) maxOdd = Math.max(maxOdd, c);
            else if (c > 0) minEven = Math.min(minEven, c);
        }
        return maxOdd - minEven;
    }
}
/*
3442. 奇偶频次间的最大差值 I
https://leetcode.cn/problems/maximum-difference-between-even-and-odd-frequency-i/description/

第 435 场周赛 T1。

给你一个由小写英文字母组成的字符串 s 。请你找出字符串中两个字符的出现频次之间的 最大 差值，这两个字符需要满足：
- 一个字符在字符串中出现 偶数次 。
- 另一个字符在字符串中出现 奇数次 。
返回 最大 差值，计算方法是出现 奇数次 字符的次数 减去 出现 偶数次 字符的次数。
提示：
3 <= s.length <= 100
s 仅由小写英文字母组成。
s 至少由一个出现奇数次的字符和一个出现偶数次的字符组成。

中国时间：2025-02-02 10:30
2025春节初五
统计频次。
 */