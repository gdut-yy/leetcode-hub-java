package c372;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc372_d {
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
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = st.size();
            int v = a[i];
            while (!st.isEmpty() && v > a[st.peek()]) {
                st.pop();
            }
            st.push(i);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D - Buildings
https://atcoder.jp/contests/abc372/tasks/abc372_d

灵茶の试炼 2025-04-14
题目大意：
输入 n(1≤n≤2e5) 和一个 1~n 的排列 a。下标从 1 开始。
有 n 幢楼房，高度从左到右记录在 a 中。
定义 f(i) 表示 j 的个数，满足 i<j<=n 且在 [i+1,j-1] 中没有比 j 高的楼房。
输出 f(1),f(2),...,f(n)。

遍历到 a[i] 时，由于 a[i] 的出现，a[i] 右边所有比 a[i] 小的数，都无法作为答案。
这启发我们用（底大顶小的）单调栈。遇到更大元素，就把栈顶出栈。
倒序遍历，遍历到 a[i] 之前，ans[i] 就是栈的大小。
代码 https://atcoder.jp/contests/abc372/submissions/64670948
======

Input 1
5
2 1 4 3 5
Output 1
3 2 2 1 0

Input 2
4
1 2 3 4
Output 2
3 2 1 0

Input 3
10
1 9 6 5 2 7 10 4 8 3
Output 3
2 3 3 3 2 1 2 1 1 0
 */
