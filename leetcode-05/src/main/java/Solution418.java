public class Solution418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;

        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = sentence[i].length();
        }
        int[] dp = new int[n];

        int wordIndex = 0;
        for (int i = 0; i < n; i++) {
            wordIndex = i;
            int currRowLen = 0, times = 0;
            while (currRowLen + len[wordIndex] <= cols) {
                currRowLen += len[wordIndex++] + 1;
                if (wordIndex == n) {
                    wordIndex = 0;
                    times++;
                }
            }
            dp[i] = wordIndex + times * 100;
        }

        int index = 0;
        int res = 0;
        wordIndex = 0;
        while (index < rows) {
            index++;
            res += dp[wordIndex] / 100;
            wordIndex = dp[wordIndex] % 100;
        }
        return res;
    }
}
/*
$418. 屏幕可显示句子的数量
https://leetcode.cn/problems/sentence-screen-fitting/

给你一个 rows x cols 的屏幕和一个用 非空 的单词列表组成的句子，请你计算出给定句子可以在屏幕上完整显示的次数。
注意：
1.一个单词不能拆分成两行。
2.单词在句子中的顺序必须保持不变。
3.在一行中 的两个连续单词必须用一个空格符分隔。
4.句子中的单词总量不会超过 100。
5.每个单词的长度大于 0 且不会超过 10。
6. 1 ≤ rows, cols ≤ 20,000.

动态规划
https://leetcode.cn/problems/sentence-screen-fitting/solution/yong-kong-jian-huan-shi-jian-java-dong-t-yzyj/
 */