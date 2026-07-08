package p2030;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2030C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        scanner.nextInt();
        String s = scanner.next();
        if (("1" + s + "1").contains("11")) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}
/*
C. A TRUE Battle
https://codeforces.com/contest/2030/problem/C

灵茶の试炼 2026-05-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的 01 字符串 s。
在 s 的字符之间插入 or 或 and，一共插入 n-1 个运算符。
把 0 视作 false，1 视作 true，我们可以得到一个布尔表达式（优先计算 and）。
Alice 和 Bob 轮流插入 and 或 or 运算符。Alice 先手。
Alice 的目标是让最终表达式的值为 true，Bob 的目标是让其为 false。
游戏一共 n-1 个回合。双方都采取最优策略。
如果最终表达式的值为 true，输出 YES，否则输出 NO。

rating 1100
Alice 只要构造出 ... or '1' or ... 就赢了。
如果 s[0]='1' 或者 s[n-1]='1'，那么 Alice 在旁边放一个 or 就赢了。
如果 s 包含 "11"，那么 Alice 在两个 1 的中间放一个 or，无论下一轮 Bob 把 and 放哪边，Alice 在另一边在放一个 or 就赢了。
其他情况，Alice 在 1 的一侧放 or，Bob 就在另一侧放 and，Alice 必输。
所以只需判断 "1" + s + "1" 是否包含 "11" 即可。
代码 https://codeforces.com/contest/2030/submission/375288528
代码备份（上面打不开的同学看这个）
======

Input
5
2
11
3
010
12
101111111100
10
0111111011
8
01000010
Output
YES
NO
YES
YES
NO
 */
