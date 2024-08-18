package lq240615;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LQ240615T4 {
    static int p, q;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            p = scanner.nextInt();
            q = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (p == q) return "0";

        int inf = (int) 2e9;
        int mi = inf;
        List<Integer> factors = getFactors(q - p);
        for (Integer x : factors) {
            if (x >= p) mi = Math.min(mi, x);
        }
        if (mi == inf) return "-1";
        return String.valueOf(mi - p);
    }

    static List<Integer> getFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                if (i * i != num) factors.add(num / i);
            }
        }
        return factors;
    }
}
/*
物流选址【算法赛】

首先，如果 P=Q，那么答案显然是 0.
接下来考虑 P<Q 的情况。
我们希望 (Q+Y)/(P+Y) = 1+(Q-P)/(P+Y) 是整数，也就是说 P+Y 必须是 Q-P 的约数。因此，我们可以枚举 Q-P 的约数，
找到大于等于 P 的最小约数，记为 C，那么答案就是 C-P。
当然，我们也可以直接从 (Q+Y)/(P+Y) 这个表达式入手，它随着 Y 的增加而单调递减。当 Y>ceil(sqrt(Q)) 时：
\frac{B+Y}{A+Y} < \frac{B+\left \lceil \sqrt{B} \right \rceil}{A+\left \lceil \sqrt{B} \right \rceil} < \frac{B+\left \lceil \sqrt{B} \right \rceil}{\left \lceil \sqrt{B} \right \rceil} \le 1+\left \lceil \sqrt{B} \right \rceil
---
因此，当 Y>ceil(sqrt(Q)) 且 (Q+Y)/(P+Y) 是整数时，(Q+Y)/(P+Y) 的值不会超过 Y>ceil(sqrt(Q))。
于是我们就可以在 0 ~ sqrt(Q) 的范围内，对于每个 2 <= i <= ceil(sqrt(Q))，枚举非负整数 Y，找到满足
Q + X = Y(P+X) 的最小值 X。这样就可以找到最小的满足条件的 Y。
于是，我们就可以在 0 ~ ceil(sqrt(Q)) 的范围内，枚举满足 Q+Y 可以被 P+Y 整除的非负整数 Y，找到其中最小的即可。
 */