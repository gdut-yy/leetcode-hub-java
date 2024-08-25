package p652;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CF652D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[][] lrs = new int[n][3];
        for (int i = 0; i < n; i++) {
            lrs[i][0] = scanner.nextInt();
            lrs[i][1] = scanner.nextInt();
            // 注意
            lrs[i][2] = i;
        }
        System.out.println(solve(n, lrs));
    }

    private static String solve(int n, int[][] lrs) {
        // 离散化
        int[] yArr = getDiscrete(lrs);
        for (int[] lr : lrs) {
            lr[0] = getId(yArr, lr[0]);
            lr[1] = getId(yArr, lr[1]);
        }
        Arrays.sort(lrs, Comparator.comparingInt(o -> o[1]));

        int[] ans = new int[n];
        Fenwick fenwick = new Fenwick(n * 2);
        for (int k = 0; k < n; k++) {
            int l = lrs[k][0];
            int i = lrs[k][2];

            ans[i] = k - fenwick.getSum(l);
            fenwick.add(l, 1);
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static int[] getDiscrete(int[][] lrs) {
        Set<Integer> set = new HashSet<>();
        for (int[] lr : lrs) {
            set.add(lr[0]);
            set.add(lr[1]);
        }
        int sz = set.size();
        int[] yArr = new int[sz];
        int id = 0;
        for (Integer x : set) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        return yArr;
    }

    private static int getId(int[] yArr, int x) {
        return Arrays.binarySearch(yArr, x) + 1;
    }

    private static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return x & -x;
        }

        public void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        public int getSum(int x) {
            int ans = 0;
            while (x >= 1) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
D. Nested Segments
https://codeforces.com/contest/652/problem/D

灵茶の试炼 2023-03-09
题目大意：
输入 n(≤2e5) 和 n 个闭区间，区间左右端点范围在 [-1e9,1e9]，所有端点互不相同。
对每个区间，输出它包含多少个其它的区间。

rating 1800
https://codeforces.com/contest/652/submission/122430936
离散化后，按照右端点排序。
对于每个区间 [left,right]，统计从 left 到 right 之间有多少个其余的左端点。
由于按照右端点排序，这些区间一定能包含。
统计后把 left 加到树状数组中。
太妙了！
======

input
4
1 8
2 3
4 7
5 6
output
3
0
1
0

input
3
3 4
1 5
2 6
output
0
1
1
 */
