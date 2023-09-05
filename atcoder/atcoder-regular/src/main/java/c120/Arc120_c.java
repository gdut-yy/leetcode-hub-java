package c120;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Arc120_c {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = 0; i < n; i++) {
            a[i] += i;
            b[i] += i;
        }

        Map<Integer, Deque<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMap.computeIfAbsent(a[i], key -> new ArrayDeque<>()).add(i);
        }

        long res = 0;
        Fenwick fenwick = new Fenwick(n);
        for (int i = 0; i < n; i++) {
            int v = b[i];
            Deque<Integer> p = posMap.getOrDefault(v, new ArrayDeque<>());
            if (p == null || p.isEmpty()) {
                return "-1";
            }
            int j = p.remove();
            res += i - fenwick.getSum(j);
            fenwick.add(j + 1, 1);
        }
        return String.valueOf(res);
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
C - Swaps 2
https://atcoder.jp/contests/arc120/tasks/arc120_c

灵茶の试炼 2022-11-23
题目大意：
输入 n(≤2e5) 和两个长为 n 的数组 a b，元素范围在 [0,1e9]。
每次操作你可以选择 a 中的两个相邻数字，设 x=a[i], y=a[i+1]，更新 a[i]=y+1, a[i+1]=x-1。
输出把 a 变成 b 的最小操作次数，如果无法做到则输出 -1。

https://atcoder.jp/contests/arc120/submissions/36718795
手玩一下可以发现，a[i] 左移 i 位就 +i，右移 i 位就 -i。
设 a[i] 最终和 b[j] 匹配，则有 a[i]+i-j=b[j]。
移项得 a[i]+i = b[j]+j。
设 a'[i] = a[i]+i，b'[i] = b[i]+i。
问题变成把 a' 通过邻项交换变成数组 b'，需要的最小操作次数。
这可以用树状数组解决，具体见代码。
======

Input 1
3
3 1 4
6 2 0
Output 1
2

Input 2
3
1 1 1
1 1 2
Output 2
-1

Input 3
5
5 4 1 3 2
5 4 1 3 2
Output 3
0

Input 4
6
8 5 4 7 4 5
10 5 6 7 4 1
Output 4
7
 */