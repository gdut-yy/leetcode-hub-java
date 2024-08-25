package p1610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1610E {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        int max = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            if (i == n - 1 || a[i] != a[i + 1]) {
                for (int j = i + 1; j < n; ) {
                    // j += 1 + sort.SearchInts(a[j+1:], a[j]*2-x)
                    j += 1 + searchInts(a, j + 1, n, a[j] * 2 - a[i]);
                    cnt++;
                }
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        return String.valueOf(n - max);
    }

    // Params:
    // a – the array to be searched
    // fromIndex – the index of the first element (inclusive) to be searched
    // toIndex – the index of the last element (exclusive) to be searched
    // key – the value to be searched for
    private static int searchInts(int[] nums, int fromIndex, int toIndex, int key) {
        int left = 0;
        int right = toIndex - fromIndex;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (nums[fromIndex + mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
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
E. AmShZ and G.O.A.T.
https://codeforces.com/contest/1610/problem/E

灵茶の试炼 2023-04-07
题目大意：
输入 t(≤1e4) 表示 t 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的有序数组 a(1≤a[i]≤1e9)，有重复元素。
你需要从 a 中删除一些元素，使得对于 a 的任意非空子序列 b，都必须满足：
设 avg 为 b 的平均值（可以是小数），b 中比 avg 小的数的个数必须 >= b 中比 avg 大的数的个数。
例如 [1,4,4,5,6] 的平均值为 4，有 1 个数比 4 小，有 2 个数比 4 大，这是不满足要求的。
而 [4,4,5,6] 是满足要求的。
最少需要删除多少个数？
注：子序列不要求连续。

rating 2300
https://codeforces.com/problemset/submission/1610/200982867
提示 1：长为 3 的子序列需要满足什么性质？
设这三个数分别为 x，y，z，那么 y <= avg = (x+y+z)/3，变形得 z >= 2y-x = 2(y-x)+x
提示 2：在长为 3 的子序列的基础上，增加一个数，这个数需要满足什么性质？
设增加的数为 u，那么 x，z，u 必须是满足要求的，即 u >= 2z-x >= 2(2y-x)-x = 4y-3x = 4(y-x)+x
依此类推，增加的数必须 >= 2^k*(y-x)+x，这是指数增长的，所以子序列 b 的长度不会超过 log(max(a))。
这样就可以暴力了，为了让去掉的数尽量少，那么保留的数要尽量多。
1. y-x 尽量小（但不能为 0），那么枚举所有 a[i] != a[i+1] 作为 x 和 y。
2. 从 x,y 开始构建子序列 b，二分找下一个数。
注意重复元素，所有重复的 x 都可以保留。
======

input
4
3
1 2 3
5
1 4 4 5 6
6
7 8 197860736 212611869 360417095 837913434
8
6 10 56026534 405137099 550504063 784959015 802926648 967281024
output
0
1
2
3
 */
