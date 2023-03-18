package p1361;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class CF1361B {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = scanner.nextInt();
            }
            System.out.println(solve(n, p, k));
        }
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve(int n, int p, int[] k) {
        if (p == 1) {
            return String.valueOf(n % 2);
        }
        Arrays.sort(k);

        // ki, cnt
        Deque<int[]> stack = new ArrayDeque<>();
        int targetK = k[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int ki = k[i];
            while (!stack.isEmpty() && Arrays.equals(stack.peek(), new int[]{ki, p - 1})) {
                stack.pop();
                ki++;
            }
            if (ki == targetK) {
                if (i == 0) {
                    return "0";
                }
                i--;
                // 继续下一轮
                targetK = k[i];
            } else if (!stack.isEmpty() && stack.peek()[0] == ki) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{ki, 1});
            }
        }

        long ans = quickPow(p, targetK);
        for (int[] x : stack) {
            ans -= quickPow(p, x[0]) * x[1];
        }
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
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
B. Johnny and Grandmaster
https://codeforces.com/contest/1361/problem/B

灵茶の试炼 2023-02-10
题目大意：
输入 t(≤1e5) 表示 t 组数据，每组数据输入 n(≤1e6) p(1≤p≤1e6) 和长为 n 的数组 k(0≤k[i]≤1e6)。所有数据的 n 之和不超过 1e6。
从这 n 个数中选出若干个数（可以为空）组成一组，剩余的数组成另一组。
每组计算 pow(p,k[i]) 之和。
输出这两个和的差值的最小值，对结果模 1e9+7。

https://codeforces.com/contest/1361/submission/192575286
提示：从大到小遍历 k，栈，消消乐
例如 p=3，k=[4,3,3,2,2,1,1,1]，第一个 4 放一组，剩余的放另一组。在遍历的时候为了判断能否抵消，需要用到栈来统计 k[i] 及其出现次数，如果凑齐 p 个，那么就可以合成一个更大的 k。
为什么一定可以消除？因为小的 p^k 一定是大的 p^k 的因子。
不用 FastReader 会 TLE。。
======

input
4
5 2
2 3 4 4 3
3 1
2 10 1000
4 5
0 1 1 100
1 8
89
output
4
1
146981438
747093407
 */
