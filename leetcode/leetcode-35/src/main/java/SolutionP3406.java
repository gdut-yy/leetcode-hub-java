public class SolutionP3406 {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        int n = word.length();
        // 取最大子串长度为 n - numFriends + 1 的前缀
        int i = minimalString(word.toCharArray(), false);
        int maxLen = Math.min(n + 1 - numFriends, n - i);
        return word.substring(i, i + maxLen);
    }

    // 最小表示法
    private int minimalString(char[] s, boolean isMin) {
        int n = s.length;
        int k = 0, i = 0, j = 1;
        while (k < n && i < n && j < n) {
            int d = chr(s, i + k, isMin) - chr(s, j + k, isMin);
            if (d == 0) {
                k++;
            } else {
                if (d > 0 == isMin) i = i + k + 1;
                else j = j + k + 1;
                if (i == j) i++;
                k = 0;
            }
        }
        i = Math.min(i, j);
        return i;
    }

    private int chr(char[] s, int i, boolean isMin) {
        int n = s.length;
        if (i >= n) return isMin ? s[i % n] : 0;
        return s[i];
    }
}
/*
$3406. 从盒子中找出字典序最大的字符串 II
https://leetcode.cn/problems/find-the-lexicographically-largest-string-from-the-box-ii/description/

给你一个字符串 word 和一个整数 numFriends。
Alice 正在为她的 numFriends 位朋友组织一个游戏。游戏分为多个回合，在每一回合中：
- word 被分割成 numFriends 个 非空 字符串，且该分割方式与之前的任意回合所采用的都 不完全相同 。
- 所有分割出的字符串都会被放入一个盒子中。
在所有回合结束后，找出盒子中 字典序最大的 字符串。
字符串 a 的字典序 小于 字符串 b 的前提是：在两个字符串上第一处不同的位置上，a 的字母在字母表中的顺序早于 b 中对应的字母。
如果前 min(a.length, b.length) 个字符都相同，那么较短的字符串字典序更小。
提示:
1 <= word.length <= 2 * 10^5
word 仅由小写英文字母组成。
1 <= numFriends <= word.length

同: 3403. 从盒子中找出字典序最大的字符串 I
https://leetcode.cn/problems/find-the-lexicographically-largest-string-from-the-box-i/description/
 */