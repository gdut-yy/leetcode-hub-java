package p1624;

import java.util.Scanner;
import java.util.function.Function;

public class CF1624F {
    static Scanner scanner = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        n = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        final int[] add = {1};
        int ans = sortSearch(n - 2, (m) -> {
            int m2 = m + add[0];
            int c = n - 1 - m2 % n;
            add[0] += c;
            System.out.println("+ " + c);
            int res = scanner.nextInt();
            return res == m2 / n;
        });
        return "! " + (ans + add[0]);
    }

    // func Search(n int, f func(int) bool) int { ... }
    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
F. Interacdive Problem
https://codeforces.com/contest/1624/problem/F

灵茶の试炼 2024-10-03
题目大意：
输入 n(3≤n≤1000)。
评测机有一个在 [1,n-1] 中的整数 x，你需要猜出 x 是多少。
你可以执行如下询问，至多 15 次：
"+ c"：让评测机把 x 永久增加 c(1≤c≤n-1)，然后评测机返回给你 floor(x/n)。
如果你猜出了当前的 x 是多少，那么立刻输出 "! x"。
注意：你需要输出的是 x 增加之后的值，不是初始值。

rating 2000
例如 n=7，答案在 1,2,3,4,5,6 中。
二分 m=3，构造 c = n-1-m%n = 3，分类讨论：
如果 (x+c)/n = 1，那么答案在 4,5,6 (+c) 中。
如果 (x+c)/n = 0，那么答案在 1,2,3 (+c) 中。
重复上述过程，根据 (x+c)/n 的值来二分，直到答案唯一。
动手玩一玩！可以发现，按照上述过程，n-1-n%m 一定不会是 0。
写法一 https://codeforces.com/contest/1624/submission/283752123
写法二 https://codeforces.com/contest/1624/submission/283753298
库函数二分 https://codeforces.com/contest/1624/submission/283753649
======

Input
3

1
Output
+ 1

! 3

Input
5

0

0

1
Output
+ 1

+ 1

+ 1

! 5

Input
10

0

0

1

2
Output

+ 2

+ 2

+ 3

+ 8

! 20
 */
