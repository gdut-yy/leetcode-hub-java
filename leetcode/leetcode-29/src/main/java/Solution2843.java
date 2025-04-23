import java.util.Arrays;

public class Solution2843 {
    // O( (high-low) * log(high) )
    static class V1 {
        public int countSymmetricIntegers(int low, int high) {
            int ans = 0;
            for (int i = low; i <= high; i++) {
                if (check(i)) {
                    ans++;
                }
            }
            return ans;
        }

        private boolean check(int x) {
            String s = String.valueOf(x);
            int n = s.length();
            if (n % 2 != 0) return false;
            int sum = 0;
            for (int i = 0; i < n / 2; i++) {
                sum += s.charAt(i) - '0';
            }
            for (int i = n / 2; i < n; i++) {
                sum -= s.charAt(i) - '0';
            }
            return sum == 0;
        }
    }

    // O(D^2 n^2)
    static class V2 {
        private char[] lowS, highS;
        private int n, m, diffLh;
        private int[][][] memo;

        public int countSymmetricIntegers(int low, int high) {
            lowS = String.valueOf(low).toCharArray();
            highS = String.valueOf(high).toCharArray();
            n = highS.length;
            diffLh = n - lowS.length;

            // dfs 中的 start <= diffLh，左半元素和 <= floor(n/2) * 9
            memo = new int[n][diffLh + 1][n / 2 * 9 + 1];
            for (int[][] mat : memo) {
                for (int[] row : mat) {
                    Arrays.fill(row, -1);
                }
            }
            return dfs(0, -1, 0, true, true);
        }

        private int dfs(int i, int start, int diff, boolean limitLow, boolean limitHigh) {
            if (diff < 0) {
                return 0;
            }
            if (i == n) {
                return diff == 0 ? 1 : 0;
            }

            // start 当 isNum 用
            if (start != -1 && !limitLow && !limitHigh && memo[i][start][diff] != -1) {
                return memo[i][start][diff];
            }

            int lo = limitLow && i >= diffLh ? lowS[i - diffLh] - '0' : 0;
            int hi = limitHigh ? highS[i] - '0' : 9;

            // 如果前面没有填数字，且剩余数位个数是奇数，那么当前数位不能填数字
            if (start < 0 && (n - i) % 2 > 0) {
                // 如果必须填数字（lo > 0），不合法，返回 0
                return lo > 0 ? 0 : dfs(i + 1, start, diff, true, false);
            }

            int res = 0;
            boolean isLeft = start < 0 || i < (start + n) / 2;
            for (int d = lo; d <= hi; d++) {
                res += dfs(i + 1,
                        start < 0 && d > 0 ? i : start, // 记录第一个填数字的位置
                        diff + (isLeft ? d : -d), // 左半 +，右半 -
                        limitLow && d == lo,
                        limitHigh && d == hi);
            }

            if (start != -1 && !limitLow && !limitHigh) {
                memo[i][start][diff] = res;
            }
            return res;
        }
    }
}
/*
2843. 统计对称整数的数目
https://leetcode.cn/problems/count-symmetric-integers/

第 361 场周赛 T1。

给你两个正整数 low 和 high 。
对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
返回在 [low, high] 范围内的 对称整数的数目 。

暴力 / 数位 DP
 */