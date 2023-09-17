package c294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Abc294_d {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        solve(scanner, n, q);
    }

    // O(qlogn)
    private static void solve(FastReader scanner, int n, int q) {
        TreeSet<Integer> called = new TreeSet<>();
        int id = 1;
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                if (id <= n) {
                    called.add(id++);
                }
            } else if (op == 2) {
                int x = scanner.nextInt();
                called.remove(x);
            } else if (op == 3) {
                resList.add(called.first());
//                System.out.println(called.first());
            }
        }
        String res = resList.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
        System.out.println(res);
    }

    // O(n + q)
    private static void solve1(FastReader scanner, int n, int q) {
        boolean[] gone = new boolean[n + 1];
        int ans = 1;
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                // do nothing
            } else if (op == 2) {
                int x = scanner.nextInt();
                gone[x] = true;
            } else if (op == 3) {
                while (gone[ans]) {
                    ans++;
                }
//                System.out.println(ans);
                resList.add(ans);
            }
        }
        String res = resList.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
        System.out.println(res);
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
D - Bank
https://atcoder.jp/contests/abc294/tasks/abc294_d

题目大意：
N 个人，身份证号码是 1,2,...,N，在一家银行门口排队。会有 Q 个事件。可能会发生以下三种情况。
1: 柜员呼叫未被呼叫的身份证号码最小的人。
2 x: 身份证号码为 x 的人第一次来到柜员处。(这里，x 至少已经被出纳员叫过一次了。)
3: 出纳员再次呼叫已被呼叫但尚未来的身份证号码最小的人。
打印第三种情况下柜员呼叫的人员的身份证号。

TreeSet 模拟。
======

Input
4 10
1
1
3
2 1
1
2 3
3
1
2 2
3
Output
1
2
4
 */