package p2037;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF2037C {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (n < 5) return "-1";

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i += 2) {
            if (i != 5) ans.add(i);
        }
        ans.add(5);
        ans.add(4);
        for (int i = 2; i <= n; i += 2) {
            if (i != 4) ans.add(i);
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Superultra's Favorite Permutation
https://codeforces.com/contest/2037/problem/C

灵茶の试炼 2025-01-27
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5)。
构造一个 1~n 的排列，满足任意相邻两数之和都是合数。
如果无法构造，输出 -1。

rating 1000
核心思路：除了 2 以外的偶数都是合数。由于我们无法构造出 2，相邻元素之和只要是偶数，那么一定是合数。
奇数+奇数=偶数，偶数+偶数=偶数。
所以把奇数放在一起，把偶数放在一起。
唯一需要注意的是奇偶交界的位置，是奇数+偶数。
最小的奇合数是 9。
满足 奇数+偶数=奇合数 的最小数对是 5+4。
所以 n<5 直接输出 -1。
否则答案存在，按顺序输出以下内容：
1~n 中的除了 5 以外的奇数。
5 和 4。
1~n 中的除了 4 以外的偶数。
代码 https://codeforces.com/contest/2037/submission/302683362
代码备份（洛谷）
======

Input
2
3
8
Output
-1
1 8 7 3 6 2 4 5
 */
