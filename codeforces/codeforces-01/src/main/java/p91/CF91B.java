package p91;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CF91B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] ans = new int[n];
        ans[n - 1] = -1;

        List<Integer> st = new ArrayList<>();
        st.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int v = a[i];
            int j = sortSearch(st.size(), (m) -> a[st.get(m)] < v);
            if (j < st.size()) {
                ans[i] = st.get(j) - i - 1;
            } else {
                ans[i] = -1;
            }
            if (v < a[st.getLast()]) {
                st.add(i);
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

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
B. Queue
https://codeforces.com/contest/91/problem/B

灵茶の试炼 2024-01-23
题目大意：
输入 n(2≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
对于每个 i，输出 j-i-1 的最大值，其中 j 满足 j>i 且 a[j]<a[i]。如果不存在这样的 j，输出 -1。

rating 1500
倒着遍历 a，用一个单调栈记录历史最小值，也就是遇到比栈顶小的数，就把它的下标入栈。
然后在单调栈上二分，找比 a[i] 小的最右的 a[j]。
https://codeforces.com/problemset/submission/91/242886763
======

input
6
10 8 5 3 50 45
output
2 1 0 -1 0 -1

input
7
10 4 6 3 2 8 15
output
4 2 1 0 -1 -1 -1

input
5
10 3 1 10 11
output
1 0 -1 -1 -1
 */
