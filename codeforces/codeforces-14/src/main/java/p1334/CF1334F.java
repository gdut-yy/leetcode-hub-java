package p1334;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1334F {
    static int n, m;
    static int[] a, cost, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final long INF = (long) 1e18;

    private static String solve() {
        List<Integer>[] pos = new ArrayList[n + 1];
        Arrays.setAll(pos, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            pos[a[i]].add(i);
        }
        long[] negSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            negSum[i + 1] = negSum[i];
            if (cost[i] < 0) {
                negSum[i + 1] += cost[i];
            }
        }

        BIT tr = new BIT(n);
        long[] f = new long[n];
        Arrays.fill(f, INF);
        long s = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > b[0]) {
                if (cost[i] > 0) {
                    tr.update(i, cost[i]);
                }
            } else if (a[i] == b[0]) {
                f[i] = s;
            }
            s += cost[i];
        }

        int pid = 1;
        while (pid <= b[0]) {
            pid++;
        }

        for (int bi = 1; bi < m; bi++) {
            List<Integer> p = pos[b[bi - 1]];
            int j = 0;
            long mn = INF;
            int pre = -1;
            for (Integer i : pos[b[bi]]) {
                if (pre >= 0) {
                    mn += tr.query(pre, i - 1) + negSum[i] - negSum[pre];
                }
                while (j < p.size() && p.get(j) < i) {
                    long res = f[p.get(j)] + tr.query(p.get(j) + 1, i - 1) + negSum[i] - negSum[p.get(j) + 1];
                    mn = Math.min(mn, res);
                    j++;
                }
                f[i] = mn;
                pre = i;
            }
            while (pid <= b[bi]) {
                for (Integer i : pos[pid]) {
                    if (cost[i] > 0) {
                        tr.update(i, -cost[i]);
                    }
                }
                pid++;
            }
        }

        long ans = INF;
        s = 0;
        for (int i = n - 1; i >= 0; i--) {
            int v = a[i];
            if (v == b[m - 1]) {
                ans = Math.min(ans, f[i] + s);
            }
            if (v > b[m - 1] || cost[i] < 0) {
                s += cost[i];
            }
        }
        if (ans >= 1e17) return "NO";
        return "YES" + System.lineSeparator() + ans;
    }

    static class BIT {
        int n;
        long[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void update(int pos, int val) {
            for (pos++; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        long pre(int pos) {
            long ret = 0;
            for (pos++; pos > 0; pos -= lb(pos)) ret += tree[pos];
//            for (pos++; pos > 0; pos &= pos - 1) ret += tree[pos];
            return ret;
        }

        long query(int l, int r) {
            return pre(r) - pre(l - 1);
        }
    }
}
/*
F. Strange Function
https://codeforces.com/contest/1334/problem/F

灵茶の试炼 2023-12-22
题目大意：
输入 n(1≤n≤5e5)，长为 n 的数组 a(1≤a[i]≤n)，长为 n 的数组 cost(-1e9≤cost[i]≤1e9)。
然后输入 m(1≤m≤n) 和长为 m 的严格递增数组 b(1≤b[i]≤n)。
定义 record(arr) 是 arr 的一个严格递增子序列，它的构造过程如下：
首先初始化子序列为 [arr[0]]。
继续向后遍历，如果 arr[i] 比子序列的最后一个数大，就加到子序列的末尾。
例如 record([3,1,2,7,7,3,6,7,8]) = [3,7,8]。
你可以删除 a 的一些数，删除 a[i] 的花费是 cost[i]。
你需要让 record(a) 等于 b。
如果无法做到，输出 NO；否则输出 YES 和最小花费。

rating 2500
考虑需要删除哪些数。
看示例 1 来启发思考。最后一个数是 10，它的下标是 i，那么 i 右边比 10 大的数都需要删除。
枚举倒数第二个数 7 的位置 j，那么从 j 到 i 之间的比 7 大的数都需要删除。
对于 7 又需要枚举 3 的位置，以此类推。
这说明：
1. 需要用到 DP。
2. 需要用一个合适的数据结构，维护需要删除的数的 cost 之和，即在一个区间内的 a 值大于某个数的 cost 值之和。
定义 f[i] 表示 record 子序列的最后一个数是 a[i] 的最小代价和。如果 a[i] 不在 b 中则 f[i]=inf。
我的做法是按照 b 数组的顺序从小到大 DP：先把 a 中所有等于 b[0] 的 f 值算出来，然后把 a 中所有等于 b[1] 的 f 值算出来，……
在计算等于 b[j] 的 f 值时，可以用双指针遍历 a 中所有 b[j-1] 和 b[j] 的位置。
比如 b[j-1]=1, b[j]=3，a 数组是 1 9 1 9 3 9 1 9 1 9 3，那么第一个 3 的转移来源有两个 1：
· 第一个 1 的 f 值 + 从第一个 1 到第一个 3 之间大于 1 的数的 cost 和。
· 第二个 1 的 f 值 + 从第二个 1 到第一个 3 之间大于 1 的数的 cost 和。
这两个的最小值记作 mn。
那么第二个 3 呢？它也可以从前两个 1（以及其它的 1）转移过来，照这样算岂不是至少平方的复杂度了？
我们可以在 mn 的基础上，增加从第一个 3（包含）到第二个 3（不包含）之间的大于 1 的数的 cost 和，这样就直接得到了前两个 1 到第二个 3 的最小转移了。
计算 cost 和，可以用树状数组维护，随着 b[j] 的变大，要及时移除树状数组中的小于等于 b[j-1] 的 cost 和，这样计算出的大于 b[j-1] 的数的 cost 和才是正确的。
最后，在删除的过程中，如果数字的 cost 是负数，也可以删除。
可以单独用一个前缀和记录负数 cost。
https://codeforces.com/problemset/submission/1334/238277814
======

input
11
4 1 3 3 7 8 7 9 10 7 11
3 5 0 -2 5 3 6 7 8 2 4
3
3 7 10
output
YES
20

input
6
2 1 5 3 6 5
3 -9 0 16 22 -14
4
2 3 5 6
output
NO
 */
