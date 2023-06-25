package p1828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CF1828D1 {
    public static void main(String[] args) {
        // Time limit exceeded on test 15
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    // https://codeforces.com/contest/1827/submission/205871376
    private static String solve(int n, int[] a) {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> a[o]));

        long ans = 0;
        for (long i = 0; i < n; i++) {
            ans += i * (n - i);
        }

        TreeSet<Integer> loc0 = new TreeSet<>();
        TreeSet<Integer> loc1 = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            loc1.add(i);
        }
        loc0.add(-1);
        loc0.add(n);
        loc1.add(-1);
        loc1.add(n);
        for (Integer x : ids) {
            loc0.add(x);
            loc1.remove(x);

            // auto f = loc1.lower_bound(x);
            Integer f = loc1.ceiling(x);
            int c0 = x - loc1.lower(x);
            int l1 = f;

            long c1 = 0;
            if (l1 < n) {
                c1 = loc0.ceiling(l1) - l1;
            }
            ans -= c0 * c1;
        }
        return String.valueOf(ans);
    }

    private static class FastReader {
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
D2. Range Sorting (Hard Version)
https://codeforces.com/contest/1828/problem/D1
https://codeforces.com/contest/1828/problem/D2

题目大意：
这个问题和难解的唯一区别是 t 和 n 的约束条件。1≤t≤10^4 1≤n≤3⋅10^5 （D1 1≤t≤5⋅10^3 1≤n≤5⋅10^3）
给定一个数组 a，它由 n 个不同的整数 a1,a2,...,an 组成。
将数组 p1,p2,...,pk 定义为使用任意数量的范围排序操作对该数组进行排序所需的最小时间。在每个范围排序操作中，您将执行以下操作:
- 选择两个整数 l 和 r(1≤l<r≤k)。
- 在 r−1 秒内对子数组 pl,pl+1,...,pr 进行排序。
请计算数组 a 的所有子数组的美值之和。
数组的子数组被定义为数组中连续元素的序列。

D1 单调栈 时间复杂度 O(n^2) 解法 rating 2000
D2 贡献法 rating 2400
======

input
5
2
6 4
3
3 10 6
4
4 8 7 2
5
9 8 2 4 6
12
2 6 13 3 15 5 10 8 16 9 11 18
output
1
2
8
16
232
 */
