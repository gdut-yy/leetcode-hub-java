package p1849;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CF1849E {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        // Time limit exceeded on test 24
//        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Deque<int[]> stmn = new ArrayDeque<>();
        Deque<int[]> stmx = new ArrayDeque<>();
        stmn.push(new int[]{-1, -1});
        stmx.push(new int[]{n, -1});
        long ans = 0;
        int len = 0;
        // set<pair<int, int>> cur;
        TreeSet<int[]> cur = new TreeSet<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        cur.add(new int[]{-1, 0});
        cur.add(new int[]{-1, 1});
        for (int i = 0; i < n; i++) {
            int x = p[i] - 1;
            while (!stmn.isEmpty() && stmn.peek()[0] > x) {
                // cur.lower_bound({stmn.back().second, 0});
                int[] me = cur.floor(new int[]{stmn.peek()[1], 0});
                int[] it = cur.higher(me);
                int[] pre = cur.lower(me);
                len -= me[0] - pre[0];
                if (!Arrays.equals(it, cur.last()) && it[1] == 0) {
                    len += it[0] - pre[0];
                }
                cur.remove(me);
                stmn.pop();
            }
            len += i - cur.last()[0];
            cur.add(new int[]{i, 0});
            stmn.push(new int[]{x, i});

            while (stmx.peek()[0] < x) {
                int[] me = cur.floor(new int[]{stmx.peek()[1], 1});
                int[] it = cur.higher(me);
                int[] pre = cur.lower(me);
                if (!Arrays.equals(it, cur.last()) && it[1] == 0) {
                    len += me[0] - pre[0];
                }
                cur.remove(me);
                stmx.pop();
            }
            cur.add(new int[]{i, 1});
            stmx.push(new int[]{x, i});

            ans += len;
        }
        return String.valueOf(ans - n);
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
E. Max to the Right of Min
https://codeforces.com/contest/1849/problem/E

题目大意：
给定一个长度为 n 的排列 p 的数组，由从 1 到 n 的整数组成，它们都是不同的。
让 pl,r 表示一个子数组——一个从索引 1 到索引 r(包括在内)写下元素所形成的数组。
设 maxposl,r 表示 pl,r 上最大元素的索引。类似地，设 minposl,r 表示其上最小元素的索引。
计算子数组 pl,r 的个数，使得 maxposl,r>minposl,r。

rating 2300
为什么是排列？滑窗？
---
https://codeforces.com/blog/entry/118752
这个问题最初是作为单调堆栈讲座的一部分准备的。因此，我将省略它的解释。
首先，回想一下计算满足某些属性的所有片段的常用技术。您可以同时计算具有相同右边界的区段。
考虑所有带固定 r 的段[l,r]。它们的最大值和最小值是如何变化的?如果你按照 l 递减的顺序观察这些片段，我们可以写出以下事件的顺序:最小值变小，最大值变大。事实上，我们可以用两个单调堆栈来维持这两种类型。
现在，哪些 l 对应于这些事件的好的片段?考虑两个相邻的事件(i1,t1)和(i2,t2)，其中 ij 是事件的索引，tj 是类型(0 表示 min, 1 表示 max)。很容易看出，如果 t2=0，那么所有从 i1+1 到 i2 有 l 的段都是好的。这意味着，从右到左，我们遇到的最后一个事件是最小值越来越小。这样，最小值的索引就从最大值的索引往左了。
至于实现，我们将在一组对中维护这些事件:(事件的索引，事件的类型)。这样，维护从类型 0 的每个事件到前一个事件的距离和就不那么困难了。
当你擦除一个事件时，只有几个距离会受到影响:从下一个事件到当前事件的距离，从当前事件到前一个事件的距离，以及新创建的从下一个事件到前一个事件的距离。检查一下类型。当您添加一个事件时，您只将它添加到集合的最后，因此重新计算是微不足道的。
这将是 O(nlogn)单从集合来看，单调堆栈本身是线性的。
您可以通过使用双链表将这个解决方案优化为 O(n)，但对于这个问题来说，它确实不是必需的。
还有一种不同的解决方案可以明确地保持好值 l 的区间。首先，以这样一种方式压缩它们，即片段在边界处不接触。现在，你可以注意到，从 r 到 r+1，我们只能影响最右边的那些:可能会删除一些，然后改变最后一个，添加一个新的。我们可以用另一个堆栈来模拟这个行为。细节留给读者作为练习。通过正确的实现，这个解决方案将是 O(n)。
======

input
3
1 2 3
output
3

input
6
5 3 6 1 4 2
output
4

input
10
5 1 6 2 8 3 4 10 9 7
output
38

100
98 52 63 2 18 96 31 58 84 40 41 45 66 100 46 71 26 48 81 20 73 91 68 76 13 93 17 29 64 95 79 21 55 75 19 85 54 51 89 78 15 87 43 59 36 1 90 35 65 56 62 28 86 5 82 49 3 99 33 9 92 32 74 69 27 22 77 16 44 94 34 6 57 70 23 12 61 25 8 11 67 47 83 88 10 14 30 7 97 60 42 37 24 38 53 50 4 80 72 39
2979
 */
