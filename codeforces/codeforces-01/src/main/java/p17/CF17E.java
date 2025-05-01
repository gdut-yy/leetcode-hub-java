package p17;

import java.util.Arrays;
import java.util.Scanner;

public class CF17E {
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    static final int MOD = 51123987;

    private static String solve() {
        long tot = 0;

        StringBuilder t = new StringBuilder("^");
        for (char c : s.toCharArray()) t.append("#").append(c);
        t.append("#$");
        int[] halfLen = new int[t.length() - 2];
        halfLen[1] = 1;
        int boxM = 0, boxR = 0;
        for (int i = 2; i < halfLen.length; i++) {
            int hl = 1;
            if (i < boxR) hl = Math.min(halfLen[boxM * 2 - i], boxR - i);
            while (t.charAt(i - hl) == t.charAt(i + hl)) {
                hl++;
                boxM = i;
                boxR = i + hl;
            }
            halfLen[i] = hl;

            tot += hl / 2;
        }
        tot %= MOD;
        long ans = tot * (tot - 1) / 2;

        long[] diff = new long[n + 1];
        for (int i = 0; i < halfLen.length; i++) {
            int hl = halfLen[i];
            int l = (i - hl) / 2, r = (i + hl) / 2 - 2;
            if (l <= r) {
                diff[(l + r + 1) / 2]++;
                diff[r + 1]--;
            }
        }
        // cntEnd := diff[:n]
        long[] cntEnd = Arrays.copyOfRange(diff, 0, n);
        for (int i = 1; i < n; i++) {
            cntEnd[i] += cntEnd[i - 1];
        }
        for (int i = 1; i < n; i++) {
            cntEnd[i] += cntEnd[i - 1];
        }

        long[] sum = new long[n + 1];
        for (int i = 0; i < cntEnd.length; i++) {
            sum[i + 1] = (sum[i] + cntEnd[i]) % MOD;
        }
        for (int i = 0; i < halfLen.length; i++) {
            int hl = halfLen[i];
            int l = (i - hl) / 2, r = (i + hl) / 2 - 2;
            if (l <= r) {
                ans -= sum[(l + r) / 2] - sum[Math.max(l - 1, 0)];
            }
        }

        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }
}
/*
E. Palisection
https://codeforces.com/contest/17/problem/E

灵茶の试炼 2025-03-07
题目大意：
输入 n(1≤n≤2e6) 和长度为 n 的字符串 s，只包含小写英文字母。
从 s 中选两个重叠（有公共部分）的非空回文子串，有多少种选法？
答案模 51123987。

rating 2900
正难则反，用所有回文子串对数，减去不重叠的回文子串对数，即为重叠的回文子串对数。
如何计算回文子串的个数？见 力扣 647. 回文子串 （Manacher 算法）
通过 Manacher 算法，可以知道在某个回文中心的最长回文子串的下标区间 [l,r]。剥洋葱，[l+1,r-1],[l+2,r-2],... 这些也是回文子串。
统计以 i 结尾的回文子串个数。对于上述 [l,r] 及其内部的回文子串，右端点最小是 (l+r+1)/2，最大是 r。
所以右端点在 [(l+r+1)/2,r] 中的回文子串个数都要加一。这可以用差分数组维护。
进一步地，计算前缀和，求出右端点 <= i 的回文子串个数 cntEnd[i]。
然后枚举右维护左。
枚举回文中心，设最长回文子串为 [l,r]，那么与之不相交的回文子串就是右端点 <= l-1 的子串个数 cntEnd[l-1]。
剥洋葱，对于 [l+1,r-1],[l+2,r-2],... 这些，累加相应的 cntEnd。预处理 cntEnd 的前缀和，便可以快速累加。
注意取模。
注意保证取模结果非负。
代码 https://codeforces.com/problemset/submission/17/309142491
代码备份（洛谷）
======

Input
4
babb
Output
6

Input
2
aa
Output
2
 */
