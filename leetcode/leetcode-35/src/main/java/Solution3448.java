public class Solution3448 {
    static class V1 {
        public long countSubstrings(String s) {
            int n = s.length();
            long ans = 0;
            // f[i+1][m][rem] 表示以 si 结尾的、模 m 余数为 rem 的子串个数
            long[][][] f = new long[n + 1][10][10];
            for (int i = 0; i < n; i++) {
                int d = s.charAt(i) - '0'; // 以 v 结尾
                for (int m = 1; m <= 9; m++) {
                    f[i + 1][m][d % m] += 1;
                    for (int rem = 0; rem < m; rem++) {
                        f[i + 1][m][(rem * 10 + d) % m] += f[i][m][rem];
                    }
                }
                ans += f[i + 1][d][0];
            }
            return ans;
        }
    }

    // 滚动数组优化
    static class V2 {
        public long countSubstrings(String s) {
            int n = s.length();
            long ans = 0;
            long[][] f = new long[10][10];
            for (int i = 0; i < n; i++) {
                int d = s.charAt(i) - '0'; // 以 v 结尾
                long[][] nf = new long[10][10];
                for (int m = 1; m <= 9; m++) {
                    nf[m][d % m] += 1;
                    for (int rem = 0; rem < m; rem++) {
                        nf[m][(rem * 10 + d) % m] += f[m][rem];
                    }
                }
                ans += nf[d][0];
                f = nf;
            }
            return ans;
        }
    }

    static class V3 {
        public long countSubstrings(String s) {
            int n = s.length();
            long ans = 0;
            long[][] f = new long[10][10];
            for (int i = 0; i < n; i++) {
                int d = s.charAt(i) - '0'; // 以 v 结尾
                for (int m = 1; m <= 9; m++) {
                    long[] nf = new long[10];
                    nf[d % m] += 1;
                    for (int rem = 0; rem < m; rem++) {
                        nf[(rem * 10 + d) % m] += f[m][rem];
                    }
                    f[m] = nf;
                }
                ans += f[d][0];
            }
            return ans;
        }
    }
}
/*
3448. 统计可以被最后一个数位整除的子字符串数目
https://leetcode.cn/problems/count-substrings-divisible-by-last-digit/description/

第 436 场周赛 T3。

给你一个只包含数字的字符串 s 。
请你返回 s 的最后一位 不是 0 的子字符串中，可以被子字符串最后一位整除的数目。
子字符串 是一个字符串里面一段连续 非空 的字符序列。
注意：子字符串可以有前导 0 。
提示：
1 <= s.length <= 10^5
s 只包含数字。

定义 f[i+1][m][rem] 表示以 s[i] 结尾的，模 m 结果是 rem 的子串个数
以 s[i-1] 结尾的子串，末位再添加上 s[i]，就是以 s[i] 结尾的子串
计算以 s[i] 结尾的模 m 的子串个数
(rem_{i-1} * 10 + s[i]) % m
   以 s[i-1] 结尾的模 m 的余数为 rem 的子串的个数 =  50
-> 以 s[i] 结尾的模 m 的余数为 (rem * 10 + s[i]) % m 的子串新增了 50 个
写成代码就是 f[i+1][m][(rem * 10 + s[i]) % m] += f[i][m][rem]
初始值 s[i] 单独形成一个子串，f[i+1][m][s[i]%m] = 1
答案是什么？
以 s[i] 结尾的模 s[i] 的余数为 0 的子串个数
时间复杂度 O(n * D^2)。其中 D = 9
rating 2378 (clist.by)
 */