package lq240518;

import java.util.Scanner;

public class LQ240518T4 {
    static int n, x, y, a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int v = Math.min(b / x, n / y);
        if (v == 0) return "-1";

        int m = n - v * y;
        int w = Math.min(a / x, m / y);
        w = Math.min(w, v - 1);
        return String.valueOf(v + w);
    }
}
/*
玩偶购买【算法赛】

贪心策略：优先给小桥买玩偶。
由于要保证小桥购买的玩偶数量大于小蓝购买的玩偶数量。直观的想法是小桥尽量买多点玩偶，这样小蓝可购买的玩偶的数量上限也会变高。
对于小桥来说，限制她购买的因素有钱的数量和衣柜的大小，设她最多可买的玩偶数为 v，则有：v = min(b/x, n/y)
若此时 v 等于 0，则说明不存在符合条件的购买方式，输出 -1 即可。
当小桥购买后，我们再来考虑小蓝最多可购买的数量，设此时剩余的钱数为 m，则有 m = n - vy。
对于小蓝来说，限制他购买的因素有钱的数量和衣柜的大小 以及 小桥购买的数量，设他最多可买的玩偶数为 w，则有：w = min(a/x, m/y, v-1)。
最终答案为 v + w。
 */