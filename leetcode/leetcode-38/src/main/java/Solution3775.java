public class Solution3775 {
    // final int VOWEL_MASK = (1 << ('a' - 'a')) | (1 << ('e' - 'a')) | (1 << ('i' - 'a')) | (1 << ('o' - 'a')) | (1 << ('u' - 'a'));
    private static final int VOWEL_MASK = 1065233;

    private boolean isVowel(int b) {
        return (VOWEL_MASK >> b & 1) == 1;
    }

    public String reverseWords(String s) {
        String[] sp = s.split(" ");
        int n = sp.length;
        int firstVowelCnt = getVowelCnt(sp[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(sp[0]);
        for (int i = 1; i < n; i++) {
            sb.append(" ");
            int vowelCnt = getVowelCnt(sp[i]);
            if (vowelCnt == firstVowelCnt) {
                sb.append(new StringBuilder(sp[i]).reverse());
            } else {
                sb.append(sp[i]);
            }
        }
        return sb.toString();
    }

    private int getVowelCnt(String s) {
        int vowelCnt = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c - 'a')) vowelCnt++;
        }
        return vowelCnt;
    }
}
/*
3775. 反转元音数相同的单词
https://leetcode.cn/problems/reverse-words-with-same-vowel-count/description/

第 480 场周赛 T2。

给你一个字符串 s，它由小写的英文单词组成，每个单词之间用一个空格隔开。
请确定 第一个单词 中的元音字母数。然后，对于每个 后续单词 ，如果它们的元音字母数与第一个单词相同，则将它们 反转 。其余单词保持不变。
返回处理后的结果字符串。
元音字母包括 'a', 'e', 'i', 'o' 和 'u'。
提示：
1 <= s.length <= 10^5
s 仅由小写的英文字母和空格组成。
s 中的单词由 单个空格 隔开。
s 不包含前导或尾随空格。

模拟。
时间复杂度 O(n)。
 */