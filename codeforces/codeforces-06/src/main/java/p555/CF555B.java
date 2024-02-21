package p555;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF555B {
    static int n, m;
    static long ll, rr, l, r;
    static Tuple[] b;
    static Pair[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ll = scanner.nextLong();
        rr = scanner.nextLong();

        b = new Tuple[n - 1];
        for (int i = 0; i < n - 1; i++) {
            l = scanner.nextLong();
            r = scanner.nextLong();
            b[i] = new Tuple(l - rr, r - ll, i);
            ll = l;
            rr = r;
        }

        a = new Pair[m];
        for (int i = 0; i < m; i++) {
            long x = scanner.nextLong();
            a[i] = new Pair(x, i + 1);
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(b, Comparator.comparingLong(o -> o.l));
        Arrays.sort(a, Comparator.comparingLong(o -> o.x));

        int[] ans = new int[n - 1];
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingLong(o -> o.x));
        int j = 0;
        for (Pair p : a) {
            while (j < n - 1 && b[j].l <= p.x) {
                heap.add(new Pair(b[j].r, b[j].i));
                j++;
            }
            if (!heap.isEmpty()) {
                if (heap.peek().x < p.x) {
                    break;
                }
                ans[heap.remove().i] = p.i;
            }
        }

        if (!heap.isEmpty() || j < n - 1) {
            return "No";
        }
        return "Yes" + System.lineSeparator() +
                Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static class Tuple {
        long l, r;
        int i;

        public Tuple(long l, long r, int i) {
            this.l = l;
            this.r = r;
            this.i = i;
        }
    }

    static class Pair {
        long x;
        int i;

        public Pair(long x, int i) {
            this.x = x;
            this.i = i;
        }
    }
}
/*
B. Case of Fugitive
https://codeforces.com/contest/555/problem/B

灵茶の试炼 2022-09-22
题目大意：
输入 n(2≤n≤2e5) 和 m(1≤m≤2e5)，然后输入 n 行，每行有两个数，表示一个闭区间（1≤L≤R≤1e18），然后输入一个长为 m 的数组 a (1≤a[i]≤1e18)。输入保证区间之间没有交集，且上一个区间的右端点小于下一个区间的左端点。
你有 m 座桥，每座桥的长为 a[i]，你需要选择 n-1 座桥连接所有相邻的区间。
要求桥的两个端点分别落在这两个闭区间内（这两个端点的差等于桥长）。
如果无法做到，输出 No；否则输出 Yes，然后按顺序输出这 n-1 座桥的编号（编号从 1 开始），输出的第一座桥连接第一个区间和第二个区间，输出的第二座桥连接第二个区间和第三个区间，依此类推。
思考：如果不要求连接的两个区间相邻，你能否连通所有区间？
本题算作区间与点的最大匹配/覆盖问题
类似的还有 https://www.luogu.com.cn/problem/P2887

rating 2000
https://codeforces.com/problemset/submission/555/173027350
方法一：
提示 1：转换成每对相邻区间，能放下的桥的长度的范围，记到一个数组 b 中。
提示 2：从小到大排序 a 和 b，其中 b 按照左端点排序。
提示 3：遍历 a，对于 b 中范围左端点在 a[i] 左边且没有使用过的范围，从中选出右端点最小且 ≥a[i] 的范围。
提示 4：用最小堆模拟。
方法二：
b 按照右端点排序，然后遍历 b，维护 a[i]<=右端点的 a[i]，每次取 >=左端点的最小的 a[i]，这可以用平衡树实现。
======

input
4 4
1 4
7 8
9 10
12 14
4 5 3 8
output
Yes
2 3 1

input
2 2
11 14
17 18
2 9
output
No

input
2 1
1 1
1000000000000000000 1000000000000000000
999999999999999999
output
Yes
1
 */
