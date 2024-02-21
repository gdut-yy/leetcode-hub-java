package p1186;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1186D {
    static int n;
    static double[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextDouble();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int s = 0;
        for (double v : a) {
            s += (int) Math.floor(v);
        }

        List<Integer> ans = new ArrayList<>();
        for (double v : a) {
            int f = (int) Math.floor(v);
            if (s < 0 && v != f) {
                s++;
                ans.add(f + 1);
            } else {
                ans.add(f);
            }
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
D. Vus the Cossack and Numbers
https://codeforces.com/contest/1186/problem/D

灵茶の试炼 2022-04-18
题目大意：
给你 n(<=1e5) 个浮点数 (绝对值不超过 1e5)，记作数组 a，保证这 n 个数的和为 0。
你需要构造任意一个数组 b，满足 b[i] = floor(a[i]) 或者 b[i] = ceil(a[i])，且 sum(b) = 0

rating 1500
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1186d
https://www.luogu.com.cn/problem/solution/cf1186d
提供一个简洁的证明方法：
由于
\sum \left \lfloor a_i \right \rfloor \le \sum a_i = 0
\sum \left \lceil a_i \right \rceil \ge \sum a_i = 0
我们从 \sum \left \lfloor a_i \right \rfloor 出发，不断地给 a_i 不为整数的 \left \lfloor a_i \right \rfloor 加一，将其变为 \left \lceil a_i \right \rceil，
由于整数的连续性，从 \sum \left \lfloor a_i \right \rfloor 到 \sum \left \lceil a_i \right \rceil 中必然在某一时刻会达到 0（类比介值定理），此时我们就得到了 b_i 序列。
======

input
4
4.58413
1.22491
-2.10517
-3.70387
output
4
2
-2
-4

input
5
-6.32509
3.30066
-0.93878
2.00000
1.96321
output
-6
3
-1
2
2
 */
