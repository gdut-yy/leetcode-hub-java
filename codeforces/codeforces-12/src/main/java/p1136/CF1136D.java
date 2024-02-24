package p1136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class CF1136D {
    static int n, m;
    static int[] a;
    static int[][] xy;

    public static void main(String[] args) {
        // Time limit exceeded on test 12
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        xy = new int[m][2];
        for (int i = 0; i < m; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Set<String> swap = new HashSet<>();
        for (int[] p : xy) {
            String key = p[0] + ":" + p[1];
            swap.add(key);
        }

        List<Integer> mustInSwap = new ArrayList<>();
        mustInSwap.add(a[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int x = a[i];
            for (Integer y : mustInSwap) {
                String key = x + ":" + y;
                if (!swap.contains(key)) {
                    mustInSwap.add(x);
                    break;
                }
            }
        }
        int ans = n - mustInSwap.size();
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
D. Nastya Is Buying Lunch
https://codeforces.com/contest/1136/problem/D

灵茶の试炼 2022-06-15
题目大意：
给你整数 n(<=3e5) 和 m(<=5e5) 表示有 n 个编号从 1 到 n 的人，m 对交换信息。
然后给你一个 1 到 n 的排列 a，表示这 n 个人从左到右排成一队。
然后给你 m 个互不相同的对 (x,y)，表示若 x 和 y 相邻且 x 在 y 左侧，则 x 可以和 y 交换位置。
输出队尾那个人最多可以向左移动多远（他到队尾的距离）。

rating 1800
https://codeforces.com/problemset/submission/1136/160698756
用一个数组 mustInSwap 记录左边的人需要和哪些人交换，才可以让队尾那个人向左移动。
初始 mustInSwap 只包含队尾那个人。
然后从倒数第二个人开始模拟，如果他可以和 mustInSwap 中的所有人发生交换，那么队尾的人可以向左移动；否则把他加入 mustInSwap，重复。
答案为 n-len(mustInSwap)。
======

input
2 1
1 2
1 2
output
1

input
3 3
3 1 2
1 2
3 1
3 2
output
2

input
5 2
3 1 5 4 2
5 2
5 4
output
1
 */
