package p1118;

import java.util.Scanner;

public class CF1118E {
    static long m, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        if (n * (n - 1) < m) {
            return "NO";
        }

        StringBuilder ans = new StringBuilder("YES");
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                ans.append(System.lineSeparator()).append(i).append(" ").append(j);
                if (--m == 0) return ans.toString();
                ans.append(System.lineSeparator()).append(j).append(" ").append(i);
                if (--m == 0) return ans.toString();
            }
        }
        return ans.toString();
    }
}
/*
E. Yet Another Ball Problem
https://codeforces.com/contest/1118/problem/E

灵茶の试炼 2022-06-07
题目大意：
给你两个数 m 和 n（均在 [2,2e5] 范围内）
请你构造 m 个互不相同的 pair，需满足：
1. 每个 pair 包含两个在 [1,n] 内的不同整数。
2. 两个相邻的 pair，第一个数不能相同，第二个数也不能相同。
如果不能构造，输出 NO，否则输出 YES 和这 m 个 pair

rating 1700
https://codeforces.com/problemset/submission/1118/159687007
至多可以构造 n*(n-1) 个：
1 2
2 1
1 3
3 1
...
1 n
n 1
2 3
3 2
...
n-1 n
n n-1
======

input
4 3
output
YES
3 1
1 3
3 2
2 3

input
10 4
output
YES
2 1
1 3
4 2
3 4
4 3
3 2
2 4
4 1
1 4
3 1

input
13 4
output
NO
 */