public class Solution3579 {
    public int minOperations(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int n = s.length;
        int[] f = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int res = Integer.MAX_VALUE;
            int[][] cnt = new int[26][26];
            int op = 0;

            for (int j = i; j >= 0; j--) {
                // 不反转
                int x = s[j] - 'a';
                int y = t[j] - 'a';
                if (x != y) {
                    if (cnt[y][x] > 0) {
                        cnt[y][x]--;
                    } else {
                        cnt[x][y]++;
                        op++;
                    }
                }

                // 反转
                int[][] revCnt = new int[26][26];
                int revOp = 1;
                for (int p = j; p <= i; p++) {
                    x = s[p] - 'a';
                    y = t[i + j - p] - 'a';
                    if (x == y) {
                        continue;
                    }
                    if (revCnt[y][x] > 0) {
                        revCnt[y][x]--;
                    } else {
                        revCnt[x][y]++;
                        revOp++;
                    }
                }

                res = Math.min(res, f[j] + Math.min(op, revOp));
            }

            f[i + 1] = res;
        }

        return f[n];
    }
}
/*
3579. 字符串转换需要的最小操作数
https://leetcode.cn/problems/minimum-steps-to-convert-string-with-operations/description/

第 453 场周赛 T4。

给你两个长度相等的字符串 word1 和 word2。你的任务是将 word1 转换成 word2。
为此，可以将 word1 分割成一个或多个连续子字符串。对于每个子字符串 substr，可以执行以下操作：
1.替换：将 substr 中任意一个索引处的字符替换为另一个小写字母。
2.交换：交换 substr 中任意两个字符的位置。
3.反转子串：将 substr 进行反转。
每种操作计为 一次 ，并且每个子串中的每个字符在每种操作中最多只能使用一次（即任何字符的下标不能参与超过一次替换、交换或反转操作）。
返回将 word1 转换为 word2 所需的 最小操作数 。
子串 是字符串中任意一个连续且非空的字符序列。
提示：
1 <= word1.length == word2.length <= 100
word1 和 word2 仅由小写英文字母组成。

O(n^2) 做法：划分型 DP + 贪心 + 中心扩展法
https://leetcode.cn/problems/minimum-steps-to-convert-string-with-operations/solutions/3695734/hua-fen-xing-dp-tan-xin-pythonjavacgo-by-17kb/
rating 2476 (clist.by)
 */