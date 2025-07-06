package p2094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF2094G {
    // Time limit exceeded on test 2
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    private static void solve() {
        int q = scanner.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();
        boolean rev = false;
        int v;
        long n = 0, s = 0, ss = 0, revS = 0;
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                // if len(r) > 0 {
                //   v = r[len(r)-1]
                //   r = r[:len(r)-1]
                // } else {
                //   v = l[0]
                //   l = l[1:]
                // }
                // l = append(l, v)
                if (rev) {
                    v = dq.removeLast();
                    dq.addFirst(v);
                } else {
                    v = dq.removeFirst();
                    dq.addLast(v);
                }
                ss += s - v * n;
                revS += v * n - s;
            } else if (op == 2) {
                // l, r = r, l
                // ss, revS = revS, ss
                rev = !rev;
                long temp = ss;
                ss = revS;
                revS = temp;
            } else {
                v = scanner.nextInt();
                // r = append(r, v)
                if (rev) dq.addLast(v);
                else dq.addFirst(v);
                n++;
                ss += v * n;
                s += v;
                revS += s;
            }
            out.println(ss);
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
G. Chimpanzini Bananini
https://codeforces.com/contest/2094/problem/G

灵茶の试炼 2025-06-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 q 之和 ≤2e5。
一开始，你有一个空数组 a。
每组数据输入 q(1≤n≤2e5) 和 q 个操作，格式如下：
"1"：把 a 循环右移一位。也就是把 a 的最后一个数去掉，插到 a 的第一个数左边。
"2"：反转 a。
"3 x"：把 x(1≤x≤1e6) 添加到 a 的末尾。
保证第一个操作是 "3 x"。
每次操作后，输出 S(a) = 1*a[1] + 2*a[2] + 3*a[3] + ... + m*a[m]，其中 m 为 a 的长度。

rating 1700
我们需要支持右边插入，右边删除，左边插入。
由于还有反转，还要支持在左边删除。
用双端队列实现。
维护 S(a)，以及 S(reverse(a))。
右边插入，把 S(a) 增加 m*a[m]。
右边删除，把 S(a) 减少 m*a[m]。
左边插入，原来每一项的系数都增加 1，所以 S(a) 增加 a[1] + a[2] + a[3] + ... + a[m]。还需额外维护 sum(a)。
左边删除，把 S(a) 减少 sum(a)。
对于 S(reverse(a)) 的维护同理。
注：Go 没有 deque，可以用两个 slice 头对头实现 deque。
代码 https://codeforces.com/contest/2094/submission/325562883
代码备份（Ubuntu Pastebin）
======

Input
1
13
3 1
3 2
3 3
1
3 4
2
3 5
1
3 6
2
3 7
2
1
Output
1
5
14
11
27
23
48
38
74
73
122
102
88
 */
