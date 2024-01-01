package p1634;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1634F {
    static int n, q, mod;
    static long[] a, b;
    static int[][] clr;

    public static void main(String[] args) {
        // Time limit exceeded on test 5
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        q = scanner.nextInt();
        mod = scanner.nextInt();
        a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }
        clr = new int[q][3];
        for (int i = 0; i < q; i++) {
            clr[i][0] = scanner.next().charAt(0) - 'A';
            clr[i][1] = scanner.nextInt();
            clr[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static int cnt0;

    private static String solve() {
        long[] f = new long[n + 2];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % mod;
        }
        for (int i = 1; i <= n; i++) {
            a[i] = (a[i] - b[i]) % mod;
        }
        cnt0 = 0;
        for (int i = n; i - 2 >= 0; i--) {
            a[i] = (a[i] - a[i - 1] - a[i - 2]) % mod;
            if (a[i] == 0) {
                cnt0++;
            }
        }
        if (a[1] == 0) {
            cnt0++;
        }

        String[] ans = new String[q];
        for (int i = 0; i < q; i++) {
            int c = clr[i][0], l = clr[i][1], r = clr[i][2];
            int sgn = c == 0 ? 1 : -1;
            update(l, sgn);
            update(r + 1, -f[r - l + 2] * sgn);
            update(r + 2, -f[r - l + 1] * sgn);
            ans[i] = cnt0 == n ? "YES" : "NO";
        }
        return String.join(System.lineSeparator(), ans);
    }

    static void update(int i, long add) {
        if (i > n) return;
        if (a[i] == 0) cnt0--;
        a[i] = (a[i] + add) % mod;
        if (a[i] == 0) {
            cnt0++;
        }
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
F. Fibonacci Additions
https://codeforces.com/contest/1634/problem/F

灵茶の试炼 2023-11-10
题目大意：
定义斐波那契序列 f[1]=1, f[2]=1, f[i]=f[i-1]+f[i-2] (i≥3)
定义数组 x 的「斐波那契区间加」表示指定 x 的一个连续子数组 [l,r]，把 x[l] 加上 f[1]，x[l+1] 加上 f[2]，... x[r] 加上 f[r-l+1]。
输入 n q(1≤n,q≤3e5) mod(1≤mod≤1e9+7) 和长为 n 的数组 a 和 b，元素范围 [0,mod-1]，下标从 1 开始。
然后输入 q 个操作，每个操作输入一个字符 ('A' 或 'B') 和两个数 l 和 r (1≤l≤r≤n)。
'A' 表示操作对象是数组 a，'B' 表示操作对象是数组 b，对这个数组的连续子数组 [l,r] 执行「斐波那契区间加」操作，这个操作是永久的。
每次操作后，如果每个 a[i] 和 b[i] 都模 mod 同余，也就是 (a[i]-b[i])%mod=0，则输出 YES，否则输出 NO。
相关题目：C. DZY Loves Fibonacci Numbers
https://codeforces.com/contest/446/problem/C

rating 2700
定义 c[i]=a[i]-b[i]，问题转换成是否每个 c[i]%mod=0。
由于 f[i]-f[i-1]-f[i-2]=0，类比差分数组，可以定义（初始化）
d[1]=c[1]
d[2]=c[2]-c[1]
d[i]=c[i]-c[i-1]-c[i-2] (i≥3)
例如对 [1,5] 执行斐波那契区间加，相当于
d[1] += f[1] = 1
d[2] += f[2]-f[1] = 0
d[3] += f[3]-f[2]-f[1] = 0
d[4] += f[4]-f[3]-f[2] = 0
d[5] += f[5]-f[4]-f[3] = 0
d[6] += 0-f[5]-f[4] = -f[6]
d[7] += 0-0-f[5] = - f[5]
一般地，对 [l,r] 执行斐波那契区间加，相当于
d[l] += 1
d[r+1] -= f[r-l+2]
d[r+2] -= f[r-l+1]
由于 c 数组模 mod 均为 0，当且仅当 d 数组模 mod 均为 0，所以只需要维护 d 数组及其 0 的个数。如果 0 的个数等于 n，则输出 YES，否则输出 NO。
https://codeforces.com/contest/1634/submission/231091281
======

input
3 5 3
2 2 1
0 0 0
A 1 3
A 1 3
B 1 1
B 2 2
A 3 3
output
YES
NO
NO
NO
YES

input
5 3 10
2 5 0 3 5
3 5 8 2 5
B 2 3
B 3 4
A 1 2
output
NO
NO
YES
 */
