package p297;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF297B {
    static int n, m, k;
    static int[] a, b;

    public static void main(String[] args) {
        // Time limit exceeded on test 11
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
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
        if (n > m) return "YES";
        reverseSort(a);
        reverseSort(b);
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) {
                return "YES";
            }
        }
        return "NO";
    }

    // 由大到小排序
    private static void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
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
B. Fish Weight
https://codeforces.com/contest/297/problem/B

灵茶の试炼 2022-07-25
题目大意：
输入三个正整数 n(≤1e5) m(≤1e5) 和 k(≤1e9)。
在海洋中有 k 种鱼类，编号从 1 到 k。设编号为 i 的鱼的重量为 wi，你不知道 wi 的具体数值，但是你知道 0<w1≤w2≤...≤wk，注意 wi 可以为小数。
接下来输入一个长为 n 的数组 a 和一个长为 m 的数组 b，表示 A 抓到了 n 条鱼，第 i 条鱼的种类为 a[i]，B 抓到了 m 条鱼，第 i 条鱼的种类为 b[i]。
如果存在某个序列 w，使得 A 抓到的鱼的重量之和严格大于 B 抓到的鱼的重量之和，输出 YES，否则输出 NO。

rating 1600
https://codeforces.com/contest/297/submission/165616796
首先如果 n > m，我们只需要将所有的鱼的重量设为一样，A 的重量之和就比 B 多了，输出 YES。
否则如果存在 x，使得 A 抓到的重量 ≥ x 的鱼的数量比 B 多，那么将重量 < x 的鱼的重量设为一个无穷接近于 0 的值，就可以转换成上面的情况了，输出 YES。
否则输出 NO。
代码实现时可以将数组从大到小排序，然后看是否有 a[i] > b[i] 成立即可，具体见代码。
======

input
3 3 3
2 2 2
1 1 3
output
YES

input
4 7 9
5 2 7 3
3 5 2 7 3 8 7
output
NO
 */
