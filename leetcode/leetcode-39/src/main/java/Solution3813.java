public class Solution3813 {
    // final int VOWEL_MASK = (1 << ('a' - 'a')) | (1 << ('e' - 'a')) | (1 << ('i' - 'a')) | (1 << ('o' - 'a')) | (1 << ('u' - 'a'));
    private static final int VOWEL_MASK = 1065233;

    private boolean isVowel(int b) {
        return (VOWEL_MASK >> b & 1) == 1;
    }

    public int vowelConsonantScore(String s) {
        int vowel = 0, consonant = 0;
        for (char c : s.toCharArray()) {
            int b = c - 'a';
            if (0 <= b && b < 26) {
                if (isVowel(b)) vowel++;
                else consonant++;
            }
        }
        if (consonant == 0) return 0;
        return vowel / consonant;
    }
}
/*
3813. 元音辅音得分
https://leetcode.cn/problems/vowel-consonant-score/description/

第 485 场周赛 T1。

给你一个字符串 s，由小写英文字母、空格和数字组成。
令 v 表示 s 中元音字母的数量，c 表示辅音字母的数量。
元音字母是 'a'、'e'、'i'、'o' 和 'u'，而英文字母表中除元音外的其他字母均视为辅音字母。
字符串 s 的 得分 定义如下：
- 如果 c > 0，则 score = floor(v / c)，其中 floor 表示 向下取整 到最接近的整数。
- 否则，如果 c = 0，则 score = 0。
返回一个整数，表示字符串的得分。
提示：
1 <= s.length <= 100
s 仅由小写英文字母、空格和数字组成。

模拟，注意还有空格和数字。
时间复杂度 O(n)。
 */