package p825;

import java.util.Scanner;

public class CF825F {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length();
        int[] sz = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sz[i] = sz[i / 10] + 1;
        }

        int[] f = new int[n + 1];
        int[] pi = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            char[] t = s.substring(i).toCharArray();
            int m = t.length;
            f[i] = Math.min(m + 1, f[i + 1] + 2);
            int cnt = 0;
            for (int j = 1; j < m; j++) {
                char b = t[j];
                while (cnt > 0 && t[cnt] != b) {
                    cnt = pi[cnt - 1];
                }
                if (t[cnt] == b) {
                    cnt++;
                }
                pi[j] = cnt;
                int k = j + 1 - cnt;
                if (cnt > 0 && (j + 1) % k == 0) {
                    f[i] = Math.min(f[i], f[i + j + 1] + sz[(j + 1) / k] + k);
                } else {
                    f[i] = Math.min(f[i], f[i + j + 1] + j + 2);
                }
            }
        }
        return String.valueOf(f[0]);
    }
}
/*
F. String Compression
https://codeforces.com/contest/825/problem/F

灵茶の试炼 2025-04-25
题目大意：
输入长度 ≤8000 的字符串 s，只包含小写英文字母。
你需要压缩 s = s1 * c1 + s2 * c2 + ...
例如 abababcc = ab * 3 + c * 2。
压缩后的长度定义为 |s1| + |c1| + |s2| + |c2| + ...
其中 |c1| 表示整数 c1 的十进制长度。
例如 ab * 3 + c * 2 的长度为 2 + 1 + 1 + 1 = 5。
输出 s 压缩后的最短长度。

rating 2400
划分型 DP。
从右往左 DP（因为下面要做 KMP，方便套模板），定义 f[i] 表示 [i,n-1] 压缩后的最短长度。
如何计算 f[i]？我们将子串左端点固定为 i，右端点枚举 j=i,i+1,...,n-1。
用 KMP 计算子串 [i,j] 的 周期，设最短周期串长为 k（如果周期=1，长度就是 j-i+1），那么 [i,j] 由 (j-i+1)/k 个长为 k 的字符串组成，所以压缩后的长度为 len10((j-i+1)/k) + k。其中 len10(x) 表示 x 的十进制长度。
所以有转移（枚举 j，所有转移来源取最小值）
f[i] <- f[j+1] + len10((j-i+1)/k) + k
其中 f[j+1] 表示 [i,n-1] 去掉 [i,j] 后的子问题 [j+1,n-1]。
初始值 f[n] = 0，f[i] = min(n-i+1, f[i+1]+2)。其中 n-i+1 表示 [i,n-1] 作为一个子串，周期=1；f[i+1]+2 表示 [i,i] 作为一个子串，周期=1。
答案为 f[0]，即原问题，[0,n-1] 压缩后的最短长度。
代码 https://codeforces.com/problemset/submission/825/316620517
代码备份（洛谷）
https://oi-wiki.org/string/kmp/#%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E5%91%A8%E6%9C%9F
======

Input
aaaaaaaaaa
Output
3

Input
abcab
Output
6

Input
cczabababab
Output
7
 */
