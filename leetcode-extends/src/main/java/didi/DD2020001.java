package didi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DD2020001 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(n, m, a));
    }

    private static String solve(int n, int m, int[][] a) {
        int sum = 0;
        for (int j = 0; j < m; j++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                }
//                max = Math.max(max, a[i][j]);
            }
            sum += max;
        }
        return String.valueOf(sum);
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
DD-2020001. 项目分配
https://leetcode.cn/problems/jnXBfG/

某公司雇有 N 名员工，每名员工可以负责多个项目，但一个项目只能交由一名员工负责。现在该公司接到 M 个项目，
令 A(i,j) 表示第 i 名员工负责第 j 个项目所带来的收益，那么如果项目分配得当，总收益最大是多少?
格式：
输入：
- 第一行包含两个整数 N 和 M
- 接下来 N 行，每行包含 M 个整数，第 i 行的第 j 个整数表示 A(i,j)
输出：
- 输出总收益的最大值。
示例：
输入：
3 3
1 3 3
2 2 2
3 2 1
输出：9
提示：
1 ≤ N，M ≤ 1000
1 ≤ A(i,j) ≤ 1000

贪心，注意到每名员工可以负责多个项目，但一个项目只能交由一名员工负责
每个项目交由收益最高的员工负责即可。
 */