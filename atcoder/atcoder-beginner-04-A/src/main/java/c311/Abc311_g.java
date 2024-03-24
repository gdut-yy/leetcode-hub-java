package c311;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Abc311_g {
    static int n, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long[] ps = new long[m + 1];
            int[] mn = new int[m];
            System.arraycopy(a[i], 0, mn, 0, m);
            for (int up = i; up >= 0; up--) {
                int s = 0;
                for (int j = 0; j < m; j++) {
                    int v = a[up][j];
                    mn[j] = Math.min(mn[j], v);
                    s += v;
                    ps[j + 1] += s;
                }

                // same as solution1856
                int[] L = new int[m];
                int[] R = new int[m];
                Deque<Integer> st = new ArrayDeque<>();
                st.push(-1); // 哨兵
                for (int j = 0; j < m; j++) {
                    while (st.size() > 1 && mn[j] <= mn[st.peek()]) st.pop();
                    L[j] = st.peek() + 1;
                    st.push(j);
                }

                st.clear();
                st.push(m);
                for (int j = m - 1; j >= 0; j--) {
                    while (st.size() > 1 && mn[j] < mn[st.peek()]) st.pop();
                    R[j] = st.peek() - 1;
                    st.push(j);
                }

                for (int j = 0; j < m; j++) {
                    ans = Math.max(ans, (ps[R[j] + 1] - ps[L[j]]) * mn[j]);
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
G - One More Grid Task
https://atcoder.jp/contests/abc311/tasks/abc311_g

灵茶の试炼 2023-10-13
题目大意：
输入 n m(1≤n,m≤300) 和 n 行 m 列的矩阵 A，元素范围 [1,300]。
对于 A 的一个非空子矩阵 R，定义 f(R) = 子矩阵的元素和 * 子矩阵的最小值。
输出 f(R) 的最大值。

枚举子矩形的上下边界。
把子矩形【每一列的元素和】以及【每一列的最小值】求出来，就变成一维问题了。
这题就是 1856. 子数组最小乘积的最大值
从大往小枚举子数组的最小值，子数组的左右边界不能超出左右最近比最小值还小的数。
https://atcoder.jp/contests/abc311/submissions/46473973
======

Input 1
3 3
5 4 3
4 3 2
3 2 1
Output 1
48

Input 2
4 5
3 1 4 1 5
9 2 6 5 3
5 8 9 7 9
3 2 3 8 4
Output 2
231

Input 3
6 6
1 300 300 300 300 300
300 1 300 300 300 300
300 300 1 300 300 300
300 300 300 1 300 300
300 300 300 300 1 300
300 300 300 300 300 1
Output 3
810000
 */