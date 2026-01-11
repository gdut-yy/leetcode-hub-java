package p799;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CF799C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) V1.solve();
        out.flush();
    }

    static class V1 {
        private static final int INF = (int) 1e9;

        record Pair(int b, int p) {
        }

        static long ans;

        private static void solve() {
            int n = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            List<Pair>[] g = new ArrayList[2];
            g[0] = new ArrayList<>();
            g[1] = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int p = scanner.nextInt();
                int b = scanner.next().charAt(0) - 'C';
                g[b].add(new Pair(x, p));
            }

            ans = 0;
            List<Integer> maxB = new ArrayList<>();
            maxB.add(f(g[0], c));
            maxB.add(f(g[1], d));

            out.println(Math.max(ans, maxB.get(0) + maxB.get(1)));
        }

        private static int f(List<Pair> a, int c) {
            a.sort(Comparator.comparingInt(p -> p.p));
            int[] preMax = new int[a.size() + 1];
            preMax[0] = -INF;
            int mx = -INF;
            for (int i = 0; i < a.size(); i++) {
                Pair p = a.get(i);
                if (p.p > c) {
                    break;
                }
                preMax[i + 1] = Math.max(preMax[i], p.b);
                mx = preMax[i + 1];
                int j = sortSearch(i, (m) -> a.get(m).p > c - p.p);
                ans = Math.max(ans, p.b + preMax[j]);
            }
            return mx;
        }

        static int sortSearch(int n, Function<Integer, Boolean> f) {
            int l = 0, r = n;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (f.apply(mid)) r = mid;
                else l = mid + 1;
            }
            return l;
        }
    }

    static class V2 {
        private static final int INF = (int) 1e9;

        record Pair(int b, int p) {
        }

        static int ans;

        private static void solve() {
            int n = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            List<Pair>[] g = new ArrayList[2];
            g[0] = new ArrayList<>();
            g[1] = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int p = scanner.nextInt();
                int b = scanner.next().charAt(0) - 'C';
                g[b].add(new Pair(x, p));
            }

            ans = 0;
            List<Integer> maxB = new ArrayList<>();
            maxB.add(f(g[0], c));
            maxB.add(f(g[1], d));

            out.println(Math.max(ans, maxB.get(0) + maxB.get(1)));
        }

        private static int f(List<Pair> a, int c) {
            a.sort(Comparator.comparingInt(p -> p.p));
            int[] preMax = new int[a.size() + 1];
            preMax[0] = -INF;
            int mx = -INF;
            int j = 0;
            for (int i = 0; i < a.size(); i++) {
                Pair p = a.get(i);
                int d = c - p.p;
                if (d < 0) {
                    break;
                }
                preMax[i + 1] = Math.max(preMax[i], p.b);
                mx = preMax[i + 1];
                if (j < i && a.get(j).p <= d) {
                    j++;
                }
                while (j > 0 && a.get(j - 1).p > d) {
                    j--;
                }
                ans = Math.max(ans, p.b + preMax[j]);
            }
            return mx;
        }
    }
}
/*
C. Fountains
https://codeforces.com/contest/799/problem/C

灵茶の试炼 2025-11-05
题目大意：
输入 n(2≤n≤1e5) c d(0≤c,d≤1e5)。
然后输入 n 座喷泉的信息，每行输入 b p(1≤b,p≤1e5) 和字母 'C' 或者 'D'，分别表示喷泉的美丽值、买入价、需要支付的货币类型是金币还是钻石。
你有 c 枚金币和 d 枚钻石。
你需要购买恰好两座喷泉。
输出这两座喷泉的美丽值之和的最大值。
如果无法做到，输出 0。

rating 1800
三种情况：
用金币买一座喷泉，然后用钻石买一座喷泉：分别计算各自能买的喷泉的最大美丽值，然后相加。
用金币买两座喷泉。
用钻石买两座喷泉。
以金币买两座喷泉为例。我们可以枚举右边的喷泉 i，设其价格为 p，然后寻找左边的最佳喷泉。
左边的喷泉价格必须 <= c - p。
可以按照价格从小到大排序，然后计算美丽值的前缀最大值 preMax。
在 [0,i-1] 中二分价格 <= c - p 的最后一个喷泉的下标，就可以在 preMax 中获取到左边的最佳喷泉。
注：也可以用背向双指针代替二分。但二分比背向双指针好写一些。
二分查找 https://codeforces.com/contest/799/submission/346639871
背向双指针 https://codeforces.com/contest/799/submission/346640920
代码备份（上面打不开的同学看这个）
======

Input
3 7 6
10 8 C
4 3 C
5 6 D
Output
9

Input
2 4 5
2 5 C
2 1 D
Output
0

Input
3 10 10
5 5 C
5 5 C
10 11 D
Output
10

2 4 5
2 5 C
2 1 D

0
 */
