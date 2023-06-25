package p1839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CF1839B {
    public static void main(String[] args) {
        // Time limit exceeded on test 9
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] ab = new int[n][2];
            for (int i = 0; i < n; i++) {
                ab[i][0] = scanner.nextInt();
                ab[i][1] = scanner.nextInt();
            }
            System.out.println(solve(n, ab));
        }
    }

    private static String solve(int n, int[][] ab) {
        Map<Integer, PriorityQueue<Integer>> groups = new HashMap<>();
        for (int[] tuple : ab) {
            int a = tuple[0], b = tuple[1];
            groups.computeIfAbsent(a, key -> new PriorityQueue<>(Comparator.reverseOrder())).add(b);
        }

        long ans = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : groups.entrySet()) {
            int k = entry.getKey();
            PriorityQueue<Integer> maxHeap = entry.getValue();
            int sz = maxHeap.size();
            for (int i = 0; i < k && i < sz; i++) {
                ans += maxHeap.remove();
            }
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
B. Lamps
https://codeforces.com/contest/1839/problem/B

题目大意：
你有 n 个灯，用从 1 到 n 的整数编号。每个灯 i 有两个整数参数 ai 和 bi。
每时每刻，每盏灯都处于三种状态之一:它可能是开着的，可能是关着的，也可能是坏的。
最初所有的灯都是关闭的。在一次操作中，您可以选择一个关闭的灯并将其打开(您不能打开破碎的灯)。打开 i 号灯可以得到 bi 分。每次执行操作后会发生以下情况:
让我们用 x 表示打开的灯的数量(坏掉的灯不计算在内)。所有使 ai≤x 的灯在打开或关闭时同时断开。
请注意，破碎的灯永远不会被计算为打开，并且在打开的灯破裂后，您仍然保留打开它的分数。
您可以执行任意数量的操作。
找出你能得到的最大点数。
---
在第一个测试用例 n=4。获得最大点数的方法之一如下:
你打开 4 号灯，得到 b4=13 点。
打开的灯数为 1，因此 ai≤1 的灯(即 2、3、4 号灯)全部断开。4 号灯不再打开，因此打开的灯数变为 0。
你唯一能打开的灯是 1 号灯，因为其他的灯都坏了。打开它可以得到 b1=2 分。
打开的灯的数量是 1。当 a1=2 时，1 号灯不坏。
你总共得到 13+2=15 分。可以证明，这是您可以获得的最大点数，因此第一个测试用例的答案是 15。
---
在第二个测试用例中，获得最大点数的方法之一如下:
在第一次操作中，您打开灯 4 并获得 2 分。第一次操作后无灯断。
在第二次操作中，您打开灯 3 并获得 5 分。第二次操作后，有 2 盏灯打开。当 a3≤2 时，灯 3 断裂。
在第三次操作中，您打开灯 1 并获得 4 点。
在第四次操作中，您打开灯 5，并获得 3 点。之后有 3 盏灯打开:灯 1、4 和 5。1、2、4、5 灯同时断，因为它们的 ai≤3。
你总共得到 2+5+4+3=14 分。可以看出，这是你能得到的最大分数。

脑筋急转弯
======

input
4
4
2 2
1 6
1 10
1 13
5
3 4
3 1
2 5
3 2
3 3
6
1 2
3 4
1 4
3 4
3 5
2 3
1
1 1
output
15
14
20
1
 */
