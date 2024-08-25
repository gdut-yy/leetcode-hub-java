package p460;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF460B {
    static int a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        List<Long> ans = new ArrayList<>();
        for (int ds = 1; ds <= 81; ds++) {
            long x = b;
            for (int i = 0; i < a; i++) {
                x *= ds;
            }
            x += c;
            if (x >= 1e9) {
                break;
            }
            if (x > 0) {
                long s = ds;
                for (long x0 = x; x0 > 0; x0 /= 10) {
                    s -= x0 % 10;
                }
                if (s == 0) {
                    ans.add(x);
                }
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Little Dima and Equation
https://codeforces.com/contest/460/problem/B

灵茶の试炼 2023-06-13
題目大意：
输入 a(1≤a≤5) b(1≤b≤10000) c(-10000≤c≤10000)。
解方程：
x = b * pow(s(x),a) + c 且 0 < x < 1e9
其中 s(x) 是 x 的数位和。
第一行输出 x 的个数。
第二行按升序输出所有 x。

rating 1500
https://codeforces.com/contest/460/submission/208147283
枚举 s(x)。
由于 0<x<1e9，所以 1<=s(x)<=81。
代入等式右边，算出 x，再验证 s(x) 是否等于所枚举的 s(x)。
======

input
3 2 8
output
3
10 2008 13726

input
1 2 -18
output
0

input
2 2 -1
output
4
1 31 337 967
 */
