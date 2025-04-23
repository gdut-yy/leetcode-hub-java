package aising2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class Aising2020_e {
    public static void main(String[] args) {
        V1.main(null);
//        V2.main(null);
//        V3.main(null);
    }

    static class V1 {
        static Scanner scanner = new Scanner(System.in);
        static int n;
        static List<Integer>[] a, b;
        static long ans;

        public static void main(String[] args) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                n = scanner.nextInt();
                a = new ArrayList[n + 1];
                b = new ArrayList[n + 1];
                Arrays.setAll(a, e -> new ArrayList<>());
                Arrays.setAll(b, e -> new ArrayList<>());
                ans = 0;
                for (int i = 0; i < n; i++) {
                    int k = scanner.nextInt();
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    if (l > r) {
                        ans += r;
                        a[k].add(l - r);
                    } else {
                        ans += l;
                        b[n - k].add(r - l);
                    }
                }
                f(a);
                f(b);
                System.out.println(ans);
            }
        }

        static void f(List<Integer>[] a) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int k = 0; k < a.length; k++) {
                List<Integer> ds = a[k];
                for (Integer d : ds) {
                    ans += d;
                    pq.add(d);
                    if (pq.size() > k) {
                        ans -= pq.remove();
                    }
                }
            }
        }
    }

    static class V2 {
        static Scanner scanner = new Scanner(System.in);
        static int n;

        record pair(int k, int d) {
        }

        static List<pair> a, b;
        static long ans;

        public static void main(String[] args) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                n = scanner.nextInt();
                a = new ArrayList<>();
                b = new ArrayList<>();
                ans = 0;
                for (int i = 0; i < n; i++) {
                    int k = scanner.nextInt();
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    if (l > r) {
                        ans += r;
                        a.add(new pair(k, l - r));
                    } else {
                        ans += l;
                        b.add(new pair(n - k, r - l));
                    }
                }
                f(a);
                f(b);
                System.out.println(ans);
            }
        }

        static void f(List<pair> a) {
            TreeSet<Integer> t = new TreeSet<>();
            for (int i = 1; i <= n; i++) {
                t.add(i);
            }
            a.sort(Comparator.comparingInt(o -> -o.d));
            for (pair p : a) {
                // o := t.kth(t.upperBoundIndex(p.k) - 1)
                Integer o = t.floor(p.k);
                if (o != null) {
                    ans += p.d;
                    t.remove(o);
                }
            }
        }
    }

    static class V3 {
        static Scanner scanner = new Scanner(System.in);
        static int n;

        record pair(int k, int d) {
        }

        static List<pair> a, b;
        static long ans;

        public static void main(String[] args) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                n = scanner.nextInt();
                a = new ArrayList<>();
                b = new ArrayList<>();
                ans = 0;
                for (int i = 0; i < n; i++) {
                    int k = scanner.nextInt();
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    if (l > r) {
                        ans += r;
                        a.add(new pair(k, l - r));
                    } else {
                        ans += l;
                        b.add(new pair(n - k, r - l));
                    }
                }
                f(a);
                f(b);
                System.out.println(ans);
            }
        }

        static void f(List<pair> a) {
            a.sort(Comparator.comparingInt(o -> -o.d));
            DSU dsu = new DSU(n + 1);
            for (pair p : a) {
                int i = dsu.find(p.k);
                if (i > 0) {
                    ans += p.d;
                    dsu.union(i, i - 1);
                }
            }
        }

        static class DSU {
            int[] fa;

            public DSU(int n) {
                fa = new int[n];
                for (int i = 0; i < n; i++) fa[i] = i;
            }

            int find(int x) { // 查找
                return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
            }

            void union(int p, int q) { // 合并
                p = find(p);
                q = find(q);
                if (p == q) return;
                fa[p] = q;
            }
        }

    }
}
/*
E - Camel Train
https://atcoder.jp/contests/aising2020/tasks/aising2020_e

灵茶の试炼 2025-01-31
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5)。然后输入 n 行，每行输入三个数 ki(1≤ki≤n) li(1≤li≤1e9) ri(1≤ri≤1e9)。
有 n 只骆驼，你需要把这 n 只骆驼按照某种顺序，排成一行。
如果第 i 只骆驼在前 ki 个位置中，那么它的幸福值是 li，否则是 ri。
输出总幸福值的最大值。
本题简单版本：P2949 [USACO09OPEN] Work Scheduling G
https://www.luogu.com.cn/problem/P2949

初步分析
l > r 的骆驼放在 l < r 的骆驼的左边是更优的（可以用交换法证明）。
所以把 l > r 的骆驼分成一组，其余骆驼分成另一组，两组互相独立，分别计算。
下面只讨论 l > r 的情况。
我们可以先把所有 r 加起来，然后讨论 l-r 怎么选取。
如果没法把骆驼放在前 k 个中，那么幸福值只能是 r，这相当于不选 l-r。
方法一：反悔贪心（反悔堆）
按照 k 从小到大排序。
采取「捡到西瓜，丢掉芝麻」的反悔贪心策略：
先把 l-r 入堆（最小堆），如果入堆后发现堆的大小超过当前的 k，则弹出堆顶的「芝麻」。
注意用 64 位整数。
方法一 https://atcoder.jp/contests/aising2020/submissions/62166403
方法二：有序集合
按照 l-r 从大到小排序。
最大的 l-r 肯定是要选的，为了能让其他 l-r 有位置放，最大的 l-r 放的位置越靠右越好，那就放在第 k 个位置。
一般地，用一个有序集合维护空位。
每次找到 <= k 的最大空位，放置骆驼，然后从有序集合中删除这个位置。
如果没有 <= k 的空位，就不放骆驼。
方法二 https://atcoder.jp/contests/aising2020/submissions/62166831
方法三：并查集
把方法二的有序集合改成用并查集维护。删除一个数就相当于把 i 指向 i-1。这样 find(i) 就是 <= i 的最大空位。
方法三 https://atcoder.jp/contests/aising2020/submissions/62226484
======

Input 1
3
2
1 5 10
2 15 5
3
2 93 78
1 71 59
3 57 96
19
19 23 16
5 90 13
12 85 70
19 67 78
12 16 60
18 48 28
5 4 24
12 97 97
4 57 87
19 91 74
18 100 76
7 86 46
9 100 57
3 76 73
6 84 93
1 6 84
11 75 94
19 15 3
12 11 34
Output 1
25
221
1354
 */