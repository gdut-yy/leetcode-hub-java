package p2001;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2001D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] left = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            left[a[i]]++;
        }

        List<Integer> st = new ArrayList<>();
        boolean[] inStack = new boolean[n + 1];

        for (int v : a) {
            left[v]--;
            if (inStack[v]) {
                continue;
            }

            int m = st.size();
            while (m > 0 && left[st.get(m - 1)] > 0) {
                int top = st.get(m - 1);
                if (m % 2 != 0) {
                    if (v < top && (m == 1 || v > st.get(m - 2) || left[st.get(m - 2)] == 0)) {
                        break;
                    }
                } else {
                    if (v > top && (m == 1 || v < st.get(m - 2) || left[st.get(m - 2)] == 0)) {
                        break;
                    }
                }
                m--;
                inStack[st.remove(m)] = false;
            }
            st.add(v);
            inStack[v] = true;
        }

        out.println(st.size());
        for (int num : st) {
            out.print(num + " ");
        }
        out.println();
    }
}
/*
D. Longest Max Min Subsequence
https://codeforces.com/contest/2001/problem/D

灵茶の试炼 2025-08-07
题目大意：
输入 T(≤5e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(1≤n≤3e5) 和长为 n 的数组 a(1≤a[i]≤n)。
从 a 中选择一个子序列 b，满足：
1. b 包含 a 中的所有元素，无重复元素。（相当于把 a 去重）
2. （b 的下标从 1 开始）如果把 b 的奇数下标的元素乘以 -1，得到的新序列 c 的字典序是最小的。
输出 b 的长度，以及 b。

rating 1900
推荐先把 LC316. 去除重复字母 做了，本题是变形题。
题目的要求相当于，（从栈底开始）栈的第 1,3,5,... 个数是递减的，第 2,4,6,... 个数是递增的。
在比较当前元素 a[i] 与栈顶的大小关系时，即使不满足要求（无法弹出栈顶），我们还可以再往下看一眼，比较 a[i] 与栈顶下面那个数的大小，如果可以让字典序更小，那么栈顶和栈顶下面那个数都可以出栈。
这就是本题与 LC316 的区别，在 LC316 代码的基础上，额外增加一个 if else 的判断条件，对奇偶分类讨论，具体见代码。
代码 https://codeforces.com/problemset/submission/2001/332427520
代码备份（Ubuntu Pastebin）
======

Input
4
4
3 2 1 3
4
1 1 1 1
9
3 2 1 3 2 1 3 2 1
1
1
Output
3
3 2 1
1
1
3
3 1 2
1
1

Input
10
2
1 2
10
5 2 1 7 9 7 2 5 5 2
2
1 2
10
2 2 8 7 7 9 8 1 9 6
9
9 1 7 5 8 5 6 4 1
3
3 3 3
6
1 6 4 4 6 5
6
3 4 4 5 3 3
10
4 1 4 5 4 5 10 1 5 1
7
1 2 1 3 2 4 6
Output
2
1 2
5
5 1 9 7 2
2
1 2
6
2 7 9 8 1 6
7
9 1 7 5 8 6 4
1
3
4
1 4 6 5
3
4 5 3
4
5 4 10 1
5
2 1 3 4 6
 */
