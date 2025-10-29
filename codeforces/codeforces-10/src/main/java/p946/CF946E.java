package p946;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF946E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        char[] s = scanner.next().toCharArray();
        int n = s.length;

        // 检查特殊情况：首字符为'1'，末字符<='1'，中间全是'0'
        if (s[0] == '1' && s[n - 1] <= '1') {
            boolean allZeros = true;
            for (int i = 1; i < n - 1; i++) {
                if (s[i] != '0') {
                    allZeros = false;
                    break;
                }
            }
            if (allZeros) {
                out.println("9".repeat(n - 2));
                return;
            }
        }

        // 从后往前找到第一个非'0'的位置并减1，后面全设为'9'
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] > '0') {
                s[i]--;
                for (int j = i + 1; j < n; j++) {
                    s[j] = '9';
                }
                break;
            }
        }

        // 统计每个数字出现的奇偶性
        int[] cnt = new int[10];
        for (char c : s) {
            cnt[c - '0'] ^= 1;
        }

        int odd = 0;
        for (int c : cnt) {
            odd += c;
        }

        if (odd > 0) {
            outer:
            for (int i = n - 1; i >= 0; i--) {
                cnt[s[i] - '0'] ^= 1;
                odd += (cnt[s[i] - '0'] == 1) ? 1 : -1;

                for (s[i]--; s[i] >= '0'; s[i]--) {
                    int v = s[i] - '0';
                    cnt[v] ^= 1;
                    odd += cnt[v] * 2 - 1;

                    if (odd <= n - 1 - i) {
                        odd -= cnt[9];
                        for (int j = i + 1; j < n - odd; j++) {
                            s[j] = '9';
                        }
                        int j = n - odd;
                        for (int k = 8; k >= 0; k--) {
                            if (cnt[k] > 0) {
                                s[j] = (char) ('0' + k);
                                j++;
                            }
                        }
                        break outer;
                    }
                    odd -= cnt[v] * 2 - 1;
                    cnt[v] ^= 1;
                }
            }
        }
        out.println(new String(s));
    }
}
/*
E. Largest Beautiful Number
https://codeforces.com/contest/946/problem/E

灵茶の试炼 2025-09-18
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的数字长度之和 ≤2e5。
每组数据输入长度 ≤2e5 的数字 s，不含前导零，且保证 s 的长度是偶数。
定义美丽数为不含前导零，长度为偶数，且可以重排成回文数的正整数。
例如 4242 是美丽数，因为它可以重排成回文数 2442。
输出严格小于 s 的最大美丽数。（输入保证有解）

rating 2200
注意题目要求答案严格小于 s。
先特判：如果 s = 100...00 或者 100...01，那么答案的长度必须比 s 的小。题目要求回文数的长度必须是偶数，所以答案为 n-2 个 9。（注意题目保证 n 是偶数）
否则，答案的长度一定等于 n（答案至少是 100...01）。下文讨论答案长度等于 n 的情况。
由于题目要求回文数的长度必须是偶数，所以不能有数字的出现次数是奇数。
贪心地，倒着枚举。如果找到答案，那么前面的数位都不需要改。
枚举最后一位填的数，判断是否所有数字的出现次数都是偶数。
如果最后一位怎么填都不行，那么再枚举倒数第二位，此时最后一位可以随便填。
依此类推。
这些「随便填」的位置可以灵活使用，为方便计算，不计入数字个数。
比如现在只有 2 和 3 出现奇数次，末尾有 6 个位置可以随便填，那么最优填法是 999932，得到答案。
又比如 2,3,4,5 出现奇数次，但末尾只有 2 个位置可以随便填，那么无法满足要求，继续枚举。
代码 https://codeforces.com/contest/946/submission/338280651
代码备份（上面打不开的同学看这个）
======

Input
4
89
88
1000
28923845
Output
88
77
99
28923839
 */
