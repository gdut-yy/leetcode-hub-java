package p309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF309C {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        // Time limit exceeded on test 11
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] leftA = new int[30];
        int[] cntB = new int[30];
        for (int v : a) {
            for (; v > 0; v &= v - 1) {
                leftA[Integer.numberOfTrailingZeros(v)]++;
            }
        }
        for (int v : b) {
            cntB[v]++;
        }

        int ans = 0;
        outer:
        for (int i = 0; i < 30; i++) {
            int c = cntB[i];
            next:
            for (; c > 0; c--) {
                for (int j = i; j < 30; j++) {
                    if (leftA[j] > 0) {
                        ans++;
                        leftA[j]--;
                        continue next;
                    }
                    leftA[j]++;
                }
                break outer;
            }
        }
        return String.valueOf(ans);
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
C. Memory for Arrays
https://codeforces.com/contest/309/problem/C

灵茶の试炼 2024-01-25
题目大意：
输入 n(1≤n≤1e6) m(1≤m≤1e6) 和长为 n 的数组 a(1≤a[i]≤1e9)，长为 m 的数组 b(0≤b[i]≤29)。
有 n 个背包，第 i 个背包的容量为 a[i]。
有 m 个物品，第 i 个物品的体积为 2^b[i]。
把物品装入背包，对于每个背包，其中的物品体积之和不能超过背包容量。
所有背包的物品个数之和最大是多少？

rating 1900
提示 1
由于物品体积都是 2 的幂，我们可以把一个背包拆分成多个容量为 2 的幂的背包。
例如 a[i]=13 可以拆分成 8,4,1 这三个背包。
提示 2
由于物品体积都是 2 的幂，我们选的物品体积越小，可以装的物品个数就越多。
所以按照体积从小到大的顺序选择物品。
提示 3
如果一个体积为 v 的物品，恰好可以装入一个背包，那么直接装入。
如果没有恰好可以装入的背包，就选一个比容量比 v 大的背包装入。
例如物品体积为 2，背包容量为 8，那么装入后背包剩余容量为 6。
这个 6 也可以像提示 1 那样拆分成 4,2 这两个背包。
按照这个规则一个一个地装入物品，模拟即可。
https://codeforces.com/contest/309/submission/241246936
======

input
5 3
8 4 3 2 2
3 2 2
output
2

input
10 6
1 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0
output
6
 */