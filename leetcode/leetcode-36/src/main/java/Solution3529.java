public class Solution3529 {
    public int countCells(char[][] grid, String pattern) {
        int m = grid.length;
        int n = grid[0].length;

        char[] hText = new char[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hText[idx++] = grid[i][j];
            }
        }

        char[] vText = new char[m * n];
        idx = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                vText[idx++] = grid[i][j];
            }
        }

        char[] pat = pattern.toCharArray();
        int[] pi = prefix_function(pat);
        int[] inPatternH = kmpSearch(hText, pat, pi);
        int[] inPatternV = kmpSearch(vText, pat, pi);

        int ans = 0;
        for (int i = 0; i < m * n; i++) {
            if (inPatternH[i] > 0 && inPatternV[i % n * m + i / n] > 0) {
                ans++;
            }
        }
        return ans;
    }

    private int[] prefix_function(char[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
        }
        return pi;
    }

    // 差分
    private int[] kmpSearch(char[] text, char[] pattern, int[] pi) {
        int n = text.length;
        int[] diff = new int[n + 1];
        int match = 0;
        for (int i = 0; i < n; i++) {
            char b = text[i];
            while (match > 0 && pattern[match] != b) {
                match = pi[match - 1];
            }
            if (pattern[match] == b) {
                match++;
            }
            if (match == pi.length) {
                diff[i - pi.length + 1]++;
                diff[i + 1]--;
                match = pi[match - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}
/*
3529. 统计水平子串和垂直子串重叠格子的数目
https://leetcode.cn/problems/count-cells-in-overlapping-horizontal-and-vertical-substrings/description/

第 155 场双周赛 T3。

给你一个由字符组成的 m x n 矩阵 grid 和一个字符串 pattern。
水平子串 是从左到右的一段连续字符序列。如果子串到达了某行的末尾，它将换行并从下一行的第一个字符继续。不会 从最后一行回到第一行。
垂直子串 是从上到下的一段连续字符序列。如果子串到达了某列的底部，它将换列并从下一列的第一个字符继续。不会 从最后一列回到第一列。
请统计矩阵中满足以下条件的单元格数量：
- 该单元格必须属于 至少 一个等于 pattern 的水平子串，且属于 至少 一个等于 pattern 的垂直子串。
返回满足条件的单元格数量。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 1000
1 <= m * n <= 10^5
1 <= pattern.length <= m * n
grid 和 pattern 仅由小写英文字母组成。

坐标转化 + KMP + 差分数组
https://leetcode.cn/problems/count-cells-in-overlapping-horizontal-and-vertical-substrings/solutions/3663069/kmp-chai-fen-shu-zu-pythonjavacgo-by-end-h5mz/
时间复杂度 O(mn)。
rating 2116 (clist.by)
 */