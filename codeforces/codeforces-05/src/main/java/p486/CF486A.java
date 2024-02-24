package p486;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF486A {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        if (n < 4) {
            return "NO";
        }

        List<String> ans = new ArrayList<>();
        ans.add("YES");
        for (int i = 5 + (n & 1); i < n; i += 2) {
            ans.add((i + 1) + " - " + i + " = 1");
            ans.add("1 * 1 = 1");
        }
        if ((n & 1) > 0) {
            ans.add("2 - 1 = 1");
            ans.add("4 * 5 = 20");
            ans.add("20 + 1 = 21");
            ans.add("21 + 3 = 24");
        } else {
            ans.add("1 * 2 = 2");
            ans.add("2 * 3 = 6");
            ans.add("6 * 4 = 24");
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
A. 24 Game
https://codeforces.com/contest/468/problem/A

灵茶の试炼 2022-07-14
题目大意：
输入整数 n(1<=n<=1e5)。
一开始黑板上写了 n 个数：1,2,3,4,...,n。
每次操作，你可以擦掉黑板上的两个数字 a 和 b，然后选择将 a+b，a-b 或 a*b 的其中一个写在黑板上。
这样操作恰好 n-1 次后，最终黑板上就只剩下一个数字了。
你能最终得到 24 吗？
若不能，输出 "NO"；否则输出 "YES" 和具体操作方案，输出的格式形如
"a + b = c"（注意空格）。若有多种操作方案，输出任意一种即可。

rating 1500
constructive algorithms
https://codeforces.com/contest/468/submission/164086516
提示 1
n=4 要怎么操作，n=5 要怎么操作？
提示 2
对于 n>5 的情况，尝试找 1，然后转换成 n=4 或 n=5 的情况。
具体操作方式见代码，可以结合实际的输出来理解。
======

input
1
output
NO

input
8
output
YES
8 * 7 = 56
6 * 5 = 30
3 - 4 = -1
1 - 2 = -1
30 - -1 = 31
56 - 31 = 25
25 + -1 = 24
 */
