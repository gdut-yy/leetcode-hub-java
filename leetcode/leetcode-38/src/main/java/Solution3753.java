public class Solution3753 {
    public long totalWaviness(long num1, long num2) {
        return calculateWaviness(num2) - calculateWaviness(num1 - 1);
    }

    private char[] s;
    private Long[][][][] memo;

    private long calculateWaviness(long num) {
        s = String.valueOf(num).toCharArray();
        int n = s.length;
        if (n < 3) return 0;
        memo = new Long[n + 1][11][11][20];
        return dfs(0, 10, 10, false, true, 0);
    }

    // pre1: 往前一个 pre2: 往前两个
    private long dfs(int i, int pre1, int pre2, boolean isNum, boolean isLimit, int wav) {
        if (i == s.length) return wav;
        if (!isLimit && isNum && memo[i][pre1][pre2][wav] != null) return memo[i][pre1][pre2][wav];
        long res = 0;
        int upper = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= upper; d++) {
            boolean nxtIsNum = isNum;
            int nxtPre1 = pre1;
            int nxtPre2 = pre2;
            int nxtWav = wav;
            boolean nxtIsLimit = isLimit && d == upper;
            if (!isNum) {
                if (d != 0) {
                    nxtIsNum = true;
                    nxtPre1 = d;
                    nxtPre2 = 10;
                }
            } else {
                if (pre2 != 10) {
                    if (pre1 > pre2 && pre1 > d) {
                        nxtWav++;
                    } else if (pre1 < pre2 && pre1 < d) {
                        nxtWav++;
                    }
                }
                nxtPre2 = pre1;
                nxtPre1 = d;
            }
            res += dfs(i + 1, nxtPre1, nxtPre2, nxtIsNum, nxtIsLimit, nxtWav);
        }
        if (!isLimit && isNum) {
            memo[i][pre1][pre2][wav] = res;
        }
        return res;
    }
}
/*
3753. 范围内总波动值 II
https://leetcode.cn/problems/total-waviness-of-numbers-in-range-ii/description/

第 170 场双周赛 T4。

给你两个整数 num1 和 num2，表示一个 闭 区间 [num1, num2]。
一个数字的 波动值 定义为该数字中 峰 和 谷 的总数：
- 如果一个数位 严格大于 其两个相邻数位，则该数位为 峰。
- 如果一个数位 严格小于 其两个相邻数位，则该数位为 谷。
- 数字的第一个和最后一个数位 不能 是峰或谷。
- 任何少于 3 位的数字，其波动值均为 0。
返回范围 [num1, num2] 内所有数字的波动值之和。
提示：
1 <= num1 <= num2 <= 10^15

数位 DP。
时间复杂度 O(logn)。
rating 2725 (clist.by)
 */