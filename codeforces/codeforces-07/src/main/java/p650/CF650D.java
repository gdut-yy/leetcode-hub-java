package p650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF650D {
    static int n, m;
    static int[] a;
    static List<int[]>[] qs; // qid, v

    public static void main(String[] args) {
        // Time limit exceeded on test 110
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        qs = new ArrayList[n];
        Arrays.setAll(qs, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int j = scanner.nextInt();
            int v = scanner.nextInt();
            qs[j - 1].add(new int[]{i, v}); // 离线询问
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] ans = new int[m];

        int[] pre = new int[n];
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // different from CF486E
            for (int[] p : qs[i]) {
                ans[p[0]] = lowerBound(g, p[1]) + 1;
            }

            int v = a[i];
            int j = lowerBound(g, v);
            if (j == g.size()) g.add(v);
            else g.set(j, v);
            pre[i] = j + 1;
        }

        int[] suf = new int[n];
        g.clear();
        for (int i = n - 1; i >= 0; i--) {
            // different from CF486E
            for (int[] p : qs[i]) {
                // 累加后，我们得到了包含 a[i]=p.v 的 LIS 长度
                ans[p[0]] += lowerBound(g, -p[1]);
            }

            int v = -a[i];
            int j = lowerBound(g, v);
            if (j == g.size()) g.add(v);
            else g.set(j, v);
            suf[i] = j + 1;
        }

        // different from CF486E
        int lis = g.size();
        int[] cnt = new int[n + 1];
        for (int i = 0; i < pre.length; i++) {
            if (pre[i] + suf[i] - 1 == lis) {
                cnt[pre[i]]++;
            }
        }
        for (int i = 0; i < pre.length; i++) {
            // k 为不含 a[i] 的 LIS 长度
            int k = lis;
            if (pre[i] + suf[i] - 1 == lis && cnt[pre[i]] == 1) { // a[i] 在所有 LIS 中
                k--;
            }
            for (int[] p : qs[i]) {
                // 两种情况取最大值，即为最终答案
                ans[p[0]] = Math.max(ans[p[0]], k);
            }
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
D. Zip-line
https://codeforces.com/contest/650/problem/D

灵茶の试炼 2024-06-07
题目大意：
输入 n(1≤n≤4e5) m(1≤m≤4e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，数组下标从 1 开始。
然后输入 m 个询问，每个询问输入两个数 i(1≤i≤n) 和 b(1≤b≤1e9)。
对于每个询问，输出把 a[i] 替换成 b 后，a 的最长严格递增子序列（LIS）的长度。
注意每个询问之间彼此独立，比如第一个询问把 a[1] 替换成 6，那么对于第二个询问，a[1] 还是原来的值。

rating 2600
请先完成上周五的 CF486E，需要用到这题的结论。
修改后的 LIS，有两种情况：
1. LIS 不包含修改后的 a[i]，那么计算的就是原数组去掉 a[i] 后的 LIS 长度。
2. LIS 包含修改后的 a[i]。
这两种情况取 max 即为答案。
第一种情况的计算方法：
设原数组的 LIS 长度为 k。
用上周五（CF486E）的结论，如果原数组的 a[i] 在所有 LIS 中，则去掉 a[i] 后，LIS 长度缩小，即 k-1；否则 LIS 长度不变，仍然为 k。
注意，为了判断这件事，需要正着计算一遍所有前缀的 LIS 长度，再反着计算所有后缀的 LIS 长度。
第二种情况的计算方法：
（先把询问离线，按照修改的下标分组）
上面说到，我们需要计算所有前缀/后缀的 LIS 长度，这用的是二分算法，会用到一个辅助数组 g，其中 g[i] 等于长为 i 的上升子序列的末尾元素的最小值。
正序遍历到 a[i] 时，先对所有在 i 处的询问，在 g 数组上二分查找 b，算出 LIS 中小于 b 的元素个数，加到答案中，然后答案再加一（把 b 算进去）。
倒序遍历到 a[i] 时，先对所有在 i 处的询问，在 g 数组上二分查找 b，算出 LIS 中大于 b 的元素个数，加到答案中。
这样我们就得到了包含 a[i]=b 的 LIS 长度。
https://codeforces.com/problemset/submission/650/264400602
======

Input
4 4
1 2 3 4
1 1
1 4
4 3
4 5
Output
4
3
3
4

Input
4 2
1 3 2 6
3 5
2 4
Output
4
3
 */