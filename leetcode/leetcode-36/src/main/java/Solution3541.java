public class Solution3541 {
    // final int VOWEL_MASK = (1 << ('a' - 'a')) | (1 << ('e' - 'a')) | (1 << ('i' - 'a')) | (1 << ('o' - 'a')) | (1 << ('u' - 'a'));
    private static final int VOWEL_MASK = 1065233;

    public int maxFreqSum(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int mx1 = 0, mx2 = 0;
        for (int i = 0; i < 26; i++) {
            if (isVowel(i)) {
                mx1 = Math.max(mx1, cnt[i]);
            } else {
                mx2 = Math.max(mx2, cnt[i]);
            }
        }
        return mx1 + mx2;
    }

    private boolean isVowel(int b) {
        return (VOWEL_MASK >> b & 1) == 0;
    }
}
/*
3541. 找到频率最高的元音和辅音
https://leetcode.cn/problems/find-most-frequent-vowel-and-consonant/description/

第 156 场双周赛 T1。

给你一个由小写英文字母（'a' 到 'z'）组成的字符串 s。你的任务是找出出现频率 最高 的元音（'a'、'e'、'i'、'o'、'u' 中的一个）和出现频率最高的辅音（除元音以外的所有字母），并返回这两个频率之和。
注意：如果有多个元音或辅音具有相同的最高频率，可以任选其中一个。如果字符串中没有元音或没有辅音，则其频率视为 0。
一个字母 x 的 频率 是它在字符串中出现的次数。
提示:
1 <= s.length <= 100
s 只包含小写英文字母

模拟。
 */