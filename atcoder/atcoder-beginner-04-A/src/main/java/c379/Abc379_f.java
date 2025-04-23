package c379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc379_f {
    static int n, q;
    static int[] a;
    static List<pair>[] ls;

    record pair(int r, int i) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        ls = new ArrayList[n];
        Arrays.setAll(ls, e -> new ArrayList<>());
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            ls[l].add(new pair(r - 1, i));
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] ans = new int[q];
        List<Integer> st = new ArrayList<>();
        for (int i = n - 1; i > 0; i--) {
            int v = a[i];
            while (!st.isEmpty() && v > a[-st.get(st.size() - 1)]) {
                st.remove(st.size() - 1);
            }
            st.add(-i);
            for (pair p : ls[i]) {
                ans[p.i] = searchInts(st, -p.r);
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static int searchInts(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
F - Buildings 2
https://atcoder.jp/contests/abc379/tasks/abc379_f

灵茶の试炼 2025-01-16
题目大意：
输入 n(2≤n≤2e5) q(1≤q≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)，所有元素互不相同，下标从 1 开始。
然后输入 q 个询问，每个询问输入两个数 L 和 R (1≤L≤R≤n)。
有 n 栋建筑物，第 i 栋建筑物的高度是 a[i]。
如果下标在 [i+1,j-1] 中的建筑物高度都 <= a[j]，那么在 i 能看到 j (i < j)。
对于每个询问，输出：在 L 和 R 都能看到的、下标在 [R+1,n] 中的建筑物的数量。

离线，把询问按照左端点分组。
从右到左遍历 a，如果当前 a[i] 比右边的数 x 大，那么 x 在后续遍历中必然无法被看见。这启发我们用单调栈解决。
单调栈保存的是下标。由于我们是倒着遍历的，所以栈是底大顶小的。
在单调栈上二分下标 > r 的下标个数，即为能看到的建筑物的个数。
小技巧：为方便调用库函数，可以在单调栈中保存下标的相反数。
代码 https://atcoder.jp/contests/abc379/submissions/61518172
======

Input 1
5 3
2 1 4 3 5
1 2
3 5
1 4
Output 1
2
0
1

Input 2
10 10
2 1 5 3 4 6 9 8 7 10
3 9
2 5
4 8
5 6
3 8
2 10
7 8
6 7
8 10
4 10
Output 2
1
3
1
2
1
0
1
1
0
0
 */
