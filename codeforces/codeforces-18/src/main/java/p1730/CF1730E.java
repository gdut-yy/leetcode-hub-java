package p1730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class CF1730E {
    static final int N = (int) (5e5 + 13);
    static final int A = (int) (1e6 + 13);

    // TLE 写法：static final List<Integer>[] divs = new ArrayList[A];
    static final ArrayList<Integer>[] divs = new ArrayList[A];

//    static {
//        Arrays.setAll(divs, e -> new ArrayList<>());
//        for (int i = 1; i < A; i++) {
//            for (int j = i; j < A; j += i) {
//                divs[j].add(i);
//            }
//        }
//    }

    static final int[] a = new int[N];

    static final int[] gr_lf = new int[N], gr_rg = new int[N];
    static final int[] less_lf = new int[N], less_rg = new int[N];

    // TLE 写法：static final List<Integer>[] pos = new ArrayList[A];
    static final ArrayList<Integer>[] pos = new ArrayList[A];
    static final int[] ind = new int[A];

    static int n;

    public static void main(String[] args) {
        Arrays.setAll(pos, e -> new ArrayList<>());

        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                pos[a[i]].add(i);
            }
            solve();
        }
    }

    public static void solve() {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] < a[i]) st.pop();
            gr_lf[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] <= a[i]) st.pop();
            gr_rg[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            less_lf[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            less_rg[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (divs[a[i]] == null) {
                divs[a[i]] = new ArrayList<>();
                for (int j = 1; j * j <= a[i]; j++) {
                    if (a[i] % j == 0) {
                        divs[a[i]].add(j);
                        int b = a[i] / j;
                        if (b != j) divs[a[i]].add(b);
                    }
                }
                divs[a[i]].sort(null);
            }

            for (int x : divs[a[i]]) {
                if (ind[x] >= 1) {
                    int j = pos[x].get(ind[x] - 1);
                    if (j > gr_lf[i] && less_rg[j] > i) {
                        ans += (long) (j - Math.max(gr_lf[i], less_lf[j])) * (Math.min(gr_rg[i], less_rg[j]) - i);
                    }
                }

                if (ind[x] < pos[x].size()) {
                    int j = pos[x].get(ind[x]);
                    if (j < gr_rg[i] && less_lf[j] < i) {
                        ans += (long) (i - Math.max(Math.max(gr_lf[i], less_lf[j]), ind[x] >= 1 ? pos[x].get(ind[x] - 1) : -1)) * (Math.min(gr_rg[i], less_rg[j]) - j);
                    }
                }
            }
            ind[a[i]]++;
        }

        System.out.println(ans);

        for (int i = 0; i < n; i++) {
            pos[a[i]].clear();
            gr_lf[i] = gr_rg[i] = less_lf[i] = less_rg[i] = 0;
            ind[a[i]] = 0;
        }
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
E. Maximums and Minimums
https://codeforces.com/contest/1730/problem/E

灵茶の试炼 2024-02-02
题目大意：
输入 T(≤10) 表示 T 组数据。所有数据的 n 之和 ≤5e5。
每组数据输入 n(1≤n≤5e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。
输出 a 有多少个非空连续子数组 b，满足 max(b) 是 min(b) 的倍数。

rating 2700
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1730e
唯一 Java AC 的选手：https://codeforces.com/contest/1730/submission/243763579
标程：https://codeforces.com/blog/entry/107293
======

input
6
1
1
2
2 4
2
2 3
4
2 4 7 14
7
16 5 18 7 7 12 14
6
16 14 2 6 16 2
output
1
3
2
7
10
19

1
4
2 4 7 14
 */
