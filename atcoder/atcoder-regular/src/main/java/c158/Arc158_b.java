package c158;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arc158_b {
    static int n;
//    static int[] x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
//        x = new int[n];
        a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
//            x[i] = scanner.nextInt();
            int x = scanner.nextInt();
            a.add(x);
        }
        System.out.println(solve());
    }

    static List<Integer> a;

    private static String solve() {
        a.sort(null);
        int i0 = searchInts(a, 0);
        if (i0 < n - 6) {
            // a = append(a[:i+3], a[n-3:]...)
            a.subList(i0 + 3, n - 3).clear();
        }
        if (i0 > 6) {
            // a = append(a[:3], a[i-3:]...)
            a.subList(3, i0 - 3).clear();
        }

        double mn = 3.0, mx = -3.0;
        for (int i = 0; i < a.size(); i++) {
            double x = a.get(i);
            for (int j = i + 1; j < a.size(); j++) {
                double y = a.get(j);
                for (int k = j + 1; k < a.size(); k++) {
                    double z = a.get(k);
                    double res = (x + y + z) / (x * y * z);
                    mn = Math.min(mn, res);
                    mx = Math.max(mx, res);
                }
            }
        }
        return String.format("%.15f%n%.15f%n", mn, mx);
    }

    private static int searchInts(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
B - Sum-Product Ratio
https://atcoder.jp/contests/arc158/tasks/arc158_b

灵茶の试炼 2023-09-20
题目大意：
输入 n(3≤n≤2e5) 和长为 n 的数组 a(-1e6≤a[i]≤1e6 且 a[i]≠0)。
从 a 中选 3 个下标不同的数 x y z。
输出 (x+y+z)/(x*y*z) 的最小值和最大值。
和答案的绝对/相对误差需要在 1e-12 内。

如果知道 x 和 y，那么式子可以变形为
(x+y)/(xy) * (1/z) + 1/(xy)
由反比例函数的性质可知，当 z 取绝对值最小或最大的数时，可以让式子取到最值。
对于 x 和 y 也同理。
所以至多考虑 12 个数即可（负数中最小 3 个，最大 3 个，正数中最小 3 个，最大 3 个），在这里面枚举 x y z。
https://atcoder.jp/contests/arc158/submissions/45499928
======

Input 1
4
-2 -4 4 5
Output 1
-0.175000000000000
-0.025000000000000

Input 2
4
1 1 1 1
Output 2
3.000000000000000
3.000000000000000

Input 3
5
1 2 3 4 5
Output 3
0.200000000000000
1.000000000000000
 */