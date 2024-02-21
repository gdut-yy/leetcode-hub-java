package p804;

import java.util.Scanner;

public class CF804B {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long ans = 0;
        long b = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == 'b') {
                b++;
            } else {
                ans += b;
                b = b * 2 % MOD;
            }
        }
        ans %= MOD;
        return String.valueOf(ans);
    }
}
/*
B. Minimum number of steps
https://codeforces.com/contest/804/problem/B

灵茶の试炼 2023-11-20
题目大意：
输入一个只包含 'a' 和 'b' 的字符串 s，长度 [1,1e6]。
每次操作，你需要从 s 中选择一个连续子串 "ab"，把它替换成 "bba"。
操作直到 s 中不含 "ab" 为止。
输出最小操作次数，模 1e9+7。

rating 1400
操作相当于 a 把右边的 b 吃掉，然后在左边生成两个 b。
考虑最右边的 a，它右边有多少个 b，就需要对这个 a 操作多少次。
a 吃掉右边所有的 b 后就不用管它了，此时它左边产生了 2*cnt(b) 个 b，这里 cnt(b) 是 a 吃掉的 b 的个数。
然后讨论倒数第二个 a，依此类推。
所以做法是：
1. 遇到 b：把 b 的个数加一。
2. 遇到 a：把 b 的个数加入答案，然后把 b 的个数乘以 2，表示 a 把这么多 b 吃掉后，产生了两倍的 b。
https://codeforces.com/contest/804/submission/232761930
======

input
ab
output
1

input
aab
output
3
 */
