package p2042;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2042C {
    static int n, k;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Integer> a = new ArrayList<>();
        int sum = 0;
        for (int i = n - 1; i > 0; i--) {
            sum += s[i] == '0' ? -1 : 1;
            if (sum > 0) {
                a.add(sum);
            }
        }
        a.sort(null);

        int ans = 1;
        for (int i = a.size() - 1; i >= 0 && k > 0; i--) {
            k -= a.get(i);
            ans++;
        }
        if (k > 0) {
            ans = -1;
        }
        return String.valueOf(ans);
    }
}
/*
C. Competitive Fishing
https://codeforces.com/contest/2042/problem/C

灵茶の试炼 2024-12-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) k(1≤k≤1e9) 和长为 n 的 01 字符串 s。
有 n 条鱼排成一排，其中 s[i]=0 表示第 i 条鱼是 Alice 的，s[i]=1 表示第 i 条鱼是 Bob 的。
你需要把 s 分割成若干个非空段。第一段所有鱼的价值是 0，第二段所有鱼的价值是 1，第三段所有鱼的价值是 2，依此类推。
最少分成多少段，可以让 (Bob 的鱼的价值之和) - (Alice 的鱼的价值之和) >= k？
如果无法做到，输出 -1。

rating 1800
假设你得到了一个具体的分割方案，如果在此方案上再切一刀，这一刀应该切在哪？
把 '0' 的价值视作 -i，'1' 的价值视作 i。
对于这一刀左边的鱼，价值不变。
对于这一刀右边的鱼，每条 '0' 鱼的价值都减少了 1，每条 '1' 鱼的价值都增加了 1。
要想让 Bob 和 Alice 的价值差尽量大，计算 s 的真后缀和（'0' 视作 -1，'1' 视作 1），其中最大的正后缀和，就对应着我们要切的那一刀。（如果这里已经切过了，就找次小的，依此类推。）
注：真后缀表示不等于 s 的后缀。因为 s 的所有元素和对应着在 s[0] 左边切一刀，但题目要求第一段不能是空的。
计算真后缀和，把其中的正数从大到小排序，然后不断地从 k 中减去，直到 k <= 0 为止。
如果遍历结束后 k > 0，输出 -1。
代码 https://codeforces.com/problemset/submission/2042/297787447
代码备份（洛谷）
======

Input
7
4 1
1001
4 1
1010
4 1
0110
4 2
0110
6 3
001110
10 20
1111111111
5 11
11111
Output
2
-1
2
-1
3
4
-1
 */
