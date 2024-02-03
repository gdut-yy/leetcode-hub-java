package p1907;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1907F {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n * 2];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final int INF = (int) 1e6;

    private static String solve() {
        // a = list(reversed(a))*2
        for (int l = 0, r = n - 1; l < r; l++, r--) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
        for (int i = n; i < n * 2; i++) {
            a[i] = a[i - n];
        }

        List<Integer> p = new ArrayList<>();
        p.add(0);
        List<Integer> q = new ArrayList<>();
        q.add(0);
        for (int i = 0; i < n * 2 - 1; i++) {
            if (a[i] >= a[i + 1]) p.add(p.get(p.size() - 1) + 1);
            else p.add(0);

            if (a[i] <= a[i + 1]) q.add(q.get(q.size() - 1) + 1);
            else q.add(0);
        }

        int min = INF;
        int pLen = p.size(); // n*2
        for (int i = n - 1; i < pLen; i++) {
            if (p.get(i) == n - 1) min = Math.min(min, Math.min(i - n + 1, pLen - i + 1));

            if (q.get(i) == n - 1) min = Math.min(min, Math.min(pLen - i, i - n + 2));
        }
        long ans = min == INF ? -1 : min;
        return String.valueOf(ans);
    }
}
/*
F. Shift and Reverse
https://codeforces.com/contest/1907/problem/F

题目大意：
给定一个整数数组 a1,a2,...,an。你可以用这个数组做两种类型的操作:
Shift:将数组的最后一个元素移到第一个位置，并将所有其他元素移到右边，因此您得到数组 an,a1,a2,...,an-1。
Reverse:反转整个数组，所以你得到数组 an,an-1,...,a1。
您的任务是使用最少的操作以非递减顺序对数组进行排序，或者说这是不可能的。

rating 1800
https://codeforces.com/blog/entry/123012
在这个问题中，有几个可能的行动序列，必须从中选择最优的一个。为简洁起见，我们用字母“R”表示反向，用字母“S”表示移位:
- SS…SS
- RS…SR
- RS…SS
- SS…SR
让我们把这个数组写两次，并计算它增加和减少的片段。这样，我们就可以找到所有可能的移位来对数组进行排序。
======

input
11
5
3 2 1 5 4
5
1 1 2 1 1
4
3 7 10 5
5
1 2 3 4 5
2
5 1
3
3 4 1
5
4 1 3 4 4
3
5 1 1
4
2 5 5 4
5
2 2 1 1 2
2
5 5
output
3
2
-1
0
1
1
3
1
2
2
0
 */
