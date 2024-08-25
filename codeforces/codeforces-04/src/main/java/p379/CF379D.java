package p379;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF379D {
    static int k, x, n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        k = scanner.nextInt();
        x = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        for (int c1 = 0; c1 < 2; c1++) {
            for (int a1 = 0; a1 < 2 && c1 + a1 <= n; a1++) {

                for (int c2 = 0; c2 < 2; c2++) {
                    for (int a2 = 0; a2 < 2 && c2 + a2 <= m; a2++) {

                        for (int ac1 = 0; ac1 <= (n - c1 - a1) / 2; ac1++) {
                            for (int ac2 = 0; ac2 <= (m - c2 - a2) / 2; ac2++) {

                                int C1 = c1, C2 = c2, A1 = a1, AC1 = ac1, AC2 = ac2;
                                for (int i = 2; i < k && AC2 <= x; i++) {
                                    int _C1 = C1, _C2 = C2, _A1 = A1, _AC1 = AC1, _AC2 = AC2;
                                    C1 = _C2;
                                    C2 = _C1;
                                    A1 = a2;
                                    AC1 = _AC2;
                                    AC2 = _AC1 + (_A1 & _C2) + _AC2;
                                }

                                if (AC2 == x) {
                                    return "C".repeat(c1) + "AC".repeat(ac1) + "B".repeat(n - c1 - ac1 * 2 - a1) + "A".repeat(a1) + System.lineSeparator()
                                            + "C".repeat(c2) + "AC".repeat(ac2) + "B".repeat(m - c2 - ac2 * 2 - a2) + "A".repeat(a2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return "Happy new year!";
    }
}
/*
D. New Year Letter
https://codeforces.com/contest/379/problem/D

灵茶の试炼 2023-01-02
题目大意：
输入 k(3≤k≤50) x(0≤x≤1e9) n(1≤n≤100) m(1≤m≤100)。
你需要构造长分别为 n 和 m 的字符串 s[1] 和 s[2]，它们只能包含大写字母。
然后按照 s[i]=s[i-2]+s[i-1] 的方式，生成字符串 s[k]，要求子串 "AC" 在 s[k] 中恰好出现 x 次。
如果可以构造，输出任意符合要求的 s[1] 和 s[2]，否则输出 "Happy new year!"。

rating 2000
https://codeforces.com/problemset/submission/379/187613695
AC 只能发生在这些地方：
s[1] 内部
s[2] 内部
s[1]+s[1] 交界处（这是不可能的）
s[1]+s[2] 交界处
s[2]+s[1] 交界处
s[2]+s[2] 交界处
那么暴力枚举 s[1] 中有多少 AC，开头是否为 C，结尾是否为 A。
s[2] 同理。
然后迭代计算 s[k] 的 AC 个数，看是否为 x。
具体见代码。
注意如果 AC 数量超过 x，要及时退出循环，否则会溢出。虽然这题没有针对 hack 这种代码的数据，但是还是要注意不要写出错误的代码。
======

input
3 2 2 2
output
AC
AC

input
3 3 2 2
output
Happy new year!

input
3 0 2 2
output
AA
AA

input
4 3 2 1
output
Happy new year!

input
4 2 2 1
output
Happy new year!
 */
