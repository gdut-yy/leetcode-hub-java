package p939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF939E {
    public static void main(String[] args) {
        // Time limit exceeded on test 27
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        int q = scanner.nextInt();

        int v = 0;
        long s = 0;
        int i = 0;
        List<Integer> a = new ArrayList<>();
        while (q-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                s -= v;
                v = scanner.nextInt();
                s += v;
                while (i < a.size() && a.get(i) * (i + 1L) < s) {
                    s += a.get(i);
                    i++;
                }
                a.add(v);
            } else {
                double ans = (double) v - (double) s / (i + 1);
                System.out.printf("%.8f\n", ans);
            }
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
E. Maximize!
https://codeforces.com/contest/939/problem/E

灵茶の试炼 2022-06-09
题目大意：
一开始你有一个空数组 a。
接下来有 Q(<=5e5) 次操作或询问。
操作（用 1 和 x 表示）是往 a 的末尾添加一个在 [1,1e9] 的数字 x，保证添加后 a 仍然是非降的。
询问（用 2 表示）是请你选择 a 中的一个子序列（不要求连续）b，最大化 max(b)-avg(b)，这里 avg(b) 为 b 的平均值。
对于每个询问，输出 max(b)-avg(b) 的最大值。（保留 8 位小数即可）

rating 1800
https://codeforces.com/problemset/submission/939/159989325
显然最后一个元素必须选（可以列个不等式证明），当作 max(b)；其余的元素需要选 a 的前缀，这样 avg(b) 才能尽量小。
那么应该选哪个前缀呢？
我们可以从头开始，不断扩充前缀，如果待扩充的元素比当前的 avg(b) 要小，则可以继续扩充前缀，从而使 avg(b) 变得更小。
假设上一次操作我们选择了某个前缀，那么当下一次操作发生后，我们需要替换 max(b)，这会使 avg(b) 变大，因此我们可以直接在上一次操作的基础上继续扩充前缀。
因此双指针即可求出要选择哪个前缀。
======

input
6
1 3
2
1 4
2
1 8
2
output
0.0000000000
0.5000000000
3.0000000000

input
4
1 1
1 4
1 5
2
output
2.0000000000
 */