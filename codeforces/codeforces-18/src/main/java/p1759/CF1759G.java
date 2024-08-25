package p1759;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CF1759G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] b = new int[n / 2];
            for (int i = 0; i < n / 2; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve1(n, b));
        }
    }

    private static String solve(int n, int[] b) {
        int[] a = new int[n];
        int[] pos = new int[n + 1];
        int j = 0;
        for (int i = 1; i < n; i += 2) {
            a[i] = b[j++];
            pos[a[i]] = i;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = n; i > 0; i--) {
            if (pos[i] > 0) {
                maxHeap.add(pos[i]);
            } else if (!maxHeap.isEmpty()) {
                int pop = maxHeap.remove();
                a[pop - 1] = i;
            } else {
                return "-1";
            }
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    // 贪心 + 并查集
    private static String solve1(int n, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int x : b) {
            set.add(x);
        }
        // 是排列，有相同数字肯定不行
        if (set.size() * 2 != n) return "-1";
        if (set.contains(1) || !set.contains(n)) return "-1";

        DSU dsu = new DSU(n + 1);
        for (int v : b) {
            dsu.union(v - 1, v);
        }
        int[] p = new int[n];
        int j = 0;
        for (int i = 1; i < n; i += 2) {
            p[i] = b[j++];
        }
        for (int i = n - 2; i > -2; i -= 2) {
            int v = dsu.find(p[i + 1]);
            if (v == 0) {
                return "-1";
            }
            dsu.union(v - 1, v);
            p[i] = v;
        }
        return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }
}
/*
G. Restore the Permutation
https://codeforces.com/contest/1759/problem/G

灵茶の试炼 2023-05-18
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入偶数 n(2≤n≤2e5) 和长为 n/2 的数组 b(1≤b[i]≤n)，下标从 1 开始。
构造一个长为 n 的 1~n 的排列 p（下标从 1 开始），满足 max(p[2*i-1],p[2*i]) = b[i]。
如果无法构造，输出 -1，否则输出字典序最小的 p。

rating 1900
https://codeforces.com/problemset/submission/1759/206226901
正难则反。
从大往小填数字。
例如最后一个样例，先填 6，必须和 8 或者 7 在一起，越靠后越好。
这意味着我们需要用一个最大堆去维护 b[i] 的下标，每次取堆顶下标减一的位置填数。
---
题目实际要求答案排列：每两个一组，分 n/2 组；从头数每组取 max=b[i]。那这俩数里必有一个 b[i] 有一个小于 b[i] 的数 x.
  - 由于要字典序最小，我们选择把 x 放 b[i] 前边。则 p[1::2]=b，即把 b[i] 填到每组的第二个位置上。
从上边的讨论可以看出，如果 b 中有 1，那无法构造答案（1 和谁一组都不能是 1）；如果没有 n，也无法构造。（n 和谁一组都是 n）；
  - case 是很良心的，发现 b 中有重复数据也无法构造。
每个数只能分配比它小的数，为了使字典序最小，那么给靠前的数直接分配最小数 1 吗。这可能导致给前边的 n 分配了 1，后边的 2 无法分配。
  - 尽可能完成构造的贪心策略：对于数字 b[i] 分配一个比它小的最大数。若没有比它小的数则返回 -1.
由于我们优先分配大数，因此倒序处理。
为了寻找小于 b 的最大数，用并查集，用掉一个数字 v 就连接(v,v-1)。这样比 v 小的最大数就是 findFa(v)。（左边最靠近 v 的数字）
======

input
6
6
4 3 6
4
2 4
8
8 7 2 3
6
6 4 2
4
4 4
8
8 7 4 5
output
1 4 2 3 5 6
1 2 3 4
-1
5 6 3 4 1 2
-1
1 8 6 7 2 4 3 5
 */

