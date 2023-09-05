package jsc2021;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Jsc2021_f {
    static int n, m, q;
    static int[][] qs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        qs = new int[q][3];
        for (int i = 0; i < q; i++) {
            qs[i][0] = scanner.nextInt();
            qs[i][1] = scanner.nextInt();
            qs[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static int[] d;

    private static String solve() {
        d = new int[q + 1];
        for (int i = 0; i < q; i++) {
            d[i] = qs[i][2];
        }
        Arrays.sort(d);
        int k = 0;
        for (int i = 1; i <= q; i++) {
            int w = d[i];
            if (d[k] != w) {
                k++;
                d[k] = w;
            }
        }
        d = Arrays.copyOfRange(d, 0, k + 1);

        int[][] ab = new int[2][];
        ab[0] = new int[n + 1];
        ab[1] = new int[m + 1];
        Fenwick[] sum = new Fenwick[2];
        sum[0] = new Fenwick(k + 3);
        sum[1] = new Fenwick(k + 3);
        Fenwick[] cnt = new Fenwick[2];
        cnt[0] = new Fenwick(k + 3);
        cnt[1] = new Fenwick(k + 3);
        cnt[0].add(1, n);
        cnt[1].add(1, m);

        long[] output = new long[q];
        long ans = 0;
        for (int qi = 0; qi < q; qi++) {
            int op = qs[qi][0] - 1, i = qs[qi][1], x = qs[qi][2];
            int[] a = ab[op];
            int old = a[i];
            a[i] = x;
            int pre = searchInts(d, old) + 2;
            int cur = searchInts(d, x) + 2;
            ans -= (long) cnt[op ^ 1].getSum(pre) * old - sum[op ^ 1].getSum(pre);
            ans += (long) cnt[op ^ 1].getSum(cur) * x - sum[op ^ 1].getSum(cur);
            cnt[op].add(pre, -1);
            cnt[op].add(cur, 1);
            sum[op].add(pre, -old);
            sum[op].add(cur, x);
            output[qi] = ans;
        }
        return Arrays.stream(output).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static int searchInts(int[] a, int key) {
        int left = 0;
        int right = a.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (a[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static class Fenwick {
        private final int n;
        private final long[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new long[n + 1];
        }

        int lowbit(int x) {
            return x & -x;
        }

        // nums[x] add k
        void add(int x, long k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        long getSum(int x) {
            long ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
F - Max Matrix
https://atcoder.jp/contests/jsc2021/tasks/jsc2021_f

灵茶の试炼 2022-11-04
题目大意：
输入 n m q (≤2e5)，初始你有长为 n 的数组 a，长为 m 的数组 b，元素值都为 0，下标从 1 开始。
然后输入 q 个询问，每个询问形如 t x y (1≤y≤1e8)。
t=1，表示把 a[x]=y；t=2，表示把 b[x]=y。
每次修改后，输出 ∑∑max(a[i],b[j])，这里 i 取遍 [1,n]，j 取遍 [1,m]。

https://atcoder.jp/contests/jsc2021/submissions/36189511
https://atcoder.jp/contests/jsc2021/submissions/36189772
提示 1：元素的顺序并没有那么重要。
提示 2：每次修改时，只需要知道另一个数组中，有多少个数比自己小（这些数的个数乘上自己），以及≥自己的数的和是多少。
最好写的应该是离散化+树状数组。
注意把 0 也加到离散化中。
======

Input 1
2 2 4
1 1 10
2 1 20
2 2 5
1 1 30
Output 1
20
50
55
85

Input 2
3 3 5
1 3 10
2 1 7
1 3 5
2 2 10
2 1 1
Output 2
30
44
31
56
42

Input 3
200000 200000 4
2 112219 100000000
1 73821 100000000
2 26402 100000000
1 73821 100000000
Output 3
20000000000000
39999900000000
59999800000000
59999800000000
 */