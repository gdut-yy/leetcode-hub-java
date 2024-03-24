package p1084;

import java.util.Scanner;

public class CF1084C {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long ans = 0, pre = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                ans = (ans + pre + 1) % MOD;
            } else if (ch == 'b') {
                pre = ans;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. The Fair Nut and String
https://codeforces.com/contest/1084/problem/C

灵茶の试炼 2022-07-08
题目大意：
【易错题】
输入一个字符串 s，长度不超过 1e5，只由小写字母组成。
请你求出满足如下条件的 s 的下标序列 p 的个数：
1. p[i] < p[i+1]；
2. s[p[i]] 均为 'a'；
3. s[p[i]] 和 s[p[i+1]] 之间至少有一个 'b'。
输出答案模 1e9+7 的结果。

rating 1500
https://codeforces.com/contest/1084/submission/136214166
f[i] 表示 s 的前 i 个字母（的下标）组成的合法序列个数。
当 s[i]≠'a' 时，f[i] = f[i-1]
当 s[i]='a' 时，f[i] = f[i-1] + f[last['b']] + 1   // 不选 or 选
其中 last['b'] 表示 'b' 上一次出现的下标。
答案为 f[-1]
实现时，f[] 可以压缩成一个变量。
======

input
abbaa
output
5

input
baaaa
output
4

input
agaa
output
3
 */
